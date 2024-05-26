import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
    int hours = Integer.parseInt(s.substring(0, 2));
    int min = Integer.parseInt(s.substring(3, 5));
    int seconds = Integer.parseInt(s.substring(6, 8));
    
    String indicator = s.substring(8, 10);
    if(hours == 12 && indicator.equals("AM"))
        hours = 0;
    else if(indicator.equals("PM") && hours != 12)
        hours += 12;
        
    return String.format("%02d:%02d:%02d", hours, min, seconds);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
