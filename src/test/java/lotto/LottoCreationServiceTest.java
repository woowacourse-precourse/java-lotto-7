package lotto;

import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;
import lotto.model.service.LottoCreationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoCreationServiceTest {

    private final LottoCreationService lottoCreationService = new LottoCreationService();

    @Test
    void 여러개의_Lotto_객체가_정상_생성됐는지_테스트() {
        int amount = 5000;
        int expectedLottoCount = amount/1000;

        Lottos lottos = lottoCreationService.createLottos(amount);

        assertEquals(expectedLottoCount, lottos.getSize(),
                "생성된 Lotto 객체 수가 일치하지 않습니다.");

        for (Lotto lotto : lottos.getLottos()) {
            assertEquals(6, lotto.getSize());
        }
    }
}
