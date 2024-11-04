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

    @DisplayName("로또 구입 금액이 0인 경우 티켓 수가 0인지 테스트")
    @Test
    void 로또_구입_금액이_0인_경우_티켓_수가_0인지_테스트() {
        // Given
        int lottoPurchaseAmount = 0;
        LottoQuantityManager lottoQuantityManager = new LottoQuantityManager(lottoPurchaseAmount);

        // When
        int lottoQuantity = lottoQuantityManager.getLottoQuantity();

        // Then
        assertThat(lottoQuantity).isEqualTo(0);
        String expectedOutput = System.lineSeparator() + "0개를 구매했습니다." + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("로또 구입 금액이 1000의 배수가 아닌 경우 티켓 수가 올바르게 계산되는지 테스트")
    @Test
    void 로또_구입_금액이_1000의_배수가_아닌_경우_티켓_수가_올바르게_계산되는지_테스트() {
        // Given
        int lottoPurchaseAmount = 3500;
        LottoQuantityManager lottoQuantityManager = new LottoQuantityManager(lottoPurchaseAmount);

        // When
        int lottoQuantity = lottoQuantityManager.getLottoQuantity();

        // Then
        assertThat(lottoQuantity).isEqualTo(3);
        String expectedOutput = System.lineSeparator() + "3개를 구매했습니다." + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}
