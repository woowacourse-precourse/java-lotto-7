package lotto;

import static lotto.ExceptionHandler.hasDuplicates;
import static lotto.ExceptionHandler.isLottoNumber;
import static lotto.ExceptionHandler.isPositiveNumber;
import static lotto.ExceptionHandler.isThousandDivisible;
import static lotto.ExceptionHandler.validateLottoNumber;
import static lotto.IOProcessor.getCommaSeperatedText;
import static lotto.IOProcessor.getNumber;
import static lotto.Utils.convertToSortedNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumber(numbers);
        this.numbers = numbers;
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

    public static int getPublishAmount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public static int getBonusNumber(List<Integer> numbers) {
        Prompt prompt = Prompt.BONUS_NUMBER;
        int bonusNumber = getNumber(prompt.getGuide());
        try {
            isLottoNumber(bonusNumber);
            hasDuplicates(numbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            getBonusNumber(numbers);
        }
        return bonusNumber;
    }

    public static List<Integer> getWinningNumbers() {
        Prompt prompt = Prompt.WINNING_NUMBERS;
        List<String> winningNumbersText = getCommaSeperatedText(prompt.getGuide());
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            winningNumbers = convertToSortedNumber(winningNumbersText);
            validateLottoNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            getWinningNumbers();
        }
        return winningNumbers;
    }

    public static Lotto publish() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        int correct = 0;

        for (int number : this.numbers) {
            if (winningNumbers.contains(number)) {
                correct++;
            }
        }
        return correct;
    }

    public void checkLottoWin(List<Integer> winningNumbers, int bonusNumber) {
        int correct = countMatchingNumbers(winningNumbers);
        
        if (correct == 6) {
            LottoWinner.FIRST.incrementCount();
        }
        if (correct == 5) {
            if (this.numbers.contains(bonusNumber)) {
                LottoWinner.SECOND.incrementCount();
            }
            LottoWinner.THIRD.incrementCount();
        }
        if (correct == 4) {
            LottoWinner.FOURTH.incrementCount();
        }
        if (correct == 3) {
            LottoWinner.FIFTH.incrementCount();
        }
        LottoWinner.NONE.incrementCount();
    }
}
