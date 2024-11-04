package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("null값, 0원 체크")
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { "0", " " })
    void null값이나_0원을_입력하면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("StringToLong 변환 체크")
    @ParameterizedTest
    @ValueSource(strings = { "123456789123456789123456789123456789123456789123456789", "12qwer", "b" })
    void 올바른_숫자를_입력하지_않으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("천의 배수 체크")
    @ParameterizedTest
    @ValueSource(strings = { "0", "10001", "100" })
    void 천의_배수인_숫자를_입력하지_않으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
