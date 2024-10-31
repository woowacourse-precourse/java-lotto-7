package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.utils.FixedNumberGenerator;
import lotto.utils.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LotteryMachineTest {
    private LotteryMachine lotteryMachine;
    List<Integer> fixedNumber = List.of(1, 2, 3, 4, 5, 6);

//    @BeforeEach
//    void createFixedNumberLotto(){
//        lotteryMachine = new LotteryMachine(new FixedNumberGenerator(fixedNumber));
//    }

    @BeforeEach
    void createRandomNumberLotto(){
        lotteryMachine = new LotteryMachine(new RandomNumberGenerator());
    }

    @Test
    void createLottoTicket() {
        Lotto lottoTicket = lotteryMachine.createLottoTicket();
        assertThat(lottoTicket.getNumbers()).isEqualTo(fixedNumber);
    }

    @Test
    void 구입금액만큼_로또를_생성한다(){

        Money money = new Money(3000);

        List<Lotto> lottoByPayment = lotteryMachine.createLottoByPayment(money);

        assertThat(lottoByPayment.size()).isEqualTo(3);

    }


}