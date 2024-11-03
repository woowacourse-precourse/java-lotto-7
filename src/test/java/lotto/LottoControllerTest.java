package lotto;

import lotto.Controller.LottoController;
import lotto.Model.WinningDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {
    @Test
    @DisplayName("gainMyRevenue 정상 작동 테스트")
    void gainMyRevenueTest() {
        int actualRevenue = 0;
        LottoController lottoController = new LottoController();
        int expectedRevenue = 3 * 5000 + 1 * 50000 + 2 * 1500000;
        WinningDetails winningDetails = new WinningDetails();
        winningDetails.setFifth(2);
        winningDetails.setFourth(1);
        winningDetails.setThird(3);
        actualRevenue = lottoController.gainMyRevenue(winningDetails);
        assertThat(actualRevenue).isEqualTo(expectedRevenue);
    }
}
