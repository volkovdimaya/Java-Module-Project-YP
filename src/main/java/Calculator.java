import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private double sum;
    private Scanner scaner = new Scanner(System.in);
    private ArrayList<Product> products = new ArrayList<>();
    private String iputName() {
        System.out.println("Введите название товара");
        String name = scaner.next();
        return name;
    }

    private double inputCost() {
        while (true) {
            System.out.println("Введите стоимость");
            if (scaner.hasNextDouble()) {
                double cost = scaner.nextDouble();
                if (cost <= 0) {
                    System.out.println("Стоимость не может быть меньше 0");
                    scaner.nextLine();
                    continue;
                }
                return cost;
            } else {
                System.out.println("Ошибка, попробуйте еще раз");
                scaner.nextLine();
            }
        }
    }

    public void addProduct() {
        while (true) {
            System.out.println("Добавление товара в калькулятор");
            Product product = new Product(iputName(), inputCost());
            products.add(product);
            sum += product.cost;
            System.out.println(String.format("Товар %s успешно добавлен!", product.name));
            System.out.println("Продолжить добовление товара?");
            System.out.println("Ввести команду \"Завершить\" для того, чтоб завершить процесс добавления товаров");

            String comand = scaner.next();
            if (comand.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
    }

    public void showProducts() {
        FormatterRub formatterRub = new FormatterRub();//для форматирования окончания рубля
        System.out.println("Добавленные товары:");
        String message = "Товар: %s цена: %.2f %s";
        for (Product product : products) {
            System.out.println(String.format(message, product.name, product.cost, formatterRub.correctEnding(product.cost)));
        }
    }

    public void showResult(int countHuman) {
        FormatterRub formatterRub = new FormatterRub();
        System.out.println(String.format("Всего товаров на сумму:  %.2f %s", sum,  formatterRub.correctEnding(sum)));
        double result = sum / countHuman;

        String text = "Каждый должен заплатить: %.2f %s";
        System.out.println(String.format(text, result, formatterRub.correctEnding(result)));
    }

}
