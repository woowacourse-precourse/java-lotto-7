package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void initializeLottoService() {
        lottoService = new LottoService();

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonusNumber = 7;
        lottoService.setWinningLotto(winningLotto);
        lottoService.setBonusNumber(bonusNumber);
    }

    @Test
    @DisplayName("당첨 번호와 모두 일치하는 로또는 1등이어야 한다.")
    void getFirstRankTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoService.purchaseLottos(1000);
                    Rank result = lottoService.calculateRankOfLottos().get(0);
                    assertThat(result.getPrize()).isEqualTo(Rank.FIRST.getPrize());
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    @DisplayName("당첨 번호 중 5개가 일치하고, 보너스 번호도 일치하는 로또는 2등이어야 한다.")
    void getSecondRankTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoService.purchaseLottos(1000);
                    Rank result = lottoService.calculateRankOfLottos().get(0);
                    assertThat(result.getPrize()).isEqualTo(Rank.SECOND.getPrize());
                },
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    @Test
    @DisplayName("당첨 번호 중 5개가 일치하고, 보너스 번호는 일치하지 않는 로또는 3등이어야 한다.")
    void getThirdRankTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoService.purchaseLottos(1000);
                    Rank result = lottoService.calculateRankOfLottos().get(0);
                    assertThat(result.getPrize()).isEqualTo(Rank.THIRD.getPrize());
                },
                List.of(1, 2, 3, 4, 5, 45)
        );
    }

    @Test
    @DisplayName("당첨 번호 중 4개가 일치하는 로또는 4등이어야 한다.")
    void getFourthRankTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoService.purchaseLottos(1000);
                    Rank result = lottoService.calculateRankOfLottos().get(0);
                    assertThat(result.getPrize()).isEqualTo(Rank.FOURTH.getPrize());
                },
                List.of(1, 2, 3, 4, 44, 45)
        );
    }

    @Test
    @DisplayName("당첨 번호 중 3개가 일치하는 로또는 5등이어야 한다.")
    void getFifthRankTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoService.purchaseLottos(1000);
                    Rank result = lottoService.calculateRankOfLottos().get(0);
                    assertThat(result.getPrize()).isEqualTo(Rank.FIFTH.getPrize());
                },
                List.of(1, 2, 3, 43, 44, 45)
        );
    }

    @Test
    @DisplayName("총 수익률이 정확히 계산되어야 한다.")
    void calculateBenefitRateTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoService.purchaseLottos(9000);
                    String benefitRate = String.format("%.1f", lottoService.calculateBenefitRate());
                    assertThat(benefitRate).isEqualTo("666.7");
                },
                List.of(1, 2, 3, 40, 41, 42),
                List.of(1, 2, 3, 43, 44, 45),
                List.of(1, 2, 3, 4, 44, 45),
                List.of(40, 41, 42, 43, 44, 45),
                List.of(40, 41, 42, 43, 44, 45),
                List.of(40, 41, 42, 43, 44, 45),
                List.of(40, 41, 42, 43, 44, 45),
                List.of(40, 41, 42, 43, 44, 45),
                List.of(40, 41, 42, 43, 44, 45)
        );
    }
}
