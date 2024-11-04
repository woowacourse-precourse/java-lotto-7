package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("수익률 계산 테스트")
class ProfitTest {
    private Profit profit;

    @BeforeEach
    void setUp() {
        Money money = Money.from(3_000);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(4, 5, 6, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(13, 14, 15, 16, 17, 18));
        Lottos lottos = Lottos.from(List.of(lotto, lotto2, lotto3));

        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 7, 8, 9));
        BonusNumber bonusNumber = BonusNumber.of(winningLotto, 10);

        WinningResult winningResult = WinningResult.create();
        winningResult.calculateWinningResult(lottos, winningLotto, bonusNumber);

        profit = Profit.of(money, winningResult);
    }

    @Test
    @DisplayName("계산된 수익률이 총 당첨금액 / 구매금액 * 100 이 맞는지")
    void validateProfit() {
        assertThat(profit).extracting("profit").isEqualTo(166.66666666666669);
    }

    @Test
    @DisplayName("수익률이 소수점 둘째 자리에서 반올림하여 반환되는지")
    void validateProfitFormat() {
        assertThat(profit.getProfitString()).isEqualTo("총 수익률은 166.7%입니다.");
    }
}