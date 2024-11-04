package lotto.lottoMachine.undoPackage.calculateManager;

import lotto.lottoMachine.calculateManager.LottoTotalReturnManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTotalReturnManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent)); // 표준 출력을 캡처하기 위한 설정
    }

    @DisplayName("총 수익률이 올바르게 계산되고 출력되는지 테스트")
    @Test
    void 총_수익률이_올바르게_계산되고_출력되는지_테스트() {
        // Given
        long totalWinningAmount = 5000;  // 당첨 금액
        int lottoPurchaseAmount = 8000;  // 구입 금액
        LottoTotalReturnManager lottoTotalReturnManager = new LottoTotalReturnManager(totalWinningAmount, lottoPurchaseAmount);

        // When
        lottoTotalReturnManager.calculate();

        // Then
        String expectedOutput = "총 수익률은 62.5%입니다." + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("총 수익률이 100% 이상일 때 올바르게 계산되고 출력되는지 테스트")
    @Test
    void 총_수익률이_100_이상일_떄_올바르게_계산되고_출력되는지_테스트() {
        // Given
        long totalWinningAmount = 16000;  // 당첨 금액
        int lottoPurchaseAmount = 8000;   // 구입 금액
        LottoTotalReturnManager lottoTotalReturnManager = new LottoTotalReturnManager(totalWinningAmount, lottoPurchaseAmount);

        // When
        lottoTotalReturnManager.calculate();

        // Then
        String expectedOutput = "총 수익률은 200.0%입니다." + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("총 수익률이 0%일 때 올바르게 계산되고 출력되는지 테스트")
    @Test
    void 총_수익률이_0_일때_올바르게_계산되고_출력되는지_테스트() {
        // Given
        long totalWinningAmount = 0;      // 당첨 금액
        int lottoPurchaseAmount = 8000;   // 구입 금액
        LottoTotalReturnManager lottoTotalReturnManager = new LottoTotalReturnManager(totalWinningAmount, lottoPurchaseAmount);

        // When
        lottoTotalReturnManager.calculate();

        // Then
        String expectedOutput = "총 수익률은 0.0%입니다." + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}
