package lotto;

import lotto.domain.model.Lotto;
import lotto.domain.service.LottoGenerationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoGenerationServiceTest {

    @Test
    @DisplayName("로또_티켓_생성_성공")
    void 로또_티켓_생성_성공() {
        LottoGenerationService service = new LottoGenerationService();
        Lotto lotto = service.createLotto();

        assertEquals(6, lotto.getNumbers().size());
        assertTrue(lotto.getNumbers().stream().allMatch(num -> num >= 1 && num <= 45));
    }

    @Test
    @DisplayName("생성된_티켓들이_고유한지_확인")
    void 생성된_티켓들이_고유한지_확인() {
        LottoGenerationService generationService = new LottoGenerationService();
        Lotto lotto1 = generationService.createLotto();
        Lotto lotto2 = generationService.createLotto();

        assertNotEquals(lotto1.getNumbers(), lotto2.getNumbers());
    }
}
