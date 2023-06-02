package dragunovskiy_sergey.csv_parser;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) throws IOException, CsvException, ParseException, InterruptedException {

        // I compared parallel execution and non-parallel execution

        List<String[]> list;
        CSVParser csvParser = new CSVParser();
        list = csvParser.parseCSVToStringArrays();
        MachineReportMapper machineReportMapper = new MachineReportMapper();
        machineReportMapper.readAll(list);

        Map<Status, List<MachineReport>> statusListMap = new HashMap<>();
        Map<Status, List<MachineReport>> statusListMap1 = new ConcurrentHashMap<>();

        System.out.println("Starting non-parallel execution");
        long time = System.currentTimeMillis();
        machineReportMapper.populateMap(statusListMap, machineReportMapper.readAll(list));
        System.out.println(System.currentTimeMillis() - time + " ms");

        System.out.println("==================");

        long time2 = System.currentTimeMillis();
        System.out.println("Starting parallel execution");
        machineReportMapper.populateMapParallel(statusListMap1, machineReportMapper.readAll(list));
        System.out.println(System.currentTimeMillis() - time2 + " ms");
    }

}
