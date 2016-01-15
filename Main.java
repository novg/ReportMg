import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by NovgorodskiyAK on 11.01.2016.
 */
public class Main {
    public static void main(String[] args) {
        String fileName = "";

        if (args.length == 0) {
            System.out.println("usage: reportmg excelFile");
            System.exit(-1);
        } else {
            fileName = args[0];
            System.out.println(fileName);
            if (!(fileName.endsWith(".xls") || fileName.endsWith(".xlsx"))) {
                System.out.println("require excel file");
                System.exit(-1);
            }
        }

        long startTime = System.currentTimeMillis();

        Report report = new Report(fileName);
        report.create();

        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }
}
