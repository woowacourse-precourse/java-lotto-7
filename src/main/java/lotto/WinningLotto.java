package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WinningLotto {

    private static final String SEPARATOR = ",";

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(String winningNumbers, String bonusNumber) {
        this.lotto = new Lotto(parse(winningNumbers));
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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WinningLotto that)) {
            return false;
        }
        return bonusNumber == that.bonusNumber && Objects.equals(lotto, that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumber);
    }
}
