package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(strings ={"a", ",", "Ahn"})
    void 문자가_입력되면_예외가_발생한다(final String num) {
        //given
        final String expectedMessage = "[ERROR] 로또 번호는 문자가 아닌 숫자여야 합니다.";

        //when & then
        assertThatThrownBy(() -> new LottoNumber(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @ValueSource(strings ={"46", "0", "-1"})
    void 입력된_숫자가_1부터_45_사이의_숫자가_아니라면_예외가_발생한다(final String num) {
        //given
        final String expectedMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

        //when & then
        assertThatThrownBy(() -> new LottoNumber(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @ValueSource(strings ={"45", "1"})
    void 입력된_숫자가_1부터_45_사이의_숫자라면_객체가_만들어진다(String num) {
        //when & then
        assertDoesNotThrow(() -> new LottoNumber(num));
    }
}
