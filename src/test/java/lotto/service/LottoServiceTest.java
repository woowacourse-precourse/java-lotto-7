package lotto.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("구입한 금액만큼 로또 개수가 올바르게 생성 되는지 확인한다.")
    void 로또_생성_테스트() {
        int purchaseAmount = 14000;
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);

        assertThat(lottos).hasSize(14);
    }
}
