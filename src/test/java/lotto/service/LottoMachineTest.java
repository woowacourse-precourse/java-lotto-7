package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import lotto.model.Lotto;
import lotto.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    LottoMachine lottoMachine = new LottoMachine();
    final int LOTTO_MAX_RANGE = 45;
    final int LOTTO_MIN_RANGE = 1;
    final int LOTTO_LENGTH = 6;

    @Test
    @DisplayName("로또 여러개가 올바르게 생성되는지 확인하는 테스트")
    void createLottoTicket() {
        List<Lotto> tickets;
        BigDecimal purchaseAmount = new BigDecimal(100000);

        tickets = lottoMachine.createLottoTicket(purchaseAmount);

        for (Lotto lotto : tickets) {
            assertTrue(Utils.areAllNumbersValidRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, lotto.getNumbers()));
            assertTrue(Utils.isDuplicateNumber(lotto.getNumbers()));
            assertEquals(LOTTO_LENGTH, lotto.getNumbers().size());
        }

    }
}