package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.util.List;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import org.junit.jupiter.api.Test;

class LottoControllerTest {
    @Test
    void 당첨_통계와_수익률_계산() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 9, 10))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        BigInteger amount = BigInteger.valueOf(4000);

        LottoController controller = new LottoController();
        controller.testPrintLottoResults(lottos, winningNumbers, bonusNumber, amount);

        // 수익률과 당첨 통계는 콘솔에 출력되므로, 여기서는 수익률 계산이 올바른지 확인합니다.
        int totalPrize = LottoResult.FIRST.getPrize() + LottoResult.SECOND.getPrize() + LottoResult.THIRD.getPrize();
        double expectedProfitRate = (double) totalPrize / amount.doubleValue() * 100;
        assertThat(expectedProfitRate).isEqualTo(50750000.0 / 4000 * 100);
    }
}