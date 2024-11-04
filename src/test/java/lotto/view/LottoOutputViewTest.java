package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.EnumMap;
import java.util.Map;
import lotto.domain.model.Rank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoOutputViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @DisplayName("로또 결과를 형식에 맞게 출력한다")
    @Test
    void 로또결과출력_정상작동() {
        // Given
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        statistics.put(Rank.FIRST, 1);    // 1등 1개
        statistics.put(Rank.SECOND, 0);   // 2등 0개
        statistics.put(Rank.THIRD, 0);    // 3등 0개
        statistics.put(Rank.FOURTH, 1);   // 4등 1개
        statistics.put(Rank.FIFTH, 2);    // 5등 2개
        statistics.put(Rank.NONE, 0);     // 당첨되지 않은 티켓 없음

        double roi = 62.5;  // 예시 수익률

        // When
        OutputView.printLottoResults(statistics, roi);

        // Then
        String expectedOutput = String.join(System.lineSeparator(),
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 2개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 1개",
                "총 수익률은 62.5%입니다."
        ) + System.lineSeparator();

        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }
}