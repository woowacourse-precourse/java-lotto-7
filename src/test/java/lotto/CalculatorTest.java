package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.message.ResultMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private LottoCalculator calculator;
    private List<Lotto> purchasedLottos;

    @BeforeEach
    void setUp() {
        // 당첨 번호와 보너스 번호를 초기화합니다
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        calculator = new LottoCalculator(winningNumbers, bonusNumber);

        // 예시 구매 로또 리스트
        purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),  // 3등
                new Lotto(List.of(1, 2, 3, 4, 9, 10)), // 4등
                new Lotto(List.of(1, 2, 3, 11, 12, 13)), // 5등
                new Lotto(List.of(14, 15, 16, 17, 18, 19)) // 꽝
        );
    }

    @Test
    @DisplayName("구매한 로또 목록의 당첨 결과 계산")
    void calculateWinningResults() {
        // when
        Map<ResultMessage, Integer> results = calculator.calculateWinningResults(purchasedLottos);

        // then
        assertThat(results.get(ResultMessage.SIX_NUMBERS_MATCHES)).isEqualTo(1);      // 1등 1개
        assertThat(results.get(ResultMessage.FIVE_AND_BONUS_NUMBERS_MATCHES)).isEqualTo(1);  // 2등 1개
        assertThat(results.get(ResultMessage.FIVE_NUMBERS_MATCHES)).isEqualTo(1);     // 3등 1개
        assertThat(results.get(ResultMessage.FOUR_NUMBERS_MATCHES)).isEqualTo(1);     // 4등 1개
        assertThat(results.get(ResultMessage.THREE_NUMBERS_MATCHES)).isEqualTo(1);    // 5등 1개
        assertThat(results.values().stream().mapToInt(Integer::intValue).sum()).isEqualTo(5); // 꽝 1개
    }

    @Test
    @DisplayName("구매 금액 대비 수익률 계산")
    void calculateProfitRate() {
        // given
        Map<ResultMessage, Integer> results = calculator.calculateWinningResults(purchasedLottos);
        int purchaseAmount = purchasedLottos.size() * 1000; // 로또 가격 1000원 기준

        // when
        double profitRate = calculator.calculateProfitRate(results, purchaseAmount);

        // then
        assertThat(profitRate).isGreaterThan(0); // 수익률이 0보다 큼
    }

    @Test
    @DisplayName("로또 당첨 번호 일치 개수 계산")
    void countWinningNumber() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 6개 일치
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 일치
        Lotto lotto3 = new Lotto(List.of(10, 20, 30, 40, 41, 42)); // 0개 일치

        // when
        int count1 = calculator.countWinningNumber(lotto1);
        int count2 = calculator.countWinningNumber(lotto2);
        int count3 = calculator.countWinningNumber(lotto3);

        // then
        assertThat(count1).isEqualTo(6);
        assertThat(count2).isEqualTo(5);
        assertThat(count3).isEqualTo(0);
    }
}
