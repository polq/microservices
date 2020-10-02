package parser;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import lombok.AllArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.List;

@AllArgsConstructor
public class CSVParser<T> {

    private final Class<T> type;

    public List<T> readItemsFromCSV(File fileName) throws IOException {
        ColumnPositionMappingStrategy<T> ms = new ColumnPositionMappingStrategy<>();
        ms.setType(type);

        Reader reader = Files.newBufferedReader(fileName.toPath());
        CsvToBean<T> cb = new CsvToBeanBuilder<T>(reader)
                .withType(type)
                .withIgnoreQuotations(false)
                .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
                .withMappingStrategy(ms)
                .build();

        return cb.parse();
    }
}
