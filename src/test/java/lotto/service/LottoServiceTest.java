package lotto.service;


import java.util.List;
import lotto.domain.model.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private LottoService lottoService = new LottoService();

    @Test
    @DisplayName("구매한 갯수만큼의 랜덤 로또를 생성한다")
    void make_lotto_as_ticket() {
        int ticket = 3;
        List<Lotto> testLottos = lottoService.createRandomLottos(ticket).lottos();

        Assertions.assertEquals(testLottos.size(), ticket);
    }
}
