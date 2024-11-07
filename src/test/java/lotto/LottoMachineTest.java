package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class LottoMachineTest extends IOTest{

    @Test
    void givenMoney_whenEnterPay_thenLottoList() {

        LottoMachine machine = new LottoMachine();
        Customer kim = new Customer();

        systemIn("8000");

        machine.enterPay(kim);

        assertThat(kim.count).isEqualTo(8);
    }

    @Test
    void givenCustomer_whenBuyLotto_thenGetLotto() {

        //Given
        LottoMachine machine = new LottoMachine();
        Customer kim = new Customer();
        kim.count = 5;

        //When
        machine.buyLotto(kim);

        //Then
        assertThat(kim.myLotto.size()).isEqualTo(5);
    }

}