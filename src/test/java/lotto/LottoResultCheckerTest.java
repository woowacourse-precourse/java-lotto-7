package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCheckerTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("당첨 결과 확인 - 각 등수별 당첨 개수 (모든 등수가 존재하는 경우)")
    void testCheckLottoResultsWithAllPrizeCounts() {
        // given: 사용자가 구매한 로또와 당첨 번호, 보너스 번호
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),      // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),      // 2등 (보너스 번호 7)
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),      // 3등
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),    // 4등
                new Lotto(List.of(1, 2, 3, 15, 20, 25))    // 5등
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when: 당첨 결과 계산
        LottoResultChecker.checkLottoResults(userLottos, winningNumbers, bonusNumber);

        // then: 출력 결과 검증
        String expectedOutput = """
                당첨 통계
                ---
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 1개
                5개 일치 (1,500,000원) - 1개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
                6개 일치 (2,000,000,000원) - 1개
                """;
        assertThat(outputStream.toString().trim()).isEqualToIgnoringNewLines(expectedOutput);
    }

    @Test
    @DisplayName("당첨 결과 확인 - 모든 등수에서 당첨되지 않은 경우")
    void testCheckLottoResultsWithNoWinners() {
        // given: 사용자가 구매한 로또와 당첨 번호, 보너스 번호 (모든 등수에 해당하지 않는 로또들)
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(10, 20, 30, 40, 41, 42)),
                new Lotto(List.of(11, 21, 31, 41, 42, 43)),
                new Lotto(List.of(12, 22, 32, 42, 43, 44)),
                new Lotto(List.of(13, 23, 33, 43, 44, 45)),
                new Lotto(List.of(14, 24, 34, 44, 45, 1))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when: 당첨 결과 계산
        LottoResultChecker.checkLottoResults(userLottos, winningNumbers, bonusNumber);

        // then: 출력 결과 검증 (모든 등수가 0개로 출력되어야 함)
        String expectedOutput = """
                당첨 통계
                ---
                3개 일치 (5,000원) - 0개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                """;
        assertThat(outputStream.toString().trim()).isEqualToIgnoringNewLines(expectedOutput);
    }
}
