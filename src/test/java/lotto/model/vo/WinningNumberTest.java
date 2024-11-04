package lotto.model.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.handler.WinningNumberErrorHandler;
import lotto.model.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void 당첨번호_생성_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        //when
        WinningNumber winningNumber = new WinningNumber(lotto, bonusNumber);

        //then
        assertThat(7)
                .isEqualTo(winningNumber.getBonusNumber());
        assertThat(List.of(1, 2, 3, 4, 5, 6))
                .isEqualTo(winningNumber.getNumbers());
    }

    @Test
    public void 보너스_번호_중복_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        //when, then
        assertThatThrownBy(
                () -> new WinningNumber(lotto, bonusNumber)
        ).isInstanceOf(WinningNumberErrorHandler.class);
    }

    @Test
    public void 보너스_번호_범위_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 46;

        //when, then
        assertThatThrownBy(
                () -> new WinningNumber(lotto, bonusNumber)
        ).isInstanceOf(WinningNumberErrorHandler.class);
    }

}
