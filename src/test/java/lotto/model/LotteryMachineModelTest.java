package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.entity.BonusNumber;
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
    void insertPurchaseAmount_0원은_입력할_수_없다() {
        // given
        Long insertPurchaseAmount = 0L;
        PurchaseAmount purchaseAmount = new PurchaseAmount(insertPurchaseAmount);

        // when

        // then
        assertThatThrownBy(() -> lotteryMachineModel.insertPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.PURCHASE_AMOUNT_IS_POSITIVE);
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

    @Test
    void settingBonusNumber_당첨번호_저장에_성공한다() {
        // given
        Integer number = 7;
        BonusNumber bonusNumber = new BonusNumber(number);

        // when
        lotteryMachineModel.settingBonusNumber(bonusNumber);

        // then
        assertThat(lotteryMachineModel.getBonusNumber().number()).isEqualTo(number);
    }

    @Test
    void settingBonusNumber_당첨번호와_중복되어_실패한다() {
        // given
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinnerNumber winnerNumber = new WinnerNumber(winnerNumbers);
        lotteryMachineModel.settingWinnerNumber(winnerNumber);

        Integer number = 6;
        BonusNumber bonusNumber = new BonusNumber(number);

        // when

        // then
        assertThatThrownBy(() -> lotteryMachineModel.settingBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.BONUS_NUMBER_DUPLICATED);
    }
}