package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.entity.PurchaseAmount;
import lotto.entity.WinnerNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LotteryMachineModelTest {

    private LotteryMachineModel lotteryMachineModel;

    @BeforeEach
    void init() {
        lotteryMachineModel = new LotteryMachineModel();
    }

    @Test
    void 기본_생성자는_로또구매금액을_0으로_초기화한다() {
        // given

        // when

        // then
        assertThat(lotteryMachineModel.getPurchaseAmount().purchaseAmount()).isEqualTo(0L);
    }

    @Test
    void insertPurchaseAmount_로또구매금액_저장에_성공한다() {
        // given
        Long insertPurchaseAmount = 1000L;
        PurchaseAmount purchaseAmount = new PurchaseAmount(insertPurchaseAmount);

        // when
        lotteryMachineModel.insertPurchaseAmount(purchaseAmount);

        // then
        assertThat(lotteryMachineModel.getPurchaseAmount().purchaseAmount()).isEqualTo(insertPurchaseAmount);
    }

    @Test
    void settingWinnerNumber_당첨번호_저장에_성공한다() {
        // given
        List<Integer> winnerNumbers = List.of(1, 5, 2, 25, 39, 12);
        WinnerNumber winnerNumber = new WinnerNumber(winnerNumbers);

        // when
        lotteryMachineModel.settingWinnerNumber(winnerNumber);

        // then
        assertThat(lotteryMachineModel.getWinnerNumber().numbers()).isEqualTo(winnerNumbers);
    }
}