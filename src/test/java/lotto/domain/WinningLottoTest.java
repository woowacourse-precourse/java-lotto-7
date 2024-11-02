package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("보너스 번호가 범위 내에 있지 않으면 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위_내에_있지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(Arrays.asList(1,2,3,4,5,6), 48))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
