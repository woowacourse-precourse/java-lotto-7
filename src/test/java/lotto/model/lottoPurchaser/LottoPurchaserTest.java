package lotto.model.lottoPurchaser;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoRankAward;
import lotto.model.lotto.LottoWinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoPurchaserTest {

    private LottoPurchaser lottoBuyer;

    @BeforeEach
    void setUp() {
        lottoBuyer = new LottoPurchaser(8000, 20);
    }

    @Test
    @DisplayName("로또 구매자의 레포지토리에 로또가 정상적으로 저장되는지 확인한다.")
    void shouldStoreLottoInRepository() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        lottoBuyer.addLotto(lotto);

        // then
        assertThat(lottoBuyer.calculateLottoResult(new LottoWinningNumbers(Set.of(1, 2, 3, 4, 5, 6), 7))
                .get(LottoRankAward.FIRST_RANK)).isEqualTo(1);
    }


    @Test
    @DisplayName("로또 구매자의 총 로또 수익을 정상적으로 출력하는지 확인한다.")
    void shouldCorrectlyCalculateTotalLottoProfit() {
        // given
        lottoBuyer.updateLottoProfit(8000);
        lottoBuyer.updateLottoProfit(3000);

        // when
        double profitRate = lottoBuyer.calculateProfitRate();

        // then
        assertThat(profitRate).isEqualTo((8000 + 3000) / 8000.0 * 100);
    }

    @Test
    @DisplayName("수익이 0원일 경우에 0을 정상적으로 출력하는지 확인한다.")
    void shouldReturnZeroForTotalLottoProfitWhenNoProfit() {
        // when
        double profitRate = lottoBuyer.calculateProfitRate();

        // then
        assertThat(profitRate).isEqualTo(0);
    }


}
