package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Lab_1 {

    public Lab_1() {
        this.input = readFile();

        step = (int) (5 + Math.random() * 69);
        step %= 33;

        Start();
        writeFile(output);
    }

    private void Start ()
    {
        StringBuilder s = new StringBuilder();

        char c;
        for (int i=0; i< input.length(); i++)
        {
            c = input.charAt(i);

            if ((int) c >= 1040 && (int) c <= 1071)
                c = Large(c);
            else if ((int) c >= 1072 && (int) c <= 1103)
               c = Small(c);

            s.append(c);
        }

        output = s.toString();
    }

    private char  Small (char c)
    {
        int bof = (int) c + step;
        if (bof > 1103)
        {
            bof -= 1103;
            bof = (int) 'а' + bof;
        }

        return (char) bof;
    }

    private  char Large (char c)
    {
        int bof = (int) c + step;

        if (bof > 1071)
        {
            bof -= 1071;
            bof = (int) 'А' + bof;
        }

        return (char) bof;
    }

    private int step;
    private String input;
    private String output;

    private String readFile()
    {
        StringBuilder input = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./src/com/company/read.txt"), StandardCharsets.UTF_8)))
        {
            String line;

            while ((line = reader.readLine()) != null)
                input.append(line).append('\n');
        }
        catch (IOException e) { System.err.println(e.getMessage()); }

        return input.toString();
    }

    private void writeFile(String output)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./src/com/company/write.txt"))) { writer.write(output); }
        catch (IOException e) { System.err.println(e.getMessage());}
    }

}

