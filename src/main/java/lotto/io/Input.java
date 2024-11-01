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

    public static String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        try{
            validateBonusNumber();
        } catch (IllegalArgumentException e) {
            return inputBonusNumber();
        }
        return bonusNumber;
    }

    private static void validatePrice() {

    }

    private static void validateWinningNumber() {

    }

    private static void validateBonusNumber() {

    }

}
