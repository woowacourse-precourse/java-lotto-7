package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.lang.reflect.Method;
import lotto.entity.Lotto;
import lotto.entity.PurchaseAmount;
import lotto.model.LotteryMachineModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LotteryMachineServiceTest {

    private LotteryMachineService lotteryMachineService;
    private LotteryMachineModel lotteryMachineModel;

    @BeforeEach
    void init() {
        lotteryMachineModel = new LotteryMachineModel();
        lotteryMachineService = new LotteryMachineService(lotteryMachineModel);
    }

    @Test
    void buy_오류_없이_정상_작동한다() {
        // given
        StringBuilder sb = new StringBuilder();

        // when

        // then
        assertThatCode(() -> lotteryMachineService.buy(sb))
                .doesNotThrowAnyException();
    }

    @Test
    void getPurchaseCount_구매금액에_대한_최종_구매개수를_정상적으로_반환한다() throws Exception {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000L);

        Method getPurchaseCount = lotteryMachineService.getClass()
                .getDeclaredMethod("getPurchaseCount", PurchaseAmount.class);
        getPurchaseCount.setAccessible(true);

        // when
        long result = (long) getPurchaseCount.invoke(lotteryMachineService, purchaseAmount);

        // then
        assertThat(result).isEqualTo(8);
    }

    @Test
    void issue_구매개수_만큼_로또를_발행하여_발매기에_저장한다() throws Exception {
        // given
        long purchaseCount = 8;
        StringBuilder sb = new StringBuilder();

        Method getPurchaseCount = lotteryMachineService.getClass()
                .getDeclaredMethod("issue", long.class, StringBuilder.class);
        getPurchaseCount.setAccessible(true);

        // when
        getPurchaseCount.invoke(lotteryMachineService, purchaseCount, sb);

        // then
        assertThat(lotteryMachineModel.getIssuedLotto().lottos().size()).isEqualTo(purchaseCount);
    }

    @Test
    void generate_Lotto를_정상적으로_생성하여_반환한다() throws Exception {
        // given
        Method getPurchaseCount = lotteryMachineService.getClass()
                .getDeclaredMethod("generate");
        getPurchaseCount.setAccessible(true);

        // when

        // then
        assertThatCode(() -> {
            Lotto lotto = (Lotto) getPurchaseCount.invoke(lotteryMachineService);
        })
                .doesNotThrowAnyException();
    }
}