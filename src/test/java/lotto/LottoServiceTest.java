package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    LottoService lottoService;

    @BeforeEach
    void init() {
        lottoService = new LottoService();
    }

    @Test
    void 로또_생성_테스트() {
        List<Lotto> lottos = lottoService.createLottos(8);

        assertThat(lottos.size()).isEqualTo(8);
    }
}
