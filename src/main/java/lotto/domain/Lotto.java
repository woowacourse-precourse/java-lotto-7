package lotto.domain;

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

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되었습니다.");
        }
    }

    public static boolean hasDuplicates(List<Integer> list) {
        return list.stream().distinct().count() < list.size();
    }

    public WinningResult checkWinningResult(int winningNumberMatchCount, boolean isBonusMatch) {
        if(winningNumberMatchCount == 6) {
            return WinningResult.FIRST;
        }
        if(winningNumberMatchCount == 5 && (isBonusMatch)) {
            return WinningResult.SECOND;
        }
        if(winningNumberMatchCount == 5 && (!isBonusMatch)) {
            return WinningResult.THIRD;
        }
        if(winningNumberMatchCount == 4) {
            return WinningResult.FOURTH;
        }
        if(winningNumberMatchCount == 3) {
            return WinningResult.FIFTH;
        }
        return WinningResult.NONE;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString() {
        return numbers.toString();
    }
}
