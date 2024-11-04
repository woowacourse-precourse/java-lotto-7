package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.utils.FixedNumberGenerator;
import lotto.utils.RandomNumberGenerator;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LotteryMachineTest {
    private LotteryMachine lotteryMachine;
    List<Integer> fixedNumber = List.of(1, 2, 3, 4, 5, 6);

    @BeforeEach
    void createFixedNumberLotto(){
        lotteryMachine = new LotteryMachine(new FixedNumberGenerator(fixedNumber));
    }


    @Test
    void createLottoTicket() {
        Lotto lottoTicket = lotteryMachine.createLottoTicket();
        assertThat(lottoTicket.getNumbers()).isEqualTo(fixedNumber);
    }

    @Test
    void 구입금액만큼_로또를_생성한다(){

        lotteryMachine.createLottoByPayment(new Money(8000));
        List<Lotto> purchaseLotto = lotteryMachine.getPurchaseLotto();
        assertThat(purchaseLotto.size()).isEqualTo(8);

    }


}