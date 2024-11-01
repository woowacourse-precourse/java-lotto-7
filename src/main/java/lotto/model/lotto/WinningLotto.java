package lotto.model.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WinningLotto {
    private static final Pattern VALID_NUMBER_PATTERN = Pattern.compile("^\\d+(,\\d+)*$");
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(final String lottoNumber, final BonusNumber bonusNumber) {
        this.lotto = convertStringToLotto(lottoNumber);
        bonusNumber.validateDuplicated(lotto);
        this.bonusNumber = bonusNumber;
    }

    private Lotto convertStringToLotto(final String lottoNumber) {
        validate(lottoNumber);
        List<Integer> numbers = Arrays.stream(lottoNumber.split(","))
                .map(Integer::parseInt)
                .toList();
        return new Lotto(numbers);
    }

    private void validate(final String lottoNumber) {
        validateEmptyInput(lottoNumber);
        validateInput(lottoNumber);
    }

    private void validateEmptyInput(final String lottoNumber) {
        if (lottoNumber == null || lottoNumber.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 아무것도 입력되지 않았습니다. 로또 번호를 입력해주세요.");
        }
    }

    private void validateInput(final String lottoNumber) {
        if (!VALID_NUMBER_PATTERN.matcher(lottoNumber).matches()) {
            throw new IllegalArgumentException("[ERROR] 입력에 숫자와 쉼표만 포함되어야 합니다.");
        }
    }
}
