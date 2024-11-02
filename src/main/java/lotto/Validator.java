package lotto;

public class Validator {
    static int validatePurchasePrice(String purchasePriceInput) {
        try{
            int purchasePrice = Integer.parseInt(purchasePriceInput);
            validatePurchasePriceMultipleOfThousand(purchasePrice);

            return purchasePrice;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위의 숫자만 허용됩니다.");
        }
    }

    static void validatePurchasePriceMultipleOfThousand(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위만 허용됩니다.");
        }
    }

    static int validateNumber(String numberInput) {
        try{
            return Integer.parseInt(numberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.(쉼표(,)로 구분)");
        }
    }

    static void validateWinningNumber(String[] winningNumbersInput) {
        if (winningNumbersInput.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.(쉼표(,)로 구분)");
        }
    }

    static int validateBonusNumber(String bonusNumberInput, Lotto winningNumbersLotto) {
        try {
            int bonusNumber = Integer.parseInt(bonusNumberInput);
            validateBonusNumberInRange(bonusNumber);
            validateBonusNumberDuplicate(bonusNumber, winningNumbersLotto);

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    static void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    static void validateBonusNumberDuplicate(int bonusNumber, Lotto winningNumbersLotto) {
        if (winningNumbersLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
