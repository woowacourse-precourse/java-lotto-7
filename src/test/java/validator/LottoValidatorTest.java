package validator;

import java.util.List;
import model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    private final LottoValidator lottoValidator;

    public LottoValidatorTest() {
        this.lottoValidator = new LottoValidator();
    }

    @Test
    @DisplayName("validateNumbers는 유효한 로또 번호일 때, 예외를 발생시키지 않는다.")
    void validateNumbers_WithValidNumbers_DoesNotThrowException() {
        // given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        Assertions.assertThatCode(
                () -> lottoValidator.validateNumbers(validNumbers)
        ).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("validateNumbers는 중복 번호가 있을 때, IllegalArgumentException을 던진다.")
    void validateNumbers_WithDuplicatedNumber_ThrowIllegalArgumentException() {
        // given
        List<Integer> duplicatedNumbers = List.of(1, 2, 2, 3, 4, 5);

        // when & then
        Assertions.assertThatThrownBy(
                () -> lottoValidator.validateNumbers(duplicatedNumbers)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("validateNumbers는 유효하지 않은 로또 개수일 때, IllegalArgumentException을 던진다.")
    void validateNumbers_WithInvalidSize_ThrowIllegalArgumentException() {
        // given
        List<Integer> invalidNumbersSize = List.of(1, 2, 2, 3, 4, 5, 6);

        // when & then
        Assertions.assertThatThrownBy(
                () -> lottoValidator.validateNumbers(invalidNumbersSize)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("validateNumbers는 유효하지 않은 로또 번호일 때, IllegalArgumentException을 던진다.")
    void validateNumbers_WithInvalidNumber_ThrowIllegalArgumentException() {
        // given
        List<Integer> duplicatedNumbers = List.of(1, 2, 2, 3, 4, Lotto.MAX_NUMBER + 1);

        // when & then
        Assertions.assertThatThrownBy(
                () -> lottoValidator.validateNumbers(duplicatedNumbers)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("validateNumber는 유효한 로또 번호일 때, 예외를 발생시키지 않는다.")
    void validateNumber_WithValidInput_DoesNotThrowException() {
        // given
        int validNumber = Lotto.MIN_NUMBER;

        // when & then
        Assertions.assertThatCode(
                () -> lottoValidator.validateNumber(validNumber)
        ).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("validateNumber는 로또 가능 번호 밖의 숫자일 때, IllegalArgumentException을 던진다.")
    void validateNumber_WithOutOfRange_ThrowIllegalArgumentException() {
        // given
        int belowNumber = Lotto.MIN_NUMBER - 1;
        int aboveNumber = Lotto.MAX_NUMBER + 1;

        // when & then
        Assertions.assertThatThrownBy(
                () -> lottoValidator.validateNumber(belowNumber)
        ).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(
                () -> lottoValidator.validateNumber(aboveNumber)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
