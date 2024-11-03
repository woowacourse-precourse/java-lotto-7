package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setup() {
        inputValidator = new InputValidator();
    }

    @DisplayName("입력된 값이 정수가 아닐 경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"100j", "999999999999", "abcd", "가나다라"})
    void 입력된_값이_정수가_아닐_경우_에러가_발생한다(String input) {
        assertThatThrownBy(() -> {
            inputValidator.validateInputNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값이 음수일 경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"-1", "-13", "-999"})
    void 입력된_값이_음수일_경우_에러가_발생한다(String input) {
        assertThatThrownBy(() -> {
            inputValidator.validateInputNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 음수일 경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"'-1,1,2,3,4,5'", "'-99,-8,-12,-20,-999'"})
    void 당첨_번호가_음수일_경우_에러가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> {
            inputValidator.validateInputWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구분자가 쉼표가 아니라면 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1!2!3!4!5!6", "1-2-3-4-5-6"})
    void 구분자가_쉼표가_아니라면_에러가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> {
            inputValidator.validateInputWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 정수가 아닐경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"'a,b,c,d,e,f'", "'일번,이번,삼번,사번,오번,육번'", "'ㄱ,ㄴ,ㄷ,ㄹ,ㅁ,ㅂ'", "'1.0,2.0,3.0,4.0,5.0,6.0'"})
    void 당첨_번호가_정수가_아닐경우_에러가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> {
            inputValidator.validateInputWinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}