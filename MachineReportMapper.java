package dragunovskiy_sergey.csv_parser;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MachineReportMapper implements ReportMapper<MachineReport> {
    private MapFiling mapFiling = new MapFiling();

    @Override
    public List<MachineReport> readAll(List<String[]> listOfLines) throws ParseException {
        List<MachineReport> listOfMachineReportsObjects = new ArrayList<>();
        for (String[] line : listOfLines) {
            setNewMachineReport(line, listOfMachineReportsObjects);
        }
        return listOfMachineReportsObjects;
    }

    @Override
    public void populateMap(Map<Status, List<MachineReport>> map, List<MachineReport> list) {
        List<MachineReport> listStatusF = new ArrayList<>();
        List<MachineReport> listStatusR = new ArrayList<>();
        List<MachineReport> listStatusC = new ArrayList<>();


        for (MachineReport report : list) {
            if (report.getStatus().equals(Status.F)) {
                listStatusF.add(report);
            } else if (report.getStatus().equals(Status.R)) {
                listStatusR.add(report);
            } else {
                listStatusC.add(report);
            }
        }
        map.put(Status.F, listStatusF);
        map.put(Status.R, listStatusR);
        map.put(Status.C, listStatusC);

        System.out.println("F :" + listStatusF.size() + " reports");
        System.out.println("R :" + listStatusR.size() + " reports");
        System.out.println("C :" + listStatusC.size() + " reports");
    }

    @Override
    public void populateMapParallel(Map<Status, List<MachineReport>> map, List<MachineReport> list) throws InterruptedException {
        List<MachineReport> listStatusF = new ArrayList<>();
        List<MachineReport> listStatusR = new ArrayList<>();
        List<MachineReport> listStatusC = new ArrayList<>();

        map.put(Status.F, listStatusF);
        map.put(Status.R, listStatusR);
        map.put(Status.C, listStatusC);

        Thread t1 = new Thread(() -> mapFiling.mapFiling(list, map, 0, list.size() / 2));
        Thread t2 = new Thread(() -> mapFiling.mapFiling(list, map, list.size() / 2, list.size()));

        t1.start();
        t2.start();
        t2.join();

        System.out.println("F :" + listStatusF.size() + " reports");
        System.out.println("R :" + listStatusR.size() + " reports");
        System.out.println("C :" + listStatusC.size() + " reports");
    }

    private void setNewMachineReport(String[] line, List<MachineReport> listOfMachineReportsObjects) throws ParseException {
        MachineReport newReport = new MachineReport();
        newReport.setSeriesReference(line[0]);
        Date date = new SimpleDateFormat("yyyy.MM").parse(line[1]);
        newReport.setPeriod(date);

        newReport.setDataValue(line[2]);

        if (line[3].equals("true")) {
            newReport.setSuppressed(true);
        } else {
            newReport.setSuppressed(false);
        }

        if (line[4].equals("F")) {
            newReport.setStatus(Status.F);
        } else if (line[4].equals("R")) {
            newReport.setStatus(Status.R);
        } else {
            newReport.setStatus(Status.C);
        }

        newReport.setUnits(line[5]);
        newReport.setMagnitude(line[6]);
        newReport.setSubject(line[7]);
        newReport.setGroup(line[8]);
        newReport.setSeriesTitle1(line[9]);
        newReport.setSeriesTitle2(line[10]);
        newReport.setSeriesTitle3(line[11]);
        newReport.setSeriesTitle4(line[12]);
        newReport.setSeriesTitle5(line[13]);
        listOfMachineReportsObjects.add(newReport);
    }
}
