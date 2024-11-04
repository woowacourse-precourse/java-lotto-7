package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.model.lotto.lottoCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("로또 구입 시 구매한 로또의 개수가 올바르게 계산되는지 확인")
    void purchaseLottos() {
        int amount = 5000; // 5장을 구입할 금액
        lottoCollection lottoCollection = lottoService.purchaseLottos(amount);
        assertEquals(5, lottoCollection.getLottos().size());
    }

    @Test
    @DisplayName("구매 금액이 UNIT 단위가 아닐 경우 예외 발생")
    void purchaseLottosWithInvalidAmount() {
        int amount = 5500;
        assertThrows(IllegalArgumentException.class, () -> lottoService.purchaseLottos(amount));
    }

    @Test
    @DisplayName("구입 금액이 음수일 경우 예외 발생")
    void purchaseLottosWithNegativeAmount() {
        int negativeAmount = -1000;
        assertThrows(IllegalArgumentException.class, () -> lottoService.purchaseLottos(negativeAmount));
    }
}
