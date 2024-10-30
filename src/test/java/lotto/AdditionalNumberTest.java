package lotto;

import lotto.item.AdditionalNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AdditionalNumberTest {
    @Test
    @DisplayName("정상적인 값 입력")
    void 정상값테스트() {
        assertThat(new AdditionalNumber("45").getNumber())
                .isEqualTo(45);
    }

    @Test
    @DisplayName("빈 값을 입력하면 예외가 발생한다.")
    void 빈_값을_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new AdditionalNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자를 입력하지 않으면 예외가 발생한다.")
    @Test
    void 숫자를_입력하지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new AdditionalNumber("1100k"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위 외의 값을 입력하면 예외가 발생한다.")
    @Test
    void 범위_외의_값을_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new AdditionalNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}