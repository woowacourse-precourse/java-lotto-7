package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("당첨번호와 보너스 번호에 중복이 있으면 [ERROR] 로 시작하는 IllegalArgumentException을 반환")
    @Test
    void testThrowIllegalArgumentExceptionWhenDuplicate() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber duplicate = LottoNumber.of(1);

        assertThatThrownBy(() -> new WinningLotto(lotto, duplicate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}