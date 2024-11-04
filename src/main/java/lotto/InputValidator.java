package lotto;

public class InputValidator {
    public static void buyingPriceValidator(String buyingPrice) {
        try {
            Integer.parseInt(buyingPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        int buyingPriceInt = Integer.parseInt(buyingPrice);
        if (buyingPriceInt % MyLottos.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
        }
    }

    public static void bonusNumberValidator(String bonusNumber, Lotto winningNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        int parsedBonusNumber = Integer.parseInt(bonusNumber);

        if (winningNumber.getNumbers().contains(parsedBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않은 수를 입력해야 합니다.");
        }
        if (parsedBonusNumber < 1 || parsedBonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }
}
