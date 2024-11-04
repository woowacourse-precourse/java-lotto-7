package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.WinningResult;
import lotto.service.PurchaseService;
import org.junit.jupiter.api.Test;

public class PurchaseServiceTest {
    private final PurchaseService service = new PurchaseService();

    @Test
    void 수익률계산() {
        int investment = 3000;
        service.buyLotto(investment);
        List<WinningResult> result = List.of(WinningResult.FIFTH, WinningResult.FOURTH, WinningResult.NONE);

        int totalPrize = 55000;
        assertEquals(((double)totalPrize - investment) / investment * 100, service.calculateWinningPercent(result));
    }
}
