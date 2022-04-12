package su.dung.bufferedwriter;

import tinh.tong.cac.so.trong.file.text.Student;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String array[] = {"ho ho", "hi hi", "he he"};
        Student student[] = new Student[4];
        System.out.println("------------ " + student.length);
        student[0] = new Student("Ho", 10, 8.9);
        student[1] = new Student("Anh", 11, 8.8);
        student[2] = new Student("Dung", 12, 8.7);
        student[3] = new Student("Ho Anh Dung", 13, 8.6);
        Student student1 = new Student("Dung", 25, 8.8);
        Student student2 = new Student("Dung1", 24, 8.7);
        Student student3 = new Student("Dung2", 23, 8.6);
        Student student4 = new Student("Dung3", 22, 8.5);
        List<Student> studentList = new ArrayList<>();
        for (Student i : student) {
            studentList.add(i);
        }
        for (int i = 0; i < student.length; i++) {
            System.out.println("----------- " + studentList.get(i));
        }

        try {
            FileWriter fileWriter = new FileWriter("test_file_object.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < student.length; i++) {
                bufferedWriter.newLine();
                bufferedWriter.write(student[i].toString());
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader("test_file_object.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            System.out.println("=====================------------");
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String string[] = line.split("; ");
                String name = string[0];
                int age = Integer.parseInt(string[1]);
                double mark = Double.parseDouble(string[2]);
                studentList.add(new Student(name,age,mark));
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("testfile.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Ho Anh Dung 973");
            bufferedWriter.newLine();
            bufferedWriter.write("ha ha ha");
            bufferedWriter.newLine();
            bufferedWriter.write(student1.toString());
            for (String s : array) {
                bufferedWriter.newLine();
                bufferedWriter.write(s);
            }

            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {

        }
    }
}
