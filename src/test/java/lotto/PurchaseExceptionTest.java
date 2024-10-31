package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.service.LottoMachineService;
import org.junit.jupiter.api.Test;

public class PurchaseExceptionTest {
    LottoMachineService lottoMachineService = new LottoMachineService();


    @Test
    void 금액_공백_처리() {
        String input = "";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    lottoMachineService.createLottoTickets(input);
                });
    }

    @Test
    void 문자열_입력() {
        String input = "123s";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    lottoMachineService.createLottoTickets(input);
                });
    }

    @Test
    void 천원_미만_금액() {
        String input = "0";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    lottoMachineService.createLottoTickets(input);
                });
    }

    @Test
    void 천원단위가_아닌경우() {
        String input = "1001";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    lottoMachineService.createLottoTickets(input);
                });
    }


}
