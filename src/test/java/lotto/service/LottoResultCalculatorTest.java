package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.PurchaseAmount;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBonusNumber;
import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultCalculatorTest {
    private Lotto winningNumber;
    private LottoBonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = new LottoBonusNumber(winningNumber, 7);
    }

    @Test
    void 당첨_번호와_일치하는_로또가_없으면_winningLottos는_비어있다() {
        LottoTicket ticket = new LottoTicket(List.of(new Lotto(List.of(11, 12, 13, 14, 15, 16))));
        LottoResultCalculator calculator = new LottoResultCalculator(winningNumber, bonusNumber, ticket);
        calculator.run();

        assertThat(calculator.getWinningLottos()).isEmpty();
    }

    @Test
    void 구입금액이_0원이면_수익률은_0이다() {
        LottoTicket ticket = new LottoTicket(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        PurchaseAmount purchaseAmount = new PurchaseAmount(0);
        LottoResultCalculator calculator = new LottoResultCalculator(winningNumber, bonusNumber, ticket);
        calculator.run();
        double rateOfReturn = calculator.getRateOfReturn(purchaseAmount);

        assertThat(rateOfReturn).isEqualTo(0.0);
    }

    @Test
    void 번호가_모두_일치할시_1등이_저장된다() {
        LottoTicket ticket = new LottoTicket(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        LottoResultCalculator calculator = new LottoResultCalculator(winningNumber, bonusNumber, ticket);
        calculator.run();

        assertThat(calculator.getWinningLottos().get("FIRST")).isEqualTo(1);
    }

    @Test
    void 보너스_번호와_5개_번호가_일치할시_2등이_저장된다() {
        LottoTicket ticket = new LottoTicket(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))));
        LottoResultCalculator calculator = new LottoResultCalculator(winningNumber, bonusNumber, ticket);
        calculator.run();

        assertThat(calculator.getWinningLottos().get("SECOND")).isEqualTo(1);
    }

    @Test
    void 번호가_5개_일치할시_3등이_저장된다() {
        LottoTicket ticket = new LottoTicket(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8))));
        LottoResultCalculator calculator = new LottoResultCalculator(winningNumber, bonusNumber, ticket);
        calculator.run();

        assertThat(calculator.getWinningLottos().get("THIRD")).isEqualTo(1);
    }

    @Test
    void 번호가_4개_일치할시_4등이_저장된다() {
        LottoTicket ticket = new LottoTicket(List.of(new Lotto(List.of(1, 2, 3, 4, 8, 9))));
        LottoResultCalculator calculator = new LottoResultCalculator(winningNumber, bonusNumber, ticket);
        calculator.run();

        assertThat(calculator.getWinningLottos().get("FOURTH")).isEqualTo(1);
    }

    @Test
    void 번호가_3개_일치할시_5등이_저장된다() {
        LottoTicket ticket = new LottoTicket(List.of(new Lotto(List.of(1, 2, 3, 8, 9, 10))));
        LottoResultCalculator calculator = new LottoResultCalculator(winningNumber, bonusNumber, ticket);
        calculator.run();

        assertThat(calculator.getWinningLottos().get("FIFTH")).isEqualTo(1);
    }

    @Test
    void 수익률이_올바르게_계산된다() {
        LottoTicket ticket = new LottoTicket(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7))   // 2등
        ));
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000); // 2장 구매

        LottoResultCalculator calculator = new LottoResultCalculator(winningNumber, bonusNumber, ticket);
        calculator.run();
        double rateOfReturn = calculator.getRateOfReturn(purchaseAmount);

        double expectedReturn = ((2000000000 + 30000000) / 2000.0) * 100; // (1등 + 2등 상금) / 구매금액 * 100
        assertThat(rateOfReturn).isEqualTo(expectedReturn);
    }

    @Test
    void 여러_장의_로또에_대한_당첨_결과가_올바르게_집계된다() {
        LottoTicket ticket = new LottoTicket(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),  // 3등
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),  // 4등
                new Lotto(List.of(1, 2, 3, 9, 7, 8))   // 5등
        ));
        LottoResultCalculator calculator = new LottoResultCalculator(winningNumber, bonusNumber, ticket);
        calculator.run();

        Map<String, Integer> results = calculator.getWinningLottos();
        assertThat(results.get("FIRST")).isEqualTo(1);
        assertThat(results.get("SECOND")).isEqualTo(1);
        assertThat(results.get("THIRD")).isEqualTo(1);
        assertThat(results.get("FOURTH")).isEqualTo(1);
        assertThat(results.get("FIFTH")).isEqualTo(1);
    }

}