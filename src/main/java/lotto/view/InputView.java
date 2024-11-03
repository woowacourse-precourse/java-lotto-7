package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public long readPurchaseAmount() throws IllegalArgumentException{
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String userPurchaseAmount = Console.readLine();
        checkUserInputIsNull(userPurchaseAmount);

        return checkPurchaseAmountIsNum(userPurchaseAmount);
    }

    public String readWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();
        checkUserInputIsNull(winningNumber);

        return winningNumber;
    }

    public int readBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        checkUserInputIsNull(bonusNumber);

        return checkBonusNumberIsNum(bonusNumber);
    }

    private void checkUserInputIsNull(String userInput) throws IllegalArgumentException{
        if (userInput == null || userInput.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백입니다.");
        }
    }

    private long checkPurchaseAmountIsNum(String purchaseAmount) {
        try {
            return Long.parseLong(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private int checkBonusNumberIsNum(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
