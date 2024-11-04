package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class AmountTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1000", "2000,2000", "100000,100000", "100000000,100000000"})
    void 금액_객체_생성_성공(int amount, int expected) {
        Amount amountInstance = new Amount(amount);
        assertThat(amountInstance.getAmount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -10, -100, -1000})
    void 양의_정수가_아니면_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {100000001, 1000000000, 222222222, 333333333})
    void 최대_입력_가능_금액보다_큰_값이면_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 100, 999, 1100, 3002, 12345})
    void 최소_단위의_배수가_아니면_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}