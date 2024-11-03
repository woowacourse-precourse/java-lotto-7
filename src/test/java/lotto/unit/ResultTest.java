package lotto.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import lotto.constants.OutputMessages;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("calculate() 메서드를 호출하여 당첨 결과를 계산한다.")
    void calculateResult() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),    // 6개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),    // 5개 + 보너스 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),    // 5개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)),   // 4개 일치
                new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)), // 3개 일치
                new Lotto(Arrays.asList(14, 15, 16, 17, 18, 19)) // 0개 일치
        );
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        int bonusNumber = 7;

        Result result = new Result(lottos, winningNumbers.getNumbers(), bonusNumber);
        result.calculate();

        String expectedOutput = "\n" +
                OutputMessages.WINNING_STATISTICS_TITLE + "\n" +
                OutputMessages.SEPARATOR_LINE + "\n" +
                String.format(OutputMessages.PRIZE_COUNT_FORMAT, "3개 일치 (5,000원)", 1) + "\n" +
                String.format(OutputMessages.PRIZE_COUNT_FORMAT, "4개 일치 (50,000원)", 1) + "\n" +
                String.format(OutputMessages.PRIZE_COUNT_FORMAT, "5개 일치 (1,500,000원)", 1) + "\n" +
                String.format(OutputMessages.PRIZE_COUNT_FORMAT, "5개 일치, 보너스 볼 일치 (30,000,000원)", 1) + "\n" +
                String.format(OutputMessages.PRIZE_COUNT_FORMAT, "6개 일치 (2,000,000,000원)", 1) + "\n" +
                String.format(OutputMessages.TOTAL_RATE_OF_RETURN, "33859250.0") + "\n";

        // 출력을 캡처하여 검증
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        result.printResult(6000);

        System.setOut(System.out); // 출력 스트림 복원

        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}
