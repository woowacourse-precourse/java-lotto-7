package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @DisplayName("각_당첨등수별_당첨내역출력이_정상적인지_확인")
    @Test
    void 각_당첨등수별_당첨내역출력이_정상적인지_확인() {
        long count = 5;
        long count2 = 10;
        LottoRank first = LottoRank.FIRST;
        LottoRank second = LottoRank.SECOND;

        first.printRank(count);
        second.printRank(count2);
        String output = outContent.toString().trim();

        assertTrue(output.contains("6개 일치 (2,000,000,000원) - " + count + "개"));
        assertTrue(output.contains("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count2 + "개"));
    }

    @DisplayName("상금_액수를_정확히_출력하는지_확인")
    @Test
    void 상금_액수를_정확히_출력하는지_확인() {
        long count = 5;
        long count2 = 10;
        LottoRank first = LottoRank.FIRST;
        LottoRank second = LottoRank.SECOND;

        long firstPrize = first.countPrize(count);
        long secondPrize = second.countPrize(count2);

        assertThat(first.getPrizeAmount() * count).isEqualTo(firstPrize);
        assertThat(second.getPrizeAmount() * count2).isEqualTo(secondPrize);
    }


}