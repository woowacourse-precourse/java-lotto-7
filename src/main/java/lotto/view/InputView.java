package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.ErrorMessages;

public class InputView {

    private static final String PRINT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PRINT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PRINT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int printGetPurchasePrice() {
        while (true) {
            try {
                System.out.println(PRINT_PURCHASE_PRICE);
                String input = Console.readLine();
                return validatePrice(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validatePrice(String priceInput) {
        try {
            int price = Integer.parseInt(priceInput);
            if (price <= 0) {
                throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_PRICE_UNDER_ZERO));
            }
            if (price % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_PRICE_NOT_IN_UNITS_OF_1000));
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_PRICE_IS_NOT_STRING));
        }
    }

    public String printGetWinningLottoNumber() {
        System.out.println(PRINT_WINNING_NUMBER);
        return Console.readLine();
    }

    public int printGetBonusNumber() {
        System.out.println();
        System.out.println(PRINT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
}
