package dragunovskiy_sergey.csv_parser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVParser {

    public List<String[]> parseCSVToStringArrays() throws IOException, CsvException {
        List<String[]> listOfParseCVSLines;
        String fileName = "path_to_file";
        CSVReader reader = new CSVReader(new FileReader(fileName));
        listOfParseCVSLines = reader.readAll();
        listOfParseCVSLines.remove(0);
        return listOfParseCVSLines;
    }
}
