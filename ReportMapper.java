package dragunovskiy_sergey.csv_parser;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface ReportMapper<T> {
    List<T> readAll(List<String[]> listOfLines) throws ParseException;
    void populateMap(Map<Status, List<MachineReport>> map, List<MachineReport> reportList);
    void populateMapParallel(Map<Status, List<MachineReport>> map, List<MachineReport> reportList) throws InterruptedException;
}
