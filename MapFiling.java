package dragunovskiy_sergey.csv_parser;



import java.util.List;
import java.util.Map;

public class MapFiling {
    public void mapFiling(List<MachineReport> list, Map<Status, List<MachineReport>> map, int start, int finish) {

        synchronized (map) {
            for (int i = start; i < finish; i++) {
                if (list.get(i).getStatus().equals(Status.F)) {
                    map.get(Status.F).add(list.get(i));
                } else if (list.get(i).getStatus().equals(Status.R)) {
                    map.get(Status.R).add(list.get(i));
                } else {
                    map.get(Status.C).add(list.get(i));
                }
            }
        }
    }
}

