package lotto.view;

import lotto.domain.BonusBall;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusBallTest {
    @Test
    void 예외_테스트_로또_번호와_보너스_번호가_중복() {
        assertThatThrownBy(() -> new BonusBall(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class) // 발생해야 할 예외 타입
                .hasMessageContaining("[ERROR] 로또 번호와 보너스 번호는 중복될 수 없습니다. 다시 입력해주세요.");
    }

    @Test
    void 예외_테스트_범위() {
        assertThatThrownBy(() -> new BonusBall(-3, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class) // 발생해야 할 예외 타입
                .hasMessageContaining("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다. 다시 입력해주세요.");
    }
}
