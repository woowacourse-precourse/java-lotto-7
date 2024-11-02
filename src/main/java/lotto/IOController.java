package lotto;

import camp.nextstep.edu.missionutils.Console;

public class IOController {
    private static String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    Validator validator = new Validator();

    public String inputPurchaseAmount() {
        String purchaseAmountInput;
        while (true) {
            try {
                System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
                purchaseAmountInput = Console.readLine();
                validator.validatePurchaseAmount(purchaseAmountInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmountInput;
    }

    public String inputWinningNumbers() {
        String winningNumbersInput;
        while (true) {
            try {
                System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
                winningNumbersInput = Console.readLine();
                validator.validateWinningNumbers(winningNumbersInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbersInput;
    }

    public String inputBonusNumber() {
        String bonusNumberInput;
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
                bonusNumberInput = Console.readLine();
                validator.validateBonusNumber(bonusNumberInput);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return bonusNumberInput;
    }

    public void printWinningStatistics(double statistic) {
        System.out.println("총 수익률은 " + statistic + "%입니다.");
    }
}
