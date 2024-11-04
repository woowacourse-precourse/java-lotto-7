package lotto.lottoMachine.undoPackage.calculateManager;

import lotto.lottoMachine.calculateManager.LottoQuantityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoQuantityManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent)); // 표준 출력을 캡처하기 위한 설정
    }

    @DisplayName("로또 구입 금액에 따른 티켓 수 계산이 올바르게 동작하는지 테스트")
    @Test
    void 로또_구입_금액에_따른_티켓_수_계산이_올바르게_동작하는지_테스트() {
        // Given
        int lottoPurchaseAmount = 5000;
        LottoQuantityManager lottoQuantityManager = new LottoQuantityManager(lottoPurchaseAmount);

        // When
        int lottoQuantity = lottoQuantityManager.getLottoQuantity();

        // Then
        assertThat(lottoQuantity).isEqualTo(5);
        String expectedOutput = System.lineSeparator() + "5개를 구매했습니다." + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}
