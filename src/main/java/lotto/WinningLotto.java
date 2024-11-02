package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WinningLotto {

    private static final String SEPARATOR = ",";

    private final List<LottoNumber> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(String winningNumbers, String bonusNumber) {
        this.winningNumbers = parse(winningNumbers);
        this.bonusNumber = toInt(bonusNumber);
    }

    private List<LottoNumber> parse(String winningNumbers) {
        return splitBySeparator(winningNumbers).stream()
                .map(number -> LottoNumber.from(toInt(number)))
                .toList();
    }

    private List<String> splitBySeparator(String text) {
        return Arrays.stream(text.split(SEPARATOR)).toList();
    }

    private int toInt(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    public Long countWinnings(List<LottoNumber> numbers) {
        return winningNumbers.stream().filter(numbers::contains).count();
    }

    public boolean containsBonus(List<LottoNumber> numbers) {
        return numbers.contains(LottoNumber.from(bonusNumber));
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WinningLotto winningLotto)) {
            return false;
        }
        return bonusNumber == winningLotto.bonusNumber && Objects.equals(winningNumbers, winningLotto.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
