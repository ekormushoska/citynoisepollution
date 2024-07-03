import java.io.*;
import java.util.concurrent.TimeUnit;

public class SoundLevelMonitor {
    public static void main(String[] args) throws IOException, InterruptedException {
        PrintWriter pw = new PrintWriter("/shared-folder/noisepollution.txt");
        BufferedReader br = new BufferedReader(new FileReader("/shared-folder/soundlevel.txt"));
        String line;

        // Process each line from soundlevel.txt
        while ((line = br.readLine()) != null) {
            int number = Integer.parseInt(line);

            // Determine noise level based on the current number
            if (number>= 40 && number <= 60) {
                pw.println("Low");
            } else if (number > 60 && number <= 80) {
                pw.println("Medium");
            } else {
                pw.println("High");
            }

            pw.flush();
            TimeUnit.SECONDS.sleep(20); // Wait 20 seconds before reading the next value
        }

        pw.close();
        br.close();
    }
}
