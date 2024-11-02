package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningLottoTest {


    @Test
    public void 당첨번호의_개수가_6개_미만일경우_예외발생() {
        List<Integer> winningNumber = Arrays.asList(19, 11, 2, 4, 6);

        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumber, 20))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @Test
    public void 당첨번호가_중복될_경우_예외발생() {
        List<Integer> winningNumber = Arrays.asList(19, 19, 2, 4, 6, 30);

        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumber, 20))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호에 중복된 숫자가 포함될 수 없습니다.");
    }


    @Test
    public void 보너스_번호가_당첨번호와_중복될경우_예외발생() {
        int bonusNumber = 19;
        List<Integer> winningNumber = Arrays.asList(bonusNumber, 11, 2, 3, 4, 6);

        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

}