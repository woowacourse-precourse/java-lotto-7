package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int winningNumberMatch = 0;
    private boolean isBonusMatch = false;

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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setBonusMatch(boolean bonusMatch) {
        isBonusMatch = bonusMatch;
    }

    public void setWinningNumberMatch(int winningNumberMatch) {
        this.winningNumberMatch = winningNumberMatch;
    }

    public int getWinningNumberMatch() {
        return winningNumberMatch;
    }

    public String toString() {
        return numbers.toString();
    }
}
