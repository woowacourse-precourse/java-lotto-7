package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @Test
    @DisplayName("정상적인 값 입력")
    void 정상값테스트() {
        assertThat(new Money("10000").getMoneyValue())
                .isEqualTo(10000);
    }

    @Test
    @DisplayName("빈 값을 입력하면 예외가 발생한다.")
    void 빈_값을_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자를 입력하지 않으면 예외가 발생한다.")
    @Test
    void 숫자를_입력하지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money("1100k"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위의 돈을 입력해야 한다.")
    @Test
    void 천원_단위의_돈을_입력해야_한다() {
        assertThatThrownBy(() -> new Money("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
