package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.ErrorMessage;
import lotto.utils.Validator;

public class InputView implements Input {

    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    @Override
    public int getPurchaseAmount() {
        while (true) {
            System.out.println(PURCHASE_AMOUNT_PROMPT);
            try {
                return Validator.validatePurchaseAmount(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NON_NUMERIC_PURCHASE_AMOUNT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String getWinningNumbers() {
        while (true) {
            System.out.println(WINNING_NUMBERS_PROMPT);
            try {
                return Validator.validateWinningNumbers(Console.readLine().trim());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public int getBonusNumber() {
        while (true) {
            System.out.println(BONUS_NUMBER_PROMPT);
            try {
                return Validator.validateBonusNumber(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NON_NUMERIC_BONUS_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
