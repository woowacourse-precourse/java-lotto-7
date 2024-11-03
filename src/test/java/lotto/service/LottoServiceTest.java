package lotto.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("구입한 금액만큼 로또 개수가 올바르게 생성 되는지 확인한다.")
    void 로또_생성_테스트() {
        // given
        String purchaseAmount = "14000";

        // when
        List<Lotto> lottos = lottoService.generateLotto(purchaseAmount);

        // then
        assertThat(lottos).hasSize(14);
    }

    @Test
    @DisplayName("구입한 로또들의 당첨 여부를 판별한다.")
    void 당첨_판별_테스트() {
        // given
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        String bonusNumber = "27";

        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 27)),
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)),
                new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8))
        );

        // when
        Map<Integer, Integer> matchCounts = lottoService.winningDetermination(winningNumbers, bonusNumber, lottos);

        // then
        assertThat(matchCounts.get(6)).isEqualTo(1);
        assertThat(matchCounts.get(4)).isEqualTo(1);
        assertThat(matchCounts.get(3)).isEqualTo(1);
        assertThat(matchCounts.get(-5)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 수익률을 계산한다.")
    void 수익률_계산_테스트() {
        // given
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        String bonusNumber = "27";

        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(10, 20, 30, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 27)),
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)),
                new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8))
        );

        // when
        Map<Integer, Integer> matchCounts = lottoService.winningDetermination(winningNumbers, bonusNumber, lottos);
        String purchaseAmount = "4000";
        double calculatedYield = lottoService.calculateYield(matchCounts, purchaseAmount);

        // then
        assertThat(calculatedYield).isEqualTo(751500.0);
    }
}
