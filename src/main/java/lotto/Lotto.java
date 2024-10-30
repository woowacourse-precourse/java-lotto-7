package lotto;

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
            isThousandDivisible(purchaseAmount);
        } catch (IllegalArgumentException e) {
            getPurchaseAmount();
        }
        return purchaseAmount;
    }
}
