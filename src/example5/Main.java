package example5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DBWorker worker = new DBWorker();
        List<Res1> res1List = worker.getAllRes1();
        List<Res2> res2List = worker.getAllRes2();
        List<Res3> res3List = worker.getAllRes3();
        File file1 = new File("result1.txt");
        File file2 = new File("result2.txt");
        File file3 = new File("result3.txt");

        try (FileWriter fr = new FileWriter(file1)) {
            fr.append("1.      Отримайте контактні дані співробітників (номери телефонів, місце проживання). \n");
            for (Res1 r : res1List) {
                String s = (r.getName() + " | " + r.getPhone() + " | " + r.getAddress() + "\n");
                fr.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fr = new FileWriter(file2)) {
            fr.append("2.      Отримайте інформацію про дату народження всіх неодружених співробітників та їхні номери. \n");
            for (Res2 r : res2List) {
                String s = (r.getName() + " | " + r.getDate() + " | " + r.getPhone() + "\n");
                fr.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fr = new FileWriter(file3)) {
            fr.append("3.      Отримайте інформацію про всіх менеджерів компанії: дати народження та номери телефонів. \n");
            for (Res3 r : res3List) {
                String s = (r.getName() + " | " + r.getDate() + " | " + r.getPhone() + "\n");
                fr.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


