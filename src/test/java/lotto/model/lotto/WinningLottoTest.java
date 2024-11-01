package lotto.model.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    @DisplayName("당첨 번호 정상 생성 테스트")
    void validWinningNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("30");

        // when
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        // then
        assertNotNull(winningLotto);
    }

    @Test
    @DisplayName("당첨 번호 예외 테스트")
    void invalidWinningNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("5");

        // when & then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
