package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 당첨번호를 생성할 수 없다.")
    @Test
    void cannotCreateWinningLotto() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);
        //when
        //then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("당첨번호를 생성할 수 있다.")
    @Test
    void createWinningLotto() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        //when
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        //then
        assertThat(winningLotto).extracting("lotto", "bonusNumber")
            .containsExactly(lotto, bonusNumber);
    }

}