package lotto;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;
import lotto.constant.OutputMessage;
import lotto.constant.Ranking;
import lotto.domain.WinningLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String SCREEN_START = "[";
    private static final String SCREEN_END = "]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> notDuplicates = new HashSet<>(numbers);
        if (notDuplicates.size() != LottoConstant.LOTTO_COUNT.getValue()) {
            ExceptionMessage message = ExceptionMessage.DUPLICATE_NUMBER;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(LottoConstant.MIN_NUMBER.getValue() <= number && number <= LottoConstant.MAX_NUMBER.getValue())) {
                ExceptionMessage message = ExceptionMessage.INVALID_RANGE;
                throw new IllegalArgumentException(message.getMessage());
            }
        }
    }

    public String getScreen() {
        return SCREEN_START +
                String.join(OutputMessage.COMMA.getMessage(), numbers.stream().map(String::valueOf).toList()) +
                SCREEN_END;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public Ranking getRanking(WinningLotto winningLotto) {
        int count = matchCount(winningLotto);
        boolean bonusMatchResult = hasBonus(winningLotto);
        return Ranking.getRanking(count, bonusMatchResult);
    }

    private int matchCount(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    private boolean hasBonus(WinningLotto winningLotto) {
        return numbers
                .stream()
                .anyMatch(winningLotto::equalsWithBonus);
    }

}
