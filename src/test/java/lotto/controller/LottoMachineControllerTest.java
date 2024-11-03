package lotto.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

public class LottoMachineControllerTest {
    @Test
    void 개수만큼_로또를_발행한다() {
        List<Lotto> lottoTickets = LottoMachineController.issueLotto(6);
        assertEquals(6, lottoTickets.size());
    }
}
