package lotto.model.validator;

import static lotto.exception.InvalidLottoNumberException.INVALID_LOTTO_NUMBERS;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.LottoConstants;
import org.junit.jupiter.api.Test;

class LottoNumbersSizeValidatorTest {

    @Test
    void 로또_번호가_유효한_개수일_때_예외가_발생하지_않는다() {
        List<Integer> validLottoNumbers = createLottoNumbers(LottoConstants.LOTTO_NUMBERS_COUNT);
        LottoNumbersSizeValidator validator = new LottoNumbersSizeValidator(validLottoNumbers);

        assertDoesNotThrow(validator::validate);
    }

    @Test
    void 로또_번호_개수가_유효한_개수보다_적으면_예외가_발생한다() {
        List<Integer> invalidLottoNumbers = createLottoNumbers(LottoConstants.LOTTO_NUMBERS_COUNT - 1);
        LottoNumbersSizeValidator validator = new LottoNumbersSizeValidator(invalidLottoNumbers);

        assertThatThrownBy(validator::validate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBERS);
    }

    @Test
    void 로또_번호_개수가_유효한_개수보다_많으면_예외가_발생한다() {
        List<Integer> excessiveLottoNumbers = createLottoNumbers(LottoConstants.LOTTO_NUMBERS_COUNT + 1);
        LottoNumbersSizeValidator validator = new LottoNumbersSizeValidator(excessiveLottoNumbers);

        assertThatThrownBy(validator::validate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBERS);
    }


    private List<Integer> createLottoNumbers(int size) {
        return IntStream.rangeClosed(LottoConstants.LOTTO_NUMBER_MIN, LottoConstants.LOTTO_NUMBER_MIN + size - 1)
                .boxed()
                .collect(Collectors.toList());
    }
}