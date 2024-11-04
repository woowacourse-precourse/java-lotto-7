package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.constant.LotteryConst;
import lotto.exception.ExceptionMessages;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 자동 발행된 로또의 수량 및 번호를 출력하기 위한 Getter
    public List<Integer> getUnmodifiableNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersAmount(numbers);
        validateDuplicatedElemExist(numbers);
        validateOutOfRangeNumber(numbers);
    }

    private void validateNumbersAmount(List<Integer> numbers) {
        if (numbers.size() != LotteryConst.AMOUNT.getValue()) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_ELEM_AMOUNT.getMessage());
        }
    }

    private void validateDuplicatedElemExist(List<Integer> numbers) {
        long duplicatedCount = numbers.stream().distinct().count();
        if (duplicatedCount != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessages.DUPLICATED_NUMBER_EXIST.getMessage());
        }
    }

    private void validateOutOfRangeNumber(List<Integer> numbers) {
        int maxVal = Collections.max(numbers);
        int minVal = Collections.min(numbers);

        if (maxVal > LotteryConst.MAX.getValue() || minVal < LotteryConst.MIN.getValue()) {
            throw new IllegalArgumentException(ExceptionMessages.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public boolean isLottoContainThisNumber(int number) {
        return numbers.contains(number);
    }

    public Result compareToWinningInfo(WinningInfo winningInfo) {
        int hitCount = numbers.stream().mapToInt(winningInfo::isWinningNumbersContainThisNumber).sum();
        int bonusCount = numbers.stream().mapToInt(winningInfo::isBonusNumberSameAsThis).sum();

        return new Result(hitCount, bonusCount);
    }
}
