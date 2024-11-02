package lotto;

import constants.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WinningLotto {

    private static final int LOTTO_SIZE = 6;

    private static final String SEPARATOR = ",";

    private final List<LottoNumber> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(String winningNumbers, String bonusNumber) {
        this.winningNumbers = parse(winningNumbers);
        this.bonusNumber = toInt(bonusNumber);
    }

    private List<LottoNumber> parse(String winningNumbers) {
        List<LottoNumber> lottoNumbers = splitBySeparator(winningNumbers).stream()
                .map(number -> LottoNumber.from(toInt(number)))
                .toList();

        validateSize(lottoNumbers);

        return lottoNumbers;
    }

    private List<String> splitBySeparator(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(SEPARATOR)).toList();
    }

    private int toInt(String textNumber) {
        int bonusNumber;

        try {
            bonusNumber = Integer.parseInt(textNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS);
        }

        return bonusNumber;
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCH_LOTTO_SIZE);
        }
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
