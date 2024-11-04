package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("수익률은 구입 금액 대비 당첨금 총액의 비율이다.")
    @Test
    void rateOfReturn_ShouldBe_RevenueDividedByPurchaseAmount() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10);
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto lotto2 = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        LottoResult result = LottoResult.of(winningNumbers, List.of(lotto1, lotto2));
        assertThat(result.rateOfReturn()).isEqualTo(500);
    }
}
