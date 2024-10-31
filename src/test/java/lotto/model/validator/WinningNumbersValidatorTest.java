package lotto.model.validator;

import static lotto.exception.InvalidLottoNumberException.DUPLICATE_LOTTO_NUMBERS;
import static lotto.exception.InvalidLottoNumberException.INVALID_LOTTO_NUMBERS;
import static lotto.exception.InvalidLottoNumberException.OUT_OF_RANGE_NUMBER;
import static lotto.util.LottoConstants.LOTTO_NUMBERS_COUNT;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MIN;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class WinningNumbersValidatorTest {

    @Test
    void 로또_번호가_유효한_개수일_때_예외가_발생하지_않는다() {
        List<Integer> validLottoNumbers = createLottoNumbers(LOTTO_NUMBERS_COUNT);
        WinningNumbersValidator validator = new WinningNumbersValidator(validLottoNumbers);

        assertDoesNotThrow(validator::validate);
    }

    @Test
    void 로또_번호_개수가_유효한_개수보다_적으면_예외가_발생한다() {
        List<Integer> invalidLottoNumbers = createLottoNumbers(LOTTO_NUMBERS_COUNT - 1);
        WinningNumbersValidator validator = new WinningNumbersValidator(invalidLottoNumbers);

        assertThatThrownBy(validator::validate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBERS);
    }

    @Test
    void 로또_번호_개수가_유효한_개수보다_많으면_예외가_발생한다() {
        List<Integer> excessiveLottoNumbers = createLottoNumbers(LOTTO_NUMBERS_COUNT + 1);
        WinningNumbersValidator validator = new WinningNumbersValidator(excessiveLottoNumbers);

        assertThatThrownBy(validator::validate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBERS);
    }

    @Test
    void 로또_번호가_중복되지_않으면_예외가_발생하지_않는다() {
        List<Integer> uniqueLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbersValidator validator = new WinningNumbersValidator(uniqueLottoNumbers);

        assertDoesNotThrow(validator::validate);
    }

    @Test
    void 로또_번호가_중복되면_예외가_발생한다() {
        List<Integer> duplicateLottoNumbers = List.of(1, 2, 3, 4, 5, 5);
        WinningNumbersValidator validator = new WinningNumbersValidator(duplicateLottoNumbers);

        assertThatThrownBy(validator::validate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBERS);
    }

    @Test
    void 로또_번호가_모두_유효한_범위에_있으면_예외가_발생하지_않는다() {
        List<Integer> inRangeNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbersValidator validator = new WinningNumbersValidator(inRangeNumbers);

        assertDoesNotThrow(validator::validate);
    }

    @Test
    void 로또_번호에_유효한_범위를_벗어난_숫자가_있으면_예외가_발생한다() {
        List<Integer> outOfRangeNumbers = List.of(LOTTO_NUMBER_MIN - 1, 10, 20, 30, 40, LOTTO_NUMBER_MAX + 1);

        WinningNumbersValidator validator = new WinningNumbersValidator(outOfRangeNumbers);

        assertThatThrownBy(validator::validate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE_NUMBER);
    }


    private List<Integer> createLottoNumbers(int size) {
        return IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MIN + size - 1)
                .boxed()
                .collect(Collectors.toList());
    }
}