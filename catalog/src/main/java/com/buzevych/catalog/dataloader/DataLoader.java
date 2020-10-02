package com.buzevych.catalog.dataloader;

import com.buzevych.catalog.mapper.CatalogItemMapper;
import com.buzevych.catalog.repository.entity.CatalogItem;
import com.buzevych.catalog.repository.CatalogRepository;
import model.ProductRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import parser.CSVParser;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataLoader {

    @Value("classpath:data/samp.csv")
    private String loadFilePath;

    @Autowired
    private CatalogRepository catalogRepository;
    @Autowired
    private CatalogItemMapper mapper;

    private CSVParser<ProductRow> csvParser;

    @PostConstruct
    public void loadData() throws IOException {
        csvParser = new CSVParser<>(ProductRow.class);
        File file = ResourceUtils.getFile(loadFilePath);

        List<ProductRow> rows = csvParser.readItemsFromCSV(file);

        List<CatalogItem> catalogItems = rows.stream().map(mapper::fromRow).collect(Collectors.toList());

        catalogRepository.saveAll(catalogItems);
    }
}
