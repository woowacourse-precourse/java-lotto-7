package lotto;

import static lotto.ExceptionHandler.hasDuplicates;
import static lotto.ExceptionHandler.isLottoNumber;
import static lotto.ExceptionHandler.isPositiveNumber;
import static lotto.ExceptionHandler.isThousandDivisible;
import static lotto.ExceptionHandler.validateLottoNumber;
import static lotto.IOProcessor.readCommaSeperatedText;
import static lotto.IOProcessor.readNumber;
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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static int readPurchaseAmount() {
        InputPrompt prompt = InputPrompt.PURCHASE;
        int purchaseAmount = 0;
        while (true) {
            try {
                purchaseAmount = readNumber(prompt.getGuide());
                isPositiveNumber(purchaseAmount);
                isThousandDivisible(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    public static int getIssueAmount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public static int readBonusNumber(List<Integer> numbers) {
        InputPrompt prompt = InputPrompt.BONUS_NUMBER;
        int bonusNumber = 0;
        while (true) {
            try {
                bonusNumber = readNumber(prompt.getGuide());
                isLottoNumber(bonusNumber);
                hasDuplicates(numbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public static List<Integer> readWinningNumbers() {
        InputPrompt prompt = InputPrompt.WINNING_NUMBERS;
        List<String> winningNumbersText;
        List<Integer> winningNumbers;
        while (true) {
            try {
                winningNumbersText = readCommaSeperatedText(prompt.getGuide());
                winningNumbers = convertToSortedNumber(winningNumbersText);
                validateLottoNumber(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    public static Lotto issue() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
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
    }
}
