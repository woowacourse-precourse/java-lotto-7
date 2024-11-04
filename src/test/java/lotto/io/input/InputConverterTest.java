package lotto.io.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputConverterTest {
    private InputConverter converter;

    @BeforeEach
    void setUp() {
        converter = new InputConverter();
    }

    @Test
    void 문자열을_정수로_변환할_때_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> converter.toInteger("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열을_정수로_변환한다() {
        String input = "1000";
        assertThat(converter.toInteger(input)).isEqualTo(1000);
    }

    @Test
    void 문자열_배열을_리스트로_변환한다() {
        String[] input = {"1", "2", "3"};
        assertThat(converter.toList(input)).containsExactly("1", "2", "3");
    }

    @Test
    void 빈_문자열_배열을_리스트로_변환한다() {
        String[] input = {};
        assertThat(converter.toList(input)).isEmpty();
    }

    @Test
    void 숫자로_된_문자열_배열을_리스트로_변환한다() {
        String[] input = {"1", "2", "3"};
        assertThat(converter.toIntegerList(input)).containsExactly(1, 2, 3);
    }

    @Test
    void 문자열_배열에_숫자가_아닌_값이_있으면_예외가_발생한다() {
        String[] input = {"1", "2a", "3"};
        assertThatThrownBy(() -> converter.toIntegerList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}