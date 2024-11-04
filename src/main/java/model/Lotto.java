package model;

import static content.LottoConstants.LOTTO_WINNING_FIVE;
import static content.LottoConstants.LOTTO_WINNING_FOUR;
import static content.LottoConstants.LOTTO_WINNING_THREE;

import camp.nextstep.edu.missionutils.Randoms;
import content.LottoConstants;
import content.LottoPrize;

import java.util.ArrayList;
import java.util.List;
import validators.InputValidator;


public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
        List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_MIN_NUMBER, LottoConstants.LOTTO_MAX_NUMBER, LottoConstants.LOTTO_NUMBERS_COUNT);
        this.numbers = new ArrayList<>(pickedNumbers);
        this.numbers.sort(Integer::compareTo);
    }

    public Lotto(List<Integer> numbers) {
        InputValidator.validateLottoNumbers(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Integer::compareTo);
    }


    public LottoPrize getPrize(WinningNumbers winningNumbers) {
        int matchCount = (int) numbers.stream().filter(winningNumbers.getWinningNumbers()::contains).count();
        boolean bonusMatch = numbers.contains(winningNumbers.getBonusNumber());

        if (matchCount == LottoConstants.LOTTO_NUMBERS_COUNT) {
            return LottoPrize.FIRST;
        } else if (matchCount == LOTTO_WINNING_FIVE && bonusMatch) {
            return LottoPrize.SECONDS;
        } else if (matchCount == LOTTO_WINNING_FIVE) {
            return LottoPrize.THIRD;
        } else if (matchCount == LOTTO_WINNING_FOUR) {
            return LottoPrize.FOURTH;
        } else if (matchCount == LOTTO_WINNING_THREE) {
            return LottoPrize.FIFTH;
        }
        return null;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
