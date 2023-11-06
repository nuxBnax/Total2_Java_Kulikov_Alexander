import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<Toy> toyList = new ArrayList<>();

    public static void main(String[] args) {
        put();
        if (toyList.isEmpty()) {
            System.out.println("Вы ничего не ввели");
            return;
        }
        int times = 10;
        for (int i = 0; i < times; i++) {
            get(toyList);
        }
    }

    /**
     * Метод позволяет ввести данные об игрушке, выводит информацию в консоль о том какие данные об игрушках в итоге были
     * введены и какова теоретическая вероятность выпадения игрушки при розыгрыше.
     * @return
     */
    static ArrayList<Toy> put() {
        Scanner read = new Scanner(System.in);
        boolean flag = true;
        int counter = 1;
        while (flag) {
            System.out.println("Введите вес названиеИгрушки (id будет присвоен автоматически) \n" +
                    "(Пример ввода: 2 Конструктор) \n" +
                    "или введите q или й для того чтобы закончить ввод.");
            String input = read.nextLine();
            if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("й")) {
                flag = false;
                if (!toyList.isEmpty()) {
                    System.out.println("Был введен следующий массив данных");
                    for (Toy item : toyList) {
                        double share = (double) (item.getRate() * 100) / summaryRate(toyList);
                        String result = String.format("%.2f",share);
                        System.out.println(item + " - вероятность(теоретическая) выпадения - " + result + "%");
                    }
                    System.out.println("Ваши данные успешно добавлены в массив \n" +
                            "Результаты розыгрыша Вы можете просмотреть в файле toyRaffle.txt");
                }
            } else {
                String[] arrayInput = input.split(" ");
                toyList.add(new Toy(counter, Integer.parseInt(arrayInput[0]), arrayInput[1]));
                counter++;
            }
        }
        return toyList;
    }

    /**
     * Метод генерирует случайное число и сравнивает с id в массиве toyList и если происходит совпадение, то записывает
     * в файл
     * @param toyList
     */
    static void get(ArrayList<Toy> toyList) {
        int starter = 1;
        Random random = new Random();
        int number = random.nextInt(1, summaryRate(toyList));
        for (Toy item : toyList) {
            for (Integer num : generate(item.getRate(), starter)) {
                if (number == num) {
                    writer(item);
                }
            }
            starter = starter + item.getRate();
        }
    }

    /**
     * Метод записывает данные в файл toyRaffle.txt
     * @param toy
     */
    static void writer(Toy toy) {
        String fileName = "toyRaffle.txt";
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(toy + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод суммирует все веса (частоты выпадения)
     * @param toyList
     * @return сумму веса(частоты выпадения при розыгрыше)
     */
    static int summaryRate(ArrayList<Toy> toyList) {
        int sum = 0;
        for (Toy item : toyList) {
            sum += item.getRate();
        }
        return sum;
    }

    /**
     * Метод генерирует числа от start продолжительностью в rate
     * @param rate  частота(вес)
     * @param start начальное число
     * @return HashSet
     */
    static HashSet<Integer> generate(int rate, int start) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = start; i < rate + start; i++) {
            hs.add(i);
        }
        return hs;
    }
}