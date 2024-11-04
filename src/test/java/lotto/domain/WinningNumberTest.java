package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningNumberTest {

    @DisplayName("당첨번호는 정해진 갯수만큼 입력받아야 한다.")
    @Test
    void 당첨번호_생성_테스트() {

        Assertions.assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨번호에 보너스 번호가 포함되면 예외가 발생한다.")
    @Test
    void 보너스번호_예외_테스트1() {
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThatThrownBy(() -> winningNumber.addBonusNumber(new BonusNumber(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이미 입력된 보너스 번호가 있으면 예외가 발생한다.")
    @Test
    void 보너스번호_예외_테스트2() {
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        winningNumber.addBonusNumber(new BonusNumber(10));
        Assertions.assertThatThrownBy(() -> winningNumber.addBonusNumber(new BonusNumber(45)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}