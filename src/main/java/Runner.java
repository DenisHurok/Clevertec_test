
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args)  {

        SaleCards card = new SaleCards();
        Map<Integer, Integer> amountAndId = new HashMap<>();
        String regex = "card\\d+";

//чтение из файла
        try {
            String fileName = "src\\main\\java\\fileInput";
            Scanner sc = new Scanner(new FileReader(fileName));
            while (sc.hasNext()) {
                String[] file = sc.next().split("-");
                for (String str : file) {
                    if (str.matches(regex)) {
                        card = new SaleCards(str);
                    } else {
                        amountAndId.put(Integer.parseInt(file[0]), Integer.parseInt(file[1]));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Not Found");
        }


//чтение аргментов командной строки
        for (String str : args) {
            if (str.matches(regex)) {
                card = new SaleCards(str);
            } else {
                String[] idandamount = str.split("-");
                amountAndId.put(Integer.parseInt(idandamount[0]), Integer.parseInt(idandamount[1]));
            }
        }

        Check check = new Check(amountAndId, card);
//печать в файл
        check.printInFile();

    }

}