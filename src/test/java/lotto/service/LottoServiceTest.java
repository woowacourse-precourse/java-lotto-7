package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("구입 금액에 따라 올바른 수량의 로또가 생성되는지 테스트")
    void shouldGenerateCorrectNumberOfLottosBasedOnPurchaseAmount() {
        int purchaseAmount = 5000;
        int expectedLottoCount = purchaseAmount / 1000;

        LottoTicket lottoTicket = lottoService.generateLottos(purchaseAmount);

        assertEquals(expectedLottoCount, lottoTicket.getLottos().size(),
                "구입 금액에 따른 로또 생성 개수가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호에 따라 올바른 통계를 계산하는지 테스트")
    void shouldCalculateCorrectStatisticsBasedOnWinningNumbersAndBonus() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))); // 6개 일치
        lottoTicket.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))); // 5개 + 보너스 일치
        lottoTicket.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))); // 5개 일치

        Map<LottoResult, Integer> statistics = lottoService.calculateStatisticsLottoResult(lottoTicket, winningNumbers,
                bonusNumber);

        assertEquals(1, statistics.get(LottoResult.SIX), "6개 일치 통계가 올바르지 않습니다.");
        assertEquals(1, statistics.get(LottoResult.FIVE_BONUS), "5개 + 보너스 일치 통계가 올바르지 않습니다.");
        assertEquals(1, statistics.get(LottoResult.FIVE), "5개 일치 통계가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("중복 로또 번호가 입력되었을 때 예외가 발생하는지 테스트")
    void shouldThrowExceptionWhenDuplicateLottoNumbersArePresent() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new Lotto(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

}
