package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class WinningInfoTest {
    @Test
    void 일치하는_로또_번호의_갯수에_해당하는_열거체_정보를_반활할_수_있다() {
        // given
        double matchCount = 5.5;

        // when
        WinningInfo winningInfo = WinningInfo.getWinningInfoByMatchCount(matchCount);

        // then
        assertThat(winningInfo).isEqualTo(WinningInfo.SAME5_BONUS);
    }
}
