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

enum LottoWinner {
    FIRST(2_000_000_000, 0),
    SECOND(30_000_000, 0),
    THIRD(1_500_000, 0),
    FOURTH(50_000, 0),
    FIFTH(5_000, 0),
    NONE(0, 0);

    private final int prize;
    private int count;

    LottoWinner(int prize, int count) {
        this.prize = prize;
        this.count = count;
    }
    
    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }
}

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

    public void checkLottoWin(List<Integer> winningNumbers, int bonusNumber) {
        int correct = 0;

        for (int number : this.numbers) {
            if (winningNumbers.contains(number)) {
                correct++;
            }
        }
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
