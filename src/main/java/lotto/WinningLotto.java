package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WinningLotto {

    private static final String SEPARATOR = ",";

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(String winningNumbers, String bonusNumber) {
        this.winningNumbers = parse(winningNumbers);
        this.bonusNumber = toInt(bonusNumber);
    }

    private List<Integer> parse(String winningNumbers) {
        return splitBySeparator(winningNumbers).stream().map(this::toInt).toList();
    }

    private List<String> splitBySeparator(String text) {
        return Arrays.stream(text.split(SEPARATOR)).toList();
    }

    private int toInt(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    public Long countWinnings(List<Integer> numbers) {
        return winningNumbers.stream().filter(numbers::contains).count();
    }

    public boolean containsBonus(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WinningLotto that)) {
            return false;
        }
        return bonusNumber == that.bonusNumber && Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
