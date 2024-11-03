package lotto.service;

import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("구입금액에 따른 로또 개수 확인 테스트")
    @Test
    void 생성된_로또_개수_확인_테스트() {
        int purchaseAmount = 8000;

        List<Lotto> lotto = lottoService.generateLotto(purchaseAmount);

        assertThat(lotto).hasSize(8);
    }
}
