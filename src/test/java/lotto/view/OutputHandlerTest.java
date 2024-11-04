package lotto.view;

import lotto.PrizeRank;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.RankResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputHandlerTest {

    private OutputHandler outputHandler;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        outputHandler = new OutputHandler();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("구매한 로또 정보를 올바르게 출력한다")
    void outputPurchaseInfo_displaysCorrectly() {
        // given
        List<LottoDto> lottoDtos = List.of(
                new LottoDto(List.of(1, 2, 3, 4, 5, 6)),
                new LottoDto(List.of(7, 8, 9, 10, 11, 12))
        );
        LottosDto lottosDto = new LottosDto(lottoDtos);

        // when
        outputHandler.outputPurchaseInfo(lottosDto);

        // then
        String expectedOutput = String.format("2개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]");
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("당첨 결과를 올바르게 출력한다")
    void outputResults_displaysCorrectly() {
        // given
        List<RankResultDto> winningResults = List.of(
                new RankResultDto(PrizeRank.FIRST.getRank()),
                new RankResultDto(PrizeRank.THIRD.getRank()),
                new RankResultDto(PrizeRank.FIRST.getRank())
        );

        // when
        outputHandler.outputResults(winningResults);

        // then
        String expectedOutput = "당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 1개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 2개";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("수익률을 올바르게 출력한다")
    void outputWinningStatics_displaysCorrectly() {
        // given
        double profitRate = 125.75;

        // when
        outputHandler.outputWinningStatics(profitRate);

        // then
        String expectedOutput = String.format("총 수익률은 %.1f%%입니다.", profitRate);
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}