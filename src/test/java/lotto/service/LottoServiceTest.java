package lotto.service;

import lotto.entity.Lotto;
import lotto.entity.Lottos;
import lotto.entity.WinningNumbers;
import lotto.enums.LottoConstants;
import lotto.enums.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("구입 금액에 따라 로또 개수가 올바르게 생성")
    void generateCorrectNumberOfLottosBasedOnPurchaseAmount() {
        int purchaseAmount = 5000; // 5000원 -> 로또 5개
        Lottos lottos = lottoService.generateLottos(purchaseAmount);

        assertEquals(purchaseAmount / LottoConstants.LOTTO_PRICE.getValue(), lottos.getLottos().size());
    }

    @Test
    @DisplayName("로또 번호가 올바른 범위와 개수로 생성")
    void generateLottosWithValidNumbers() {
        int purchaseAmount = 1000; // 1000원 -> 로또 1개
        Lottos lottos = lottoService.generateLottos(purchaseAmount);

        Lotto lotto = lottos.getLottos().get(0);
        assertEquals(LottoConstants.LOTTO_NUMBERS_COUNT.getValue(), lotto.getNumbers().size());
        assertTrue(lotto.getNumbers().stream().allMatch(
                number -> number >= LottoConstants.MIN_LOTTO_NUMBER.getValue() &&
                        number <= LottoConstants.MAX_LOTTO_NUMBER.getValue()));
    }
}
