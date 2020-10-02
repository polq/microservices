package org.buzevych.inventory.dataloader;

import model.ProductRow;
import org.buzevych.inventory.mapper.InventoryMapper;
import org.buzevych.inventory.repository.InventoryRepository;
import org.buzevych.inventory.repository.entity.InventoryItem;
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
    private InventoryRepository inventoryRepository;
    @Autowired
    private InventoryMapper mapper;

    private CSVParser<ProductRow> csvParser;

    @PostConstruct
    public void loadData() throws IOException {
        csvParser = new CSVParser<>(ProductRow.class);

        File file = ResourceUtils.getFile(loadFilePath);

        List<ProductRow> rows = csvParser.readItemsFromCSV(file);

        List<InventoryItem> items = rows.stream().map(mapper::fromProductRow).collect(Collectors.toList());

        inventoryRepository.saveAll(items);
    }
}
