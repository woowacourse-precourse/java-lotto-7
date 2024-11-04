package lotto;

import lotto.controller.LotteryController;
import lotto.service.LotteryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryControllerTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));  // 표준 출력을 outputStream으로 설정
    }

    @Test
    @DisplayName("LottoController의 start 메서드가 올바르게 동작하는지 테스트")
    void startTest() {
        // Arrange - 입력값 설정
        String input = "8000\n1,2,3,4,5,6\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Arrange - 초기화 및 테스트 데이터
        LotteryService lotteryService = new LotteryService();
        LotteryController lotteryController = new LotteryController(lotteryService);

        // Act - start 메서드 호출
        lotteryController.start();

        // Assert - 출력값 검증
        String output = outputStream.toString();
        assertThat(output).contains("8개를 구매했습니다.");
        assertThat(output).contains("3개 일치 (5,000원) - ");
        assertThat(output).contains("4개 일치 (50,000원) - ");
        assertThat(output).contains("5개 일치 (1,500,000원) - ");
        assertThat(output).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        assertThat(output).contains("6개 일치 (2,000,000,000원) - ");
        assertThat(output).contains("총 수익률은 ");
    }
}
