package lotto.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import lotto.model.Lotto;
import lotto.model.Lottos;
import java.util.List;
public class LottoPrizeCalculatorTest {
    private LottoPrizeCalculator calculator;
    @BeforeEach
    public void setUp() {
        calculator = new LottoPrizeCalculator();
    }

    @DisplayName("로또 1등 (6개 일치) 테스트")
    @Test
    public void shouldReturnFirstPrizeWhenSixNumbersMatch() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        long prize = calculator.calculateTotalPrize(lottos, winningNumbers, bonusNumber);
        assertEquals(2_000_000_000, prize);
    }

    @DisplayName("로또 2등 (5개 일치 + 보너스 번호 일치) 테스트")
    @Test
    public void shouldReturnSecondPrizeWhenFiveNumbersAndBonusMatch() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        long prize = calculator.calculateTotalPrize(lottos, winningNumbers, bonusNumber);
        assertEquals(30_000_000, prize);
    }

    @DisplayName("로또 3등 (5개 일치) 테스트")
    @Test
    public void shouldReturnThirdPrizeWhenFiveNumbersMatch() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8))));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        long prize = calculator.calculateTotalPrize(lottos, winningNumbers, bonusNumber);
        assertEquals(1_500_000, prize);
    }

    @DisplayName("로또 4등 (4개 일치) 테스트")
    @Test
    public void shouldReturnFourthPrizeWhenFourNumbersMatch() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 9, 10))));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        long prize = calculator.calculateTotalPrize(lottos, winningNumbers, bonusNumber);
        assertEquals(50_000, prize);
    }

    @DisplayName("로또 5등 (3개 일치) 테스트")
    @Test
    public void shouldReturnFifthPrizeWhenThreeNumbersMatch() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 11, 12, 13))));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        long prize = calculator.calculateTotalPrize(lottos, winningNumbers, bonusNumber);
        assertEquals(5_000, prize);
    }

    @DisplayName("로또 당첨 없음 (2개 이하 일치) 테스트")
    @Test
    public void shouldReturnNoPrizeWhenLessThanThreeNumbersMatch() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 10, 11, 12, 13))));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        long prize = calculator.calculateTotalPrize(lottos, winningNumbers, bonusNumber);
        assertEquals(0, prize);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    public void shouldCalculateYieldRateCorrectly() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        long prize = calculator.calculateTotalPrize(lottos, winningNumbers, bonusNumber);
        int purchaseAmount = 2_000;
        double yieldRate = calculator.calculateYield(prize, purchaseAmount);

        assertEquals(100_000_000.0, yieldRate, 0.01);
    }
}
