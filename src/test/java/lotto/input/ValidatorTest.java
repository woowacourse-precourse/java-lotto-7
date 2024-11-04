package lotto.input;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @Test
    void notEmpty_빈_문자열이_들어오면_예외() {
        assertThatThrownBy(() -> Validator.notEmpty(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Validator.notEmpty("   "))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Validator.notEmpty(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNumber_정상적인_숫자_문자열은_예외가_발생하지_않음() {
        Validator.isNumber("123");
    }

    @Test
    void isNumber_숫자가_아닌_문자열이_들어오면_예외() {
        assertThatThrownBy(() -> Validator.isNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Validator.isNumber("123a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNumber_문자열_배열에_숫자가_아닌_값이_포함되면_예외() {
        String[] invalidNumbers = {"1", "two", "3"};

        assertThatThrownBy(() -> Validator.isNumber(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNumber_모든_문자열이_숫자인_배열_예외_없음() {
        String[] validNumbers = {"1", "2", "3"};

        Validator.isNumber(validNumbers);
    }

}
