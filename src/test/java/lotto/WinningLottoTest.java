package lotto;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

public class WinningLottoTest {

    @Test
    void 정상_로또_번호와_보너스_번호로_WinningLotto_객체를_생성한다() {
        List<Integer> winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    void 보너스_번호가_1보다_작거나_45보다_클_경우_예외가_발생한다() {
        List<Integer> winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int invalidBonusNumber1 = 0;
        int invalidBonusNumber2 = 46;

        assertThatThrownBy(() -> new WinningLotto(winningLottoNumbers, invalidBonusNumber1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new WinningLotto(winningLottoNumbers, invalidBonusNumber2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 로또_번호와_보너스_번호가_중복될_경우_예외가_발생한다() {
        List<Integer> winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber = 6;

        assertThatThrownBy(() -> new WinningLotto(winningLottoNumbers, duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    void 로또_번호가_정상적으로_포함되어있는지_확인한다() {
        List<Integer> winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        boolean contains1 = winningLotto.isContain(1);
        boolean contains7 = winningLotto.isContain(7);

        assertThat(contains1).isTrue();
        assertThat(contains7).isFalse();
    }
}