package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int getMoneyToBuy() {
        while (true) {
            try {
                OutputView.notifyEnterMoneyToBuy();
                String input = Console.readLine();
                int amountToBuy = Integer.parseInt(input); // 숫자가 아닌 경우 NumberFormatException 발생
                if (amountToBuy % 1000 != 0) {
                    throw new IllegalArgumentException();
                }
                return amountToBuy;
            } catch (NumberFormatException e) {
                OutputView.printNumberFormatError();
            } catch (IllegalArgumentException e) {
                OutputView.printNotDivisibleByThousandError();
            }
        }
    }
}
