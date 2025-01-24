package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.util.ErrorUtil;

public class InputView {

    private static final String PRINT_INPUT_MONEY ="구입금액을 입력해 주세요.";
    private static final String PRINT_INPUT_WINNING_NUMBER ="당첨 번호를 입력해 주세요.";
    private static final String PRINT_INPUT_BONUS_NUMBER ="보너스 번호를 입력해 주세요.";
    private static final String MONEY_REGEX_PATTERN = "\\d+";
    private static final int MINIMUM_MONEY_UNIT = 1000;

    public String inputMoney() {
        while (true) {
            try {
                System.out.println(PRINT_INPUT_MONEY);
                String money = Console.readLine();
                moneyValidate(money);
                return money;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputWinningNumber() {
                System.out.println(PRINT_INPUT_WINNING_NUMBER);
                return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(PRINT_INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    private void validateNumber(String money) {
        if (!Pattern.matches(MONEY_REGEX_PATTERN, money)) {
            ErrorUtil.PURCHASE_MONEY_NUMBER_ERROR_MESSAGE.errorException();
        }
    }

    private void validateTicketPrice(String money) {
        if (Integer.parseInt(money)%MINIMUM_MONEY_UNIT != 0 || Integer.parseInt(money)/MINIMUM_MONEY_UNIT == 0) {
            ErrorUtil.PURCHASE_MONEY_THOUSAND_UNIT_ERROR_MESSAGE.errorException();
        }
    }

    public void moneyValidate(String money) {
        validateNumber(money);
        validateTicketPrice(money);
    }
}
