package lotto;

public class Validator {
    static int validatePurchasePrice(String purchasePriceInput) {
        try{
            return Integer.parseInt(purchasePriceInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위의 숫자만 허용됩니다.");
        }
    }

    static int validateNumber(String numberInput) {
        try{
            return Integer.parseInt(numberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.(쉼표(,)로 구분)");
        }
    }

    static int validateBonusNumber(String bonusNumberInput, Lotto winningNumbersLotto) {
        try {
            int bonusNumber = Integer.parseInt(bonusNumberInput);

            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
            }

            if (winningNumbersLotto.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }
}
