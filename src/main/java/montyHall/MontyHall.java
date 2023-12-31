package montyHall;

import java.util.Random;

public class MontyHall {
    public static void main(String[] arg) {

        int countWin = 0; // счётчик побед без смены выбора
        int countGames = 100_000; // число проверяемых игр
        Random random = new Random();

        for (int i = 0; i < countGames; i++) {
            int[] arr = new int[3]; // имитация трёх дверей, где 0 - это козел
            arr[random.nextInt(3)] = 1; // случайным образом в одну дверь назначаем 1 - автомобиль
            /*
             * Имитация выбора случайной двери. Если сразу попали на автомобиль, то увеличиваем счётчик побед
             * когда не меняли выбор двери.
             * */
            if (arr[random.nextInt(3)] == 1) countWin++;
        }
        System.out.printf("\nПроцент побед без смены выбора двери составил - %.2f%%, " +
                        "когда процент побед со сменой выбора: %.2f%%\n",
                (float) countWin / countGames * 100.0,
                /*
                 * все варианты, когда мы не угадали с первого раза,
                 * автоматически становятся вариантом победы, если бы мы изменили выбор
                 */
                (float) (countGames - countWin) / countGames * 100.0);
    }
}
