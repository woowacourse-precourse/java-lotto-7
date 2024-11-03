package lotto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    void 로또_생성_테스트() {
        Lotto lotto = lottoService.createLotto();
        assertNotNull(lotto);
    }

}
