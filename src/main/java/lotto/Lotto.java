package lotto;

import static lotto.ExceptionHandler.isLottoNumber;
import static lotto.ExceptionHandler.isPositiveNumber;
import static lotto.ExceptionHandler.isThousandDivisible;
import static lotto.ExceptionHandler.validateLottoNumber;
import static lotto.IOProcessor.getCommaSeperatedText;
import static lotto.IOProcessor.getNumber;
import static lotto.Utils.convertToNumber;

import java.util.ArrayList;
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

    public static List<Integer> getWinningNumbers() {
        Prompt prompt = Prompt.WINNING_NUMBERS;
        List<String> winningNumbersText = getCommaSeperatedText(prompt.getGuide());
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            winningNumbers = convertToNumber(winningNumbersText);
            validateLottoNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            getWinningNumbers();
        }
        return winningNumbers;
    }
}
