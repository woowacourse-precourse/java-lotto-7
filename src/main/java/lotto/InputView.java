package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readLottoPurchasePrice() {
        String userInput = Console.readLine();
        validatePurchasePriceIsNumber(userInput);
        int lottoPurchasePrice = Integer.parseInt(userInput);
        validatePurchasePriceByThousand(lottoPurchasePrice);
        return lottoPurchasePrice;
    }

    public void validatePurchasePriceIsNumber(String userInput) {
        if (!userInput.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public void validatePurchasePriceByThousand(int lottoPurchasePrice) {
        if (lottoPurchasePrice % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해 주세요.");
        }
    }
}
