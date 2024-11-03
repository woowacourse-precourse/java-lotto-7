package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatchNumberTest {

    @DisplayName("로또 결과를 검증하여 각 등수별 개수를 반환한다.")
    @Test
    void 로또_결과를_검증하여_등수별_개수를_반환한다() {
        WinNumber winNumber = new WinNumber();
        winNumber.inputWinNumber("1,2,3,4,5,6");
        winNumber.inputBonusNumber(7);

        MatchNumber matchNumber = new MatchNumber(winNumber, 7);
        List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 1등
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),  // 2등
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),  // 3등
            new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), // 4등
            new Lotto(Arrays.asList(1, 2, 3, 12, 13, 14)) // 5등
        );

        matchNumber.checkWinNumber(lottos);

        Map<Prize, Integer> prizeCount = matchNumber.getPrizeCount();
        assertThat(prizeCount.get(Prize.FIRST)).isEqualTo(1); // 1등 당첨 개수
        assertThat(prizeCount.get(Prize.SECOND)).isEqualTo(1); // 2등 당첨 개수
        assertThat(prizeCount.get(Prize.THIRD)).isEqualTo(1); // 3등 당첨 개수
        assertThat(prizeCount.get(Prize.FOURTH)).isEqualTo(1); // 4등 당첨 개수
        assertThat(prizeCount.get(Prize.FIFTH)).isEqualTo(1); // 5등 당첨 개수
    }
}
