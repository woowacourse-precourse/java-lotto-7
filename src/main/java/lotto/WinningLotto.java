package lotto;

import constants.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WinningLotto {

    private static final String SEPARATOR = ",";

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(String winningNumbers, String bonusNumber) {
        this.winningNumbers = parse(winningNumbers);
        this.bonusNumber = toLottoNumber(bonusNumber);
    }

    private List<LottoNumber> parse(String winningNumbers) {
        List<LottoNumber> lottoNumbers = splitBySeparator(winningNumbers).stream()
                .map(this::toLottoNumber)
                .toList();

        LottoValidator.validate(lottoNumbers);

        return lottoNumbers;
    }

    private List<String> splitBySeparator(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(SEPARATOR)).toList();
    }

    private LottoNumber toLottoNumber(String textNumber) {
        int number;

        try {
            number = Integer.parseInt(textNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.ENTERED_INVALID_NUMBER);
        }

        return LottoNumber.from(number);
    }

    public int countWinnings(List<LottoNumber> numbers) {
        return (int) winningNumbers.stream().filter(numbers::contains).count();
    }

    public boolean containsBonus(List<LottoNumber> numbers) {
        return numbers.contains(bonusNumber);
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
