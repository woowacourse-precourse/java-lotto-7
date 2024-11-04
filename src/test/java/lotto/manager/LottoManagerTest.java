package lotto.manager;

import lotto.Lotto;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {
    private LottoManager lottoManager = new LottoManager();

    @Test
    void 구입_금액이_1000일_경우_1개_구매() {
        long payment = 1000;

        List<Lotto> lottos = lottoManager.create(payment);

        assertEquals(lottos.size(), 1);
    }

    @Test
    void 당첨_번호_입력시_당첨_로또_생성() {
        String writeNumber = "1,2,3,4,5,6";

        lottoManager.createWinningLotto(writeNumber);

        Lotto winningLotto = lottoManager.getWinningLotto();
        assertEquals(List.of(1, 2, 3, 4, 5, 6), winningLotto.getNumbers());
    }
}