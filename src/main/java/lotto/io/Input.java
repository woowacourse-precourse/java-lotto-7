package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String inputPrice() {
        String price = Console.readLine();
        try {
            validatePrice();
        } catch (IllegalArgumentException e) {
            return inputPrice();
        }
        return price;
    }

    private static void validatePrice() {

    }
}
