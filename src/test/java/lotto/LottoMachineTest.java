package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.*;

class LottoMachineTest extends IOTest{

    @Test
    void givenMoney_whenBuyLotto_thenLottoList() {

        LottoMachine machine = new LottoMachine();

        assertThat(machine.buyLotto(8000).size()).isEqualTo(8);
        assertThat(machine.buyLotto(3000).size()).isEqualTo(3);
        assertThat(machine.buyLotto(4000).size()).isEqualTo(4);
        assertThat(machine.buyLotto(5000).size()).isEqualTo(5);
    }

    @Test
    void givenWinningNumber_when_thenSetWinningNumber() {

        LottoMachine machine = new LottoMachine();

        systemIn("1,2,3,4,5,6\n7");

        machine.setWinningNum();

        assertThat(machine.winningNum).isEqualTo(List.of(1,2,3,4,5,6));
        assertThat(machine.bonus).isEqualTo(7);
    }

    @Test
    void givenLotto_when_thenPrize() {
        //Given
        LottoMachine machine = new LottoMachine();
        List<Lotto> lotto = new ArrayList<>();

        systemIn("1,2,3,4,5,6\n7");

        machine.setWinningNum();

        lotto.add(new Lotto(List.of(1,2,3,4,5,6)));

        //When
        int prize = machine.checkResult(lotto);

        //Then
        assertThat(prize).isEqualTo(2000000000);
    }

    @Test
    void givenPayAndPrize_when_thenBenefitRate() {

        //Given
        LottoMachine machine = new LottoMachine();
        int pay = 5000;
        int prize = 500000;

        //When
        machine.printBenefitRate(pay,prize);
        //Then
        assertThat(getOutput()).contains("총 수익률은 10000.0%입니다.");

    }

}