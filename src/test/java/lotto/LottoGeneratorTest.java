package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {
    @DisplayName("로또 구입 금액이 로또의 금액으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_로또의_금액으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoGenerator().generate(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 0원일 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_0원일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoGenerator().generate(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
