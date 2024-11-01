package lotto.model.validator.lotto;

import static lotto.exception.InvalidLottoNumberException.INVALID_WINNING_NUMBERS;
import static lotto.util.LottoConstants.LOTTO_NUMBERS_COUNT;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MIN;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class WinningNumbersValidatorTest extends NumberValidatorTestBase {

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
                .hasMessage(INVALID_WINNING_NUMBERS);
    }

    @Test
    void 로또_번호_개수가_유효한_개수보다_많으면_예외가_발생한다() {
        List<Integer> excessiveLottoNumbers = createLottoNumbers(LOTTO_NUMBERS_COUNT + 1);
        WinningNumbersValidator validator = new WinningNumbersValidator(excessiveLottoNumbers);

        assertThatThrownBy(validator::validate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_WINNING_NUMBERS);
    }


    private List<Integer> createLottoNumbers(int size) {
        return IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MIN + size - 1)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    protected WinningNumbersValidator createValidator(List<Integer> winNumbers, Integer bonusNumber) {
        return new WinningNumbersValidator(winNumbers);
    }
}