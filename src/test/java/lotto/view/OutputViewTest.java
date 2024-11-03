package lotto.view;

import lotto.entity.Lotto;
import lotto.entity.Lottos;
import lotto.enums.NotificationMessage;
import lotto.enums.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("로또 구매 개수와 번호 출력 테스트")
    void displayLottos() {
        // Given
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));

        // When
        OutputView.printLottos(lottos);

        // Then
        String expectedOutput = NotificationMessage.PURCHASED_LOTTOS.format(2) + "\n" +
                "[1, 2, 3, 4, 5, 6]\n" +
                "[7, 8, 9, 10, 11, 12]\n" +
                NotificationMessage.DIVIDER.getMessage();

        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("당첨 결과 출력 테스트")
    void displayResults() {
        // Given
        List<Prize> results = List.of(
                Prize.FIFTH,  // 3개 일치
                Prize.FOURTH, // 4개 일치
                Prize.THIRD,  // 5개 일치
                Prize.SECOND, // 5개 일치 + 보너스
                Prize.FIRST   // 6개 일치
        );

        int purchaseAmount = 5000;

        // 예상 총 당첨 금액 계산
        int totalPrize = Prize.FIFTH.getPrizeMoney() +
                Prize.FOURTH.getPrizeMoney() +
                Prize.THIRD.getPrizeMoney() +
                Prize.SECOND.getPrizeMoney() +
                Prize.FIRST.getPrizeMoney();

        // 예상 수익률
        double expectedProfitRate = (double) totalPrize / purchaseAmount * 100;

        // When
        OutputView.printResults(results, purchaseAmount);

        // Then
        String expectedOutput = String.join("\n",
                NotificationMessage.DIVIDER.getMessage(),
                "당첨 통계",
                "---",
                Prize.FIFTH.getDescription(1),
                Prize.FOURTH.getDescription(1),
                Prize.THIRD.getDescription(1),
                Prize.SECOND.getDescription(1),
                Prize.FIRST.getDescription(1),
                NotificationMessage.PROFIT_RATE.format(expectedProfitRate)
        );

        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
    }
}
