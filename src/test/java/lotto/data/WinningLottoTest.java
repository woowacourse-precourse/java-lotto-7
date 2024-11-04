package lotto.data;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("보너스 번호가 로또 번호 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, 0)) // 0은 최소 범위를 벗어난다.
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, 46)) // 46은 최대 범위를 벗어난다.
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_로또_번호와_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, 3)) // 3은 중복돠었다.
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 보너스 번호와 로또 번호 리스트는 예외 없이 생성된다.")
    @Test
    void 유효한_보너스_번호_리스트는_예외_없이_생성된다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7; // 중복되지 않은 유효한 번호
        assertThatNoException().isThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber));
    }

}