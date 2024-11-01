package lotto.model;

import static lotto.util.constants.LottoConstants.LOTTO_TICKET_PRICE;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    @DisplayName("구입 금액에 따라 발행되는 로또의 개수는 구입 금액을 로또 1장의 가격으로 나눈 값과 동일")
    void issueLottoTest() {
        int totalCost = 8000;
        int expected = totalCost/LOTTO_TICKET_PRICE;

        LottoMachine vendingMachine = new LottoMachine();
        List<Lotto> purchased = vendingMachine.issueLotto(totalCost);

        assertEquals(purchased.size(), expected);
    }
}