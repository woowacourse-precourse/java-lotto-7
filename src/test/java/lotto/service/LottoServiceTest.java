package lotto.service;

import org.junit.jupiter.api.BeforeEach;

import lotto.Lotto;
import lotto.model.LottoResult;
import lotto.model.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("구입 금액에 따른 로또 티켓 발행 개수 확인")
    @Test
    void buyLottos() {
        int price = 5000;
        List<Lotto> lottos = lottoService.buyLottos(price);

        assertThat(lottos).hasSize(5); // 5000원을 입력했으므로 5개의 로또가 발행되어야 함
    }

    @DisplayName("로또 결과 계산 - 1등, 2등, 3등, 4등, 5등에 대한 당첨 개수 및 수익률 계산 확인")
    @Test
    void evaluateLottos() {
        // 로또 티켓 3장을 생성하여 고정된 번호를 사용하여 테스트
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))  // 3등 당첨
        );

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResult result = lottoService.evaluateLottos(lottos, winningNumbers, bonusNumber);

        Map<Prize, Integer> prizeCounts = result.getPrizeCounts();
        assertThat(prizeCounts.get(Prize.FIRST)).isEqualTo(1);  // 1등 당첨 1개
        assertThat(prizeCounts.get(Prize.SECOND)).isEqualTo(1); // 2등 당첨 1개
        assertThat(prizeCounts.get(Prize.THIRD)).isEqualTo(1);  // 3등 당첨 1개
        assertThat(prizeCounts.getOrDefault(Prize.FOURTH, 0)).isEqualTo(0); // 4등 당첨 없음
        assertThat(prizeCounts.getOrDefault(Prize.FIFTH, 0)).isEqualTo(0);  // 5등 당첨 없음

        // 수익률 검증 (1등, 2등, 3등 당첨 금액 합산 후 구매 금액 대비 수익률 계산)
        double expectedRoi = ((2_000_000_000 + 30_000_000 + 1_500_000) / (lottos.size() * 1000.0)) * 100;
        assertThat(result.getRoi()).isEqualTo(expectedRoi);
    }
}