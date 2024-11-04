package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.LotteryBuyer;
import lotto.domain.Lotto;
import lotto.domain.PrizeTier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService(new RandomLottoNumberGenerator());
    }

    @Test
    @DisplayName("로또 구입 금액에 따른 로또 개수가 올바르게 생성되는지 확인")
    void 로또_구입_개수_확인() {
        LotteryBuyer lotteryBuyer = lottoService.buyLotto(8000);
        assertThat(lotteryBuyer.getLotteries()).hasSize(8);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 등수가 정확히 나오는지 확인")
    void 당첨_결과_확인() {
        LotteryBuyer lotteryBuyer = new LotteryBuyer(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        ));
        Map<PrizeTier, Long> prizeCounts = lottoService.compareLottoToWinningNumbers(
                lotteryBuyer,
                List.of(1, 2, 3, 4, 5, 6),
                7
        );

        assertThat(prizeCounts.get(PrizeTier.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률이 정확히 계산되는지 확인")
    void 수익률_계산() {
        Map<PrizeTier, Long> prizeCounts = Map.of(
                PrizeTier.FIRST, 1L
        );
        double profitRate = lottoService.calculateProfitRate(prizeCounts, 8000);
        assertThat(profitRate).isEqualTo(25000000.0);
    }
}