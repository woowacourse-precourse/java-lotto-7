package lotto;

public class Validate {
    public void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public void validateWinningNumbers(String[] inputNumbers) {
        if (inputNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (String inputNumber : inputNumbers) {
            Integer number = Integer.parseInt(inputNumber);
            validateNumber(number);
        }
    }

    public void validateNumber(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이여야 합니다.");
        }
    }
}
