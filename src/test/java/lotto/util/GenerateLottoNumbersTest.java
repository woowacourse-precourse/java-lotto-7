package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.UserLotto;
import org.junit.jupiter.api.Test;

class GenerateLottoNumbersTest {

    @Test
    void 로또_번호_생성_수량_테스트() {
        int ticketQuantity = 6;

        List<UserLotto> generatedLottos = GenerateLottoNumbers.generateLottoNumbers(ticketQuantity);

        assertEquals(ticketQuantity, generatedLottos.size());
    }
}