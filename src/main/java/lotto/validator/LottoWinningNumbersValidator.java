package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.util.LottoParser;

public class LottoWinningNumbersValidator {

    private static final String LOTTO_WINNING_NUMBERS_PATTERN_TEXT = "^\\d+(\\.\\d+){5}$";
    private static final Pattern LOTTO_WINNING_NUMBERS_PATTERN = Pattern.compile(LOTTO_WINNING_NUMBERS_PATTERN_TEXT);
    private final int lottoNumberMin;
    private final int lottoNumberMax;

    public LottoWinningNumbersValidator(int lottoNumberMin, int lottoNumberMax) {
        this.lottoNumberMin = lottoNumberMin;
        this.lottoNumberMax = lottoNumberMax;
    }

    public void validateLottoWinningNumbers(String lottoWinningNumbers) {
        validateFormat(lottoWinningNumbers);

        Set<Integer> duplication = new HashSet<>();
        List<Integer> winningNumbers = LottoParser.parseNumbers(lottoWinningNumbers);

        winningNumbers.stream().forEach(lottoNumber -> {
            validateDuplicationNumbers(duplication, lottoNumber);
            validateLessThanLottoNumberMax(lottoNumber);
            validateMoreThanLottoNumberMin(lottoNumber);
        });
    }

    private void validateFormat(String lottoWinningNumbers) {
        if (!LOTTO_WINNING_NUMBERS_PATTERN.matcher(lottoWinningNumbers).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMoreThanLottoNumberMin(int lottoNumber) {
        if (lottoNumber < lottoNumberMin) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLessThanLottoNumberMax(int lottoNumber) {
        if (lottoNumber > lottoNumberMax) {
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
