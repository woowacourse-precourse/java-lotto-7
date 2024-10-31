package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.dto.LottoDTO;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 로또를_생성하면_6개의_숫자를_가진다() {
        Lotto lotto = lottoService.makeLotto();
        LottoDTO dto = lotto.toLottoDTO();
        assertThat(6).isEqualTo(dto.numbers().size());
    }

}