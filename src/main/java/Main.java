
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Добрый день");
        Scanner scaner = new Scanner(System.in);
        int input = 0;
        while (true) {
            System.out.println("На сколько человек необходимо разделить счёт?");
            if (scaner.hasNextInt()) {
                input = scaner.nextInt();
                if (input == 1) {
                    System.out.println("Нет смысла ничего считать и делить");
                } else if (input < 1) {
                    System.out.println("Это некорректное значение для подсчёта");
                } else if (input > 1) {
                    Calculator cal = new Calculator();
                    cal.addProduct();
                    cal.showProducts();
                    cal.showResult(input);
                    break;
                }
            } else {
                System.out.println("Ошибка, попробуйте еще раз");
                scaner.nextLine();
            }
        }
    }
}

