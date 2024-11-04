package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.LottoPurchaseMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseMachineTest {

    private LottoPurchaseMachine lottoPurchaseMachine;

    @BeforeEach
    void setUp() {
        lottoPurchaseMachine = new LottoPurchaseMachine(13000);
    }

    @DisplayName("구매 금액에 따라 생성된 로또 티켓 수가 올바른지 확인")
    @Test
    void testGenerateLottoTickets() {
        List<Lotto> lottoTickets = lottoPurchaseMachine.generateLottoTickets();

        assertThat(lottoTickets).hasSize(13);
    }


    @DisplayName("생성된 로또 티켓의 번호 개수가 올바른지 확인")
    @Test
    void testLottoNumbersCount() {
        List<Lotto> lottoTickets = lottoPurchaseMachine.generateLottoTickets();

        for (Lotto lotto : lottoTickets) {
            assertThat(lotto.getNumbers()).hasSize(Lotto.NUMBERS_COUNT);
        }
    }


}
