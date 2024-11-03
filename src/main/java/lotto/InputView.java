package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int getMoneyToBuy() {
        while (true) {
            try {
                OutputView.notifyEnterMoneyToBuy();
                String input = Console.readLine();
                return validateMoneyToBuy(input);
            } catch (Exception e) {
                // 다시 재입력 받도록
            }
        }
    }

    public int validateMoneyToBuy(String input) {
        try {
            int moneyToBuy = Integer.parseInt(input); // 숫자가 아닌 경우 NumberFormatException 발생
            if (moneyToBuy % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            return moneyToBuy;
        } catch (NumberFormatException e) {
            OutputView.printNumberFormatError();
            throw e;
        } catch (IllegalArgumentException e) {
            OutputView.printNotDivisibleByThousandError();
            throw e;
        }
    }
}
