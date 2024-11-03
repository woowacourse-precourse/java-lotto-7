package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.LottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoMachineServiceTest {

    private LottoMachine lottoMachine;
    private LottoMachineService lottoMachineService;

    @BeforeEach
    public void setup() {
        lottoMachine = LottoMachine.getInstance();
        lottoMachineService = new LottoMachineService();
    }

    @Test
    void 로또_구입금액_입력받는다() {
        // given
        String purchaseAmount = "1000";

        // when
        lottoMachineService.inputLottoPurchaseAmount(purchaseAmount);

        // then
        assertEquals(1000, lottoMachine.getPurchaseAmount());
    }

    @Test
    void 보너스번호를_입력받는다() {
        // given
        String bonusNumber = "12";

        // when
        lottoMachineService.inputBonusNumber(bonusNumber);

        // then
        assertEquals(12, lottoMachine.getBonusNumber());
    }
}