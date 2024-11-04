package lotto;

import static lotto.ExceptionHandler.validateLottoNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

enum LottoMeta {
    LOTTO_MIN(1),
    LOTTO_MAX(45),
    LOTTO_SIZE(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoMeta(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    public static int getIssueAmount(int purchaseAmount) {
        return purchaseAmount / LottoMeta.LOTTO_PRICE.getValue();
    }

    public static List<Lotto> issueLottos(int issueAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < issueAmount; i++) {
            lottos.add(Lotto.issue());
        }
        return lottos;
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
        if (correct == 5 && this.numbers.contains(bonusNumber)) {
            LottoWinner.SECOND.incrementCount();
        }
        if (correct == 5 && !this.numbers.contains(bonusNumber)) {
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
