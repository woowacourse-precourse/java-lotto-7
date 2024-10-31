package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.util.LottoParser;

public class LottoWinningNumbersValidator {

    private static final String LOTTO_WINNING_NUMBERS_PATTERN_TEXT = "^\\d+(,\\d+){5}$";
    private static final Pattern LOTTO_WINNING_NUMBERS_PATTERN = Pattern.compile(LOTTO_WINNING_NUMBERS_PATTERN_TEXT);
    private final LottoNumberValidator lottoNumberValidator;

    public LottoWinningNumbersValidator(LottoNumberValidator lottoNumberValidator) {
        this.lottoNumberValidator = lottoNumberValidator;
    }

    public void validateLottoWinningNumbers(String lottoWinningNumbers) {
        validateFormat(lottoWinningNumbers);

        Set<Integer> duplication = new HashSet<>();
        List<Integer> winningNumbers = LottoParser.parseNumbers(lottoWinningNumbers);

        winningNumbers.stream().forEach(lottoNumber -> {
            validateDuplicationNumbers(duplication, lottoNumber);
            lottoNumberValidator.validateLottoNumber(lottoNumber);
        });
    }

    private void validateFormat(String lottoWinningNumbers) {
        if (!LOTTO_WINNING_NUMBERS_PATTERN.matcher(lottoWinningNumbers).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicationNumbers(Set<Integer> numbers, int lottoNumber) {
        if (numbers.contains(lottoNumber)) {
            throw new IllegalArgumentException();
        }
        numbers.add(lottoNumber);
    }


}
