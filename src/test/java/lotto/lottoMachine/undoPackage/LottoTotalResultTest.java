package lotto.lottoMachine.undoPackage;

import lotto.LottoResultStore;
import lotto.lottoMachine.lottoTotalResult.LottoTotalResultManager;
import lotto.lottoMachine.utils.LottoResultStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTotalResultTest {
    private LottoTotalResultManager lottoTotalResultManager;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        lottoTotalResultManager = new LottoTotalResultManager();
        System.setOut(new PrintStream(outContent));
    }

    @DisplayName("당첨 통계가 올바르게 저장되고 출력되는지 테스트")
    @Test
    void 당첨_통계가_올바르게_저장되고_출력되는지_테스트() {
        // Given
        lottoTotalResultManager.store(3, false);
        lottoTotalResultManager.store(4, false);
        lottoTotalResultManager.store(5, false);
        lottoTotalResultManager.store(5, true);
        lottoTotalResultManager.store(6, false);

        // When
        lottoTotalResultManager.printStatistics();

        // Then
        String expectedOutput = System.lineSeparator() + "당첨 통계" + System.lineSeparator()
                + "---" + System.lineSeparator()
                + "3개 일치 (5,000원) - 1개" + System.lineSeparator()
                + "4개 일치 (50,000원) - 1개" + System.lineSeparator()
                + "5개 일치 (1,500,000원) - 1개" + System.lineSeparator()
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개" + System.lineSeparator()
                + "6개 일치 (2,000,000,000원) - 1개" + System.lineSeparator();

        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("총 상금이 올바르게 계산되는지 테스트")
    @Test
    void 총_상금이_올바르게_계산되는지_테스트() {
        // Given
        lottoTotalResultManager.store(3, false); // 5,000원
        lottoTotalResultManager.store(4, false); // 50,000원

        // When
        long totalPrize = lottoTotalResultManager.calculateTotalPrize();

        // Then
        assertThat(totalPrize).isEqualTo(55000); // 예상 상금 합계
    }
}
