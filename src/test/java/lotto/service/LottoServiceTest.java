package lotto.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private LottoService lottoService;
    private String purchaseAmount;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
        purchaseAmount = "8000";
    }

    @Test
    @DisplayName("구입한 금액만큼 로또 개수가 올바르게 생성 되는지 확인")
    void 로또_구입_금액_생성_테스트() {
        // when
        List<Lotto> lottos = lottoService.generateLotto(purchaseAmount);

        // then
        assertThat(lottos).hasSize(8);
    }
}