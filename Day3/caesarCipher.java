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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
    List<Character> alphabet = Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        );
        
    List<Character> shiftedChars = new ArrayList<>(alphabet);
    k %= 26;
    for(int i = 0; i < 26; i++){
        if(i+k < 26){
            shiftedChars.set(i, alphabet.get(i+k));
        } else {
            shiftedChars.set(i, alphabet.get(i+k-26));
        }
    }
    
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < s.length(); i++){
        char ch = s.charAt(i);
        if(Character.isUpperCase(ch)){
            result.append(shiftedChars.get((int)ch-'A'));
        } else if(Character.isLowerCase(ch)){
            result.append(Character.toLowerCase(shiftedChars.get((int)ch - 'a')));
        } else {
            result.append(ch);
        }
    }
    return result.toString();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
