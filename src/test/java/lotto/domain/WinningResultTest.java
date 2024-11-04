package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 비교 테스트")
class WinningResultTest {
    @Test
    @DisplayName("구매한 로또와 당첨 계산 결과를 저장하는지")
    void calculateWinningResult() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = Lottos.from(List.of(lotto));
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.of(winningLotto, 7);

        WinningResult winningResult = WinningResult.create();
        winningResult.calculateWinningResult(lottos, winningLotto, bonusNumber);

        assertThat(winningResult)
                .extracting("winningResult")
                .extracting(resultMap -> ((EnumMap<Rank, Integer>) resultMap).get(Rank.FIRST))
                .isEqualTo(1);
    }
}
