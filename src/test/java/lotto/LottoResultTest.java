package lotto;

import lotto.enums.LottoResult;
import lotto.enums.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @DisplayName("당첨 결과를 정확히 계산한다.")
    @Test
    void calculateResult() {
        // given
        LottoResult result = new LottoResult();
        result.addPrize(Prize.FIFTH);
        result.addPrize(Prize.THIRD);
        result.calculateProfitRate(2000);

        // when
        String output = captureOutput(() -> result.printStatistics());

        // then
        assertThat(output).contains("3개 일치", "5,000원");
        assertThat(output).contains("5개 일치", "1,500,000원");
        assertThat(output).contains("75250.0%");
    }

    private String captureOutput(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            runnable.run();
            return outputStream.toString();
        } finally {
            System.setOut(originalOut);
        }
    }
}