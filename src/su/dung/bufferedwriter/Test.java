package su.dung.bufferedwriter;

import tinh.tong.cac.so.trong.file.text.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Student> studentList0 = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("test_file_object.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String string[] = line.split(";");
                String name = string[0];
                int age = Integer.parseInt(string[1]);
                double mark = Double.parseDouble(string[2]);
                studentList0.add(new Student(name, age, mark));
                System.out.println(line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
