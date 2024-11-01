package lotto;

import static lotto.AppConstants.INPUT_NOT_INTEGER;
import static lotto.AppConstants.LOTTO_PRICE;
import static lotto.AppConstants.MONEY_LESS_THAN_1000;
import static lotto.AppConstants.MONEY_NOT_DIVIDED_BY_1000;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public static int inputLottoPurchaseMoney(String display) {
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println(display);
            String input = Console.readLine();
            try {
                number = Integer.parseInt(input);
                validatePurchaseCondition(number);
                validInput = true;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(INPUT_NOT_INTEGER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return number;
    }

    private static void validatePurchaseCondition(int money) throws IllegalArgumentException{
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(MONEY_LESS_THAN_1000);
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_NOT_DIVIDED_BY_1000);
        }
    }
}
