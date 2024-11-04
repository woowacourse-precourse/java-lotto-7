package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningTest {

    @Test
    void 당첨타입를_확인할_수_있다() {
        //given
        WinningFactory winningFactory = new WinningFactory();
        WinningTypes winningTypes = winningFactory.createWinningTypes();

        //when
        WinningType winningType = winningTypes.getWinning(3);

        //then
        Assertions.assertThat(winningType.getPrize()).isEqualTo(5000);
    }

    @Test
    void 보너스당첨을_확인할_수_있다() {
        //given
        WinningFactory winningFactory = new WinningFactory();
        WinningTypes winningTypes = winningFactory.createWinningTypes();

        //when
        WinningType winningType = winningTypes.getBonusWinning();

        //then
        Assertions.assertThat(winningType.getPrize()).isEqualTo(30000000);
    }
}
