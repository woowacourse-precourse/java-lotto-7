package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.BuyingAmountException;
import lotto.validator.BuyingAmountValidator;

public class InputView {
    private final BuyingAmountValidator buyingAmountValidator = new BuyingAmountValidator();
    private static final String GET_BUYING_AMOUNT = "구입금액을 입력해 주세요.";

    public int getBuyingAmount() {
        try {
            System.out.println(GET_BUYING_AMOUNT);
            String input = Console.readLine();
            return buyingAmountValidator.validateBuyingAmount(input);
        } catch (BuyingAmountException e) {
            System.out.println(e.getMessage());
            return getBuyingAmount();
        }
    }
}
