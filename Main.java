import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        boolean Flag = true;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the expression: ");
        String expression = scanner.nextLine();
        String[] arr_of_strings = expression.split(" ");

        try {
            String Number_1 = arr_of_strings[0];
            String Number_2 = arr_of_strings[2];
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("throws Exception //т.к. строка не является математической операцией");
            Flag = false;
        }
        boolean Flag_1 = true;
        boolean Flag_2 = true;

        if (arr_of_strings.length > 3){
            System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            Flag = false;
        }

        if (Flag) {


            try {
                double Num_1 = Double.parseDouble(arr_of_strings[0]);
            } catch (NumberFormatException e) {
                Flag_1 = false;
            }

            try {
                double Num_2 = Double.parseDouble(arr_of_strings[2]);
            } catch (NumberFormatException e) {
                Flag_2 = false;
            }


            if (((Flag_1 == false) && (Flag_2 == true)) || ((Flag_1 == true) && (Flag_2 == false))) {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            }

            if ((Flag_1 == true) && (Flag_2 == true)) {
                double result;
                double Num_1 = Double.parseDouble(arr_of_strings[0]);
                double Num_2 = Double.parseDouble(arr_of_strings[2]);

                switch (arr_of_strings[1]) {

                    case "+":

                        result = (double) Num_1 + Num_2;
                        String[] splitter_0 = String.valueOf(result).split("\\.");
                        if (Integer.parseInt(splitter_0[1]) == 0) {
                            int res = (int) result;
                            System.out.println(res);
                            break;
                        }
                        System.out.println(result);
                        break;
                    case "*":
                        result = (double) Num_1 * Num_2;
                        String[] splitter_1 = String.valueOf(result).split("\\.");
                        if (Integer.parseInt(splitter_1[1]) == 0) {
                            int res = (int) result;
                            System.out.println(res);
                            break;
                        }
                        System.out.println(result);
                        break;
                    case "/":
                        result = (double) Num_1 / Num_2;
                        String[] splitter_2 = String.valueOf(result).split("\\.");
                        if (Integer.parseInt(splitter_2[1]) == 0) {
                            int res = (int) result;
                            System.out.println(res);
                            break;
                        }
                        System.out.println(result);
                        break;
                    case "-":
                        result = (double) Num_1 - Num_2;
                        String[] splitter_3 = String.valueOf(result).split("\\.");

                        if (Integer.parseInt(splitter_3[1]) == 0) {
                            int res = (int) result;
                            System.out.println(res);
                            break;
                        }
                        System.out.println(result);
                        break;
                }
            }

            if ((Flag_1 == false) && (Flag_2 == false)) {

                int result;
                int Num_1 = Convert(arr_of_strings[0]);
                int Num_2 = Convert(arr_of_strings[2]);

                switch (arr_of_strings[1]) {
                    case "+":
                        result = Num_1 + Num_2;
                        System.out.println(intTo(result));
                        break;
                    case "*":
                        result = Num_1 * Num_2;
                        System.out.println(intTo(result));
                        break;
                    case "/":
                        result = Num_1 / Num_2;
                        System.out.println(intTo(result));
                        break;
                    case "-":
                        if (Num_2 > Num_1) {
                            System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                            break;
                        }
                        result = Num_1 - Num_2;
                        System.out.println(intTo(result));
                        break;
                }
            }
        }
    }
    static int value(char a) {
        if (a=='m') return 1000;
        else if (a=='d') return 500;
        else if (a=='c') return 100;
        else if (a=='l') return 50;
        else if (a=='x') return 10;
        else if (a=='v') return 5;
        else if (a=='i') return 1;
        else return 0;
    }
    public static int Convert(String roman) {

        roman=roman.toLowerCase();
        int val=0;
        int val_next=0;
        int temp=0;
        int result=0;

        for (int i=0;i<roman.length();i++) {
            val=value(roman.charAt(i));
            if (i<roman.length()-1) {
                val_next=value(roman.charAt(i+1));
            } else val_next=0;

            if (val_next==0) {
                temp=val;
            } else {
                if (val>val_next) temp=val;
                else if (val<val_next) {
                    temp=val_next-val;
                    i++;
                } else if (val==val_next) temp=val;
            }
            result+=temp;
        }
        return result;
    }
    public static String intTo(int number)
    {

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[number / 1000] + hundreds[(number % 1000) / 100] + tens[(number % 100) / 10] + units[number % 10];
    }

}

