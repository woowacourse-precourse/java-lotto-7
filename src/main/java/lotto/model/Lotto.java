package lotto.model;

import static lotto.common.AppConstant.LOTTO_END_RANGE;
import static lotto.common.AppConstant.LOTTO_NUMBER_COUNT;
import static lotto.common.AppConstant.LOTTO_START_RANGE;
import static lotto.common.AppErrorType.NUMBER_DUPLICATE_ERROR;
import static lotto.common.AppErrorType.NUMBER_RANGE_ERROR;
import static lotto.common.AppErrorType.NUMBER_SIZE_ERROR;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateInvalidNumberRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream().sorted(Comparator.naturalOrder()).toList();
    }

    private void validateInvalidNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (LOTTO_START_RANGE > number || number > LOTTO_END_RANGE) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR.getMessage());
            }
        });
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR.getMessage());
        }
    }
    
    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> deDuplicatedNumbers = new HashSet<>(numbers);

        if (deDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public LottoRank getRankFrom(WinningLotto winningLotto) {
        List<Integer> winningNumberList = winningLotto.getWinningNumberList();
        int matchCount = this.numbers.stream().filter(winningNumberList::contains).toList().size();
        List<LottoRank> bonusRankList = LottoRank.rankListWithBonus();
        List<Integer> matchCountListOfBonusRank = bonusRankList.stream().map(rank -> rank.matchCount).toList();

        if (matchCountListOfBonusRank.contains(matchCount)) {
            int bonusNumber = winningLotto.getBonusNumber();

            return LottoRank.by(matchCount, numbers.contains(bonusNumber));
        }

        return LottoRank.by(matchCount, false);
    }
}
