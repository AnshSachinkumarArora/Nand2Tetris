import java.io.*;
import java.lang.*;

public class Assembler {

    public static String aInstruction(String s) {
        String temp = Integer.toBinaryString(Integer.parseInt(s));
        return ("0" + String.format("%15s", temp).replace(' ', '0'));
    };

    public static void cInstruction(String s) {
        String dest;
        String comp;
        String jump;
        if(s.contains("=")) {
            String[] temp1 = s.split("=");
            dest = temp1[0];
            if(temp1[1].contains(";")) {
                String[] temp2 = temp1[0].split(";");
                comp = temp2[0];
                jump = temp2[1];
            } else {
                comp = temp1[1];
                jump = "";
            }
        } else if (s.contains(";")) {
            String[] temp1 = s.split(";");
            comp = temp1[0];
            jump = temp1[1];
            dest = "";
        } else {
            comp = s;
            jump = "";
            dest = "";
        }
        System.out.println("Dest: " + dest + " Comp: " + comp + " Jump: " + jump);
    };

    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("MaxL.asm");
        BufferedReader buffer = new BufferedReader(file);

        String s;

        while((s = buffer.readLine()) != null) {
            if(s.length() == 0 || s.charAt(0) == '/') {
                continue;
            } else if (s.charAt(0) == '@') {
                s = s.replace("@", "");
                String temp = aInstruction(s);
                System.out.println(temp);
            } else {
                cInstruction(s);
            }
        }
    }
}
