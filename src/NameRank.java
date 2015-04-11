/**
 * Name: Aharon Mishiev 
 * CISC3150 
 * HW#5 
 * PART I
 */
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

public class NameRank {

   public static void main(String[] args) {
        try (PrintWriter output = new PrintWriter("output.txt")) {

            output.println("Year\t" + "Rank 1\t" + "Rank 2\t" + "Rank 3\t"
                    + "Rank 4\t" + "Rank 5\t" + "Rank 1\t" + "Rank 2\t"
                    + "Rank 3\t" + "Rank 4\t" + "Rank 5\t");
            for (int i = 2001; i < 2011; i++) {
                String fileName = i + ".txt";
                File file = new File(fileName);
                if (!file.exists()) {
                    throw new Exception("File was not found!");
                }
                Scanner input = new Scanner(file);
                rankPrint(file, input, output);
                input.close();
            }
            output.flush();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public static void rankPrint(File file, Scanner input, PrintWriter output){
        String[] boyName = new String[5];
        String[] girlName = new String[5];
        int count = 0;
        while (count < 5) {
            int i = input.nextInt();
            boyName[count] = input.next();
            i = input.nextInt();
            girlName[count] = input.next();
            String str = input.nextLine();
            count++;
        }
        String fileName = file.getName();
        fileName = fileName.substring(0, 4);
        output.flush();
        output.print(fileName);
        for (int i = 0; i < count; i++) {
            output.print("\t" + girlName[i]);
        }
        output.flush();
        for (int i = 0; i < count; i++) {
            output.print("\t" + boyName[i]);
        }
        output.println();
    }
}