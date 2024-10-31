package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 금액 테스트")
class LottoCostTest {
    @Test
    void 로또_금액이_1000원이상이여야_한다() {
        assertThatThrownBy(() -> LottoCost.valueOf("900"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 1000원 이상, 100000 이하만 가능합니다.");
    }

    @Test
    void 로또_금액이_1000의_배수여야_한다() {
        assertThatThrownBy(() -> LottoCost.valueOf("1800"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 1000의 배수만 가능합니다.");
    }

    @Test
    void 로또_금액은_정수이어야_한다() {
        assertThatThrownBy(() -> LottoCost.valueOf("만원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 양수이어야 합니다.");
    }
}