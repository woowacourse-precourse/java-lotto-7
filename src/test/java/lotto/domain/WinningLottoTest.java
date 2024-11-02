package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {
    @DisplayName("보너스 번호가 범위 내에 있지 않으면 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위_내에_있지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(Arrays.asList(1,2,3,4,5,6), 48))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 사용자 로또 번호를 비교하여 일치하는 개수를 반환한다.")
    @Test
    void 당첨_번호와_사용자_로또_번호를_비교하여_일치하는_개수를_반환한다() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        int matchCount = winningLotto.countMatchNumbers(userLotto);

        assertThat(matchCount).isEqualTo(3);
    }

}
