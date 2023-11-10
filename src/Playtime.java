import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Playtime {

    public static final int COL_NAME = 0;
    public static final int COL_YEAR = 1;
    public static final int MIN_PLAYTIME = 2;
    public static final int MAX_PLAYTIME = 3;

    public static final String[] LABELS = {"30 - 60", "60 - 120", "120 - 180", "180 -"};

    public static void main(String[] args) throws IOException {
        
        try (FileReader fr = new FileReader(args[0])) {
            BufferedReader br = new BufferedReader(fr);
            
            Map<Integer, List<Games>> categorized = br.lines()
            .skip(1) //skip first line because it is the header names
            .map(row ->row.trim().split(",")) // String -> String[] - stream goes through the row one row at a time
            .map(columns -> new Games(columns[COL_NAME], 
                columns[COL_YEAR], 
                Integer.parseInt(columns[MIN_PLAYTIME]), // from string to integer
                Integer.parseInt(columns[MAX_PLAYTIME])))
            // Implementations of Collector that implement various useful reduction operations, such as accumulating elements into collections, summarizing elements according to various criteria, etc.
            .collect(Collectors.groupingBy(game -> { // 
                int dur = game.getDuration();
                if ((30 <= dur) && (dur<60)){
                    return 0;
                } else if ((60 <= dur)&&(dur < 120 )){
                    return 1;
                } else if ((120 <= dur) && (dur < 180)){
                    return 2;
                } return 3;
            }));
            
            for (int i =0; i <LABELS.length; i++){
                System.out.printf("\nDuration: %s mins\n", LABELS[i]);
                System.out.printf("===============================\n");
                for (Games g: categorized.get(i)) {
                    System.out.printf("%s: %s\n", g.getName(), g.getYear());
                }
            }
        }
    }
}