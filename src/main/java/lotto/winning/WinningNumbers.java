package lotto.winning;

import constants.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lotto.core.LottoNumber;
import lotto.core.LottoValidator;

public class WinningNumbers {

    private static final String SEPARATOR = ",";

    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(String input) {
        this.winningNumbers = parse(input);
    }

    private List<LottoNumber> parse(String winningNumbers) {
        List<LottoNumber> lottoNumbers = splitBySeparator(winningNumbers).stream()
                .map(LottoNumber::toLottoNumber)
                .toList();

        LottoValidator.validate(lottoNumbers);

        return lottoNumbers;
    }

    private List<String> splitBySeparator(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(SEPARATOR)).toList();
    }

    public int countNumbers(List<LottoNumber> numbers) {
        return (int) winningNumbers.stream().filter(numbers::contains).count();
    }

    public void checkDuplicate(LottoNumber bonus) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WinningNumbers that)) {
            return false;
        }
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
