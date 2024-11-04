package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoMachineTest extends IOTest{

    @Test
    void givenMoney_whenBuyLotto_thenLottoList() {

        LottoMachine machine = new LottoMachine();

        systemIn("8000");

        machine.enterPay();

        assertThat(machine.buyLotto().size()).isEqualTo(8);
    }

    @Test
    void givenWinningNumber_when_thenSetWinningNumber() {

        LottoMachine machine = new LottoMachine();

        systemIn("1,2,3,4,5,6\n7");

        machine.setWinningNum();
        machine.setBonusNum();



        assertThat(machine.winningNum).isEqualTo(List.of(1,2,3,4,5,6));
        assertThat(machine.bonus).isEqualTo(7);
    }


    @Test()
    void givenDuplicationWinningNumber_when_thenErrorMessageAndAgain() {

        //Given
        LottoMachine machine = new LottoMachine();

        systemIn("1,2,3,4,5,5\n1,2,3,4,5,6");

        //When
        machine.setWinningNum();
        //Then
        assertThat(getOutput()).contains("[ERROR] 로또 번호는 중복되지 않은 6개여야 합니다.");
    }

    @Test
    void givenOver45Number_when_thenError() {

        //Given
        LottoMachine machine = new LottoMachine();

        systemIn("1,2,3,4,5,46\n1,2,3,4,5,6");

        //When
        machine.setWinningNum();
        //Then
        assertThat(getOutput()).contains("[ERROR] 로또 번호는 1~45 사이의 숫자입니다.");

    }

    @Test
    void givenLotto_when_thenPrize() {
        //Given
        LottoMachine machine = new LottoMachine();
        List<Lotto> lotto = new ArrayList<>();

        systemIn("1,2,3,4,5,6\n7");

        machine.setWinningNum();
        machine.setBonusNum();

        lotto.add(new Lotto(List.of(1,2,3,4,5,6)));
        lotto.add(new Lotto(List.of(1,2,3,4,5,7)));

        //When
        machine.checkResult(lotto);

        //Then
        assertThat(machine.prize).isEqualTo(2030000000);
    }

    @Test
    void givenPayAndPrize_when_thenBenefitRate() {

        //Given
        LottoMachine machine = new LottoMachine();
        machine.pay = 5000;
        machine.prize = 500000;

        //When
        machine.printBenefitRate();
        //Then
        assertThat(getOutput()).contains("총 수익률은 10000.0%입니다.");

    }

}