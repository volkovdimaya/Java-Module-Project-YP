import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    double sum;
    Scanner scaner = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<>();


    private String IputName() {
        System.out.println("Введите название товара");
        String name = scaner.next();
        return name;
    }

    private double InputCost() {
        while (true) {
            System.out.println("Введите стоимость");
            try {
                double cost = scaner.nextDouble();
                if (cost <= 0) {
                    System.out.println("Стоимость не может быть меньше 0");
                    scaner.nextLine();
                    continue;
                }
                return cost;


            } catch (Exception e) {
                System.out.println("Ошибка, попробуйте еще раз");
                scaner.nextLine();
            }
        }
    }

    public void AddProduct() {
        while (true) {
            System.out.println("Добавление товара в калькулятор");

            Product product = new Product(IputName(), InputCost());
            products.add(product);
            sum += product.cost;

            System.out.println("Товар " + product.name + " успешно добавлен!");
            System.out.println("Продолжить добовление товара?");
            System.out.println("Ввести команду \"Завершить\" для того, чтоб завершить процесс добавления товаров");

            String comand = scaner.next();
            if (comand.equalsIgnoreCase("Завершить")) {
                break;
            }
        }

    }

    public void ShowProducts() {
        FormatterRub f = new FormatterRub();//для форматирования окончания рубля
        System.out.println("Добавленные товары:");
        for (Product product : products) {
            System.out.println("Товар: " + product.name + " цена: " + product.cost + " " + f.correctEnding(product.cost));
        }
    }

    public void ShowResult(int countHuman) {
        FormatterRub f = new FormatterRub();
        System.out.println("Всего товаров на сумму: " + sum + " " + f.correctEnding(sum));
        double result = sum / countHuman;


        String text = "Каждый должен заплатить: %.2f %s";

        System.out.println(String.format(text, result, f.correctEnding(result)));
    }

}
