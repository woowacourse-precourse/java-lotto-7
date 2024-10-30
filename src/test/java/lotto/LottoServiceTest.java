package lotto;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    @Test
    void 로또_생성_테스트(){
        LottoService lottoService = new LottoService();
        Lotto lotto = lottoService.createLotto();
        assertNotNull(lotto);
    }

}
