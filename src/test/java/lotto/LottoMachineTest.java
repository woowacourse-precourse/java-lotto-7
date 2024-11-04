package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("정상적으로 로또가 발행되는 경우")
    @Test
    void issue_Lotto_Test(){
        int purchaseAmount = 4000;

        lottoMachine.generateLottos(purchaseAmount);
        List<Lotto> myLottos = lottoMachine.getMyLottos();

        int expectedLottosCount = purchaseAmount / LOTTO_PRICE;
        assertThat(myLottos).hasSize(expectedLottosCount);

        for(Lotto lotto: myLottos) {
            assertThat(lotto.getNumbers()).hasSize(LOTTO_NUMBER_COUNT);
            assertThat(lotto.getNumbers()).isSorted();
            assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
            assertThat(lotto.getNumbers()).allMatch(number -> number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX);
        }
    }
}
