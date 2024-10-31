package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.function.Supplier;

public class Input {
    protected static int money() {
        String input = Console.readLine();

        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
        int money = Integer.parseInt(input);
        if (money % 1000 != 0 || money <= 0) {
            throw new IllegalArgumentException("[ERROR] 1000의 양의 배수만 입력하세요");
        }

        return money;
    }

    public static <T> T read(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
