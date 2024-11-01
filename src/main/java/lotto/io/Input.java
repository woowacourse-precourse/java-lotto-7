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

    public static String inputWinningNumber() {
        String winningNumber = Console.readLine();
        try{
            validateWinningNumber();
        } catch (IllegalArgumentException e) {
            return inputWinningNumber();
        }
        return winningNumber;
    }

    private static void validatePrice() {

    }

    private static void validateWinningNumber() {

    }

}
