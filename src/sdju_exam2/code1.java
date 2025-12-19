package sdju_exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class code1 {
    public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String s = reader.readLine();
       if (s == null) {
           return;
       }

       StringBuilder output = new StringBuilder(s.length());
       for (int i = 0; i < s.length(); i++) {
             char currentChar = s.charAt(i);
             if (currentChar == '5') {
                    output.append('*');
             } else {
                    output.append(currentChar);
             }
       }
         System.out.println(output.toString());
    }
}
