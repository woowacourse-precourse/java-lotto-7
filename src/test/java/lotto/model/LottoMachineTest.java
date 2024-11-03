package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("금액에 맞는 로또 개수만큼 구매한다.")
    @Test
    void 로또_구매_테스트() {
        assertSimpleTest(() -> {
            int purchaseAmount = 8000;
            int lottoCount = lottoMachine.calculateLottoCount(purchaseAmount);

            assertThat(lottoCount).isEqualTo(8);
        });
    }

    @DisplayName("로또를 생성한다.")
    @Test
    void 로또_생성_테스트() {
        assertSimpleTest(() -> {
            Lotto lotto = lottoMachine.generateLottoTicket();

            assertThat(lotto.getNumbers()).hasSize(6);
            assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
            assertThat(lotto.getNumbers()).allMatch(number -> number >= 1 && number <= 45);
        });
    }

}
