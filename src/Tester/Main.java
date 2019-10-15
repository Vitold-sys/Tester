package Tester;

import java.io.IOException;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Converter converter = new Converter();
        Scanner in = new Scanner(System.in);
        try {
            while(true) {
                System.out.println("Пожалуйста введите число:");

                BigInteger number = in.nextBigInteger();
                System.out.println("Ваш результат перевод числа из цифровой записи в строковую:");
                System.out.println(converter.converter(number));
                break;
            }
        }catch(InputMismatchException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
