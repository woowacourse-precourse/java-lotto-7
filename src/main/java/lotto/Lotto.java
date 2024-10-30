package lotto;

import static lotto.ExceptionHandler.isLottoNumber;
import static lotto.ExceptionHandler.isPositiveNumber;
import static lotto.ExceptionHandler.isThousandDivisible;
import static lotto.IOProcessor.getNumber;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static int getPurchaseAmount() {
        Prompt prompt = Prompt.PURCHASE;
        int purchaseAmount = getNumber(prompt.getGuide());

        try {
            isPositiveNumber(purchaseAmount);
            isThousandDivisible(purchaseAmount);
        } catch (IllegalArgumentException e) {
            getPurchaseAmount();
        }
        return purchaseAmount;
    }

    public static int getBonusNumber() {
        Prompt prompt = Prompt.BONUS_NUMBER;
        int bonusNumber = getNumber(prompt.getGuide());
        try {
            isLottoNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            getBonusNumber();
        }
        return bonusNumber;
    }
}
