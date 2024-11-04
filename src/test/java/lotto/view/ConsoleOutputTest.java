package lotto.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.configuration.Prize;
import lotto.dto.PrizeCountEntry;
import lotto.dto.ProfitStatisticsDto;
import lotto.entity.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsoleOutputTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private ConsoleOutput consoleOutput;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        consoleOutput = new ConsoleOutput();
    }

    @Test
    void 성공__수익_통계_출력_테스트() {
        // given
        ProfitStatisticsDto dto = new ProfitStatisticsDto(
                List.of(
                        new PrizeCountEntry(Prize.NONE, 0),
                        new PrizeCountEntry(Prize.FIFTH, 0),
                        new PrizeCountEntry(Prize.FOURTH, 0),
                        new PrizeCountEntry(Prize.THIRD, 3),
                        new PrizeCountEntry(Prize.SECOND, 2),
                        new PrizeCountEntry(Prize.FIRST, 1)
                ),
                200.5
        );

        // when
        consoleOutput.printProfitStatistics(dto);
        String capturedOutput = outputStreamCaptor.toString().trim();

        // then
        String expected = "당첨 통계\n" +
                          "---\n" +
                          "3개 일치 (5,000원) - 0개\n" +
                          "4개 일치 (50,000원) - 0개\n" +
                          "5개 일치 (1,500,000원) - 3개\n" +
                          "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n" +
                          "6개 일치 (2,000,000,000원) - 1개\n" +
                          String.format("총 수익률은 %.1f%%입니다.", dto.profitRate());
        Assertions.assertEquals(expected, capturedOutput);

        System.setOut(originalOut);
        System.out.println(capturedOutput);
    }

    @Test
    void 성공__수익_통계_출력_퍼센트_반올림_테스트_버림() {
        // given
        ProfitStatisticsDto dto = new ProfitStatisticsDto(
                List.of(
                        new PrizeCountEntry(Prize.NONE, 0),
                        new PrizeCountEntry(Prize.FIFTH, 0),
                        new PrizeCountEntry(Prize.FOURTH, 0),
                        new PrizeCountEntry(Prize.THIRD, 3),
                        new PrizeCountEntry(Prize.SECOND, 2),
                        new PrizeCountEntry(Prize.FIRST, 1)
                ),
                200.54
        );

        // when
        consoleOutput.printProfitStatistics(dto);
        String capturedOutput = outputStreamCaptor.toString().trim();

        // then
        String expected = "당첨 통계\n" +
                          "---\n" +
                          "3개 일치 (5,000원) - 0개\n" +
                          "4개 일치 (50,000원) - 0개\n" +
                          "5개 일치 (1,500,000원) - 3개\n" +
                          "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n" +
                          "6개 일치 (2,000,000,000원) - 1개\n" +
                          String.format("총 수익률은 %.1f%%입니다.", 200.5);
        Assertions.assertEquals(expected, capturedOutput);

        System.setOut(originalOut);
        System.out.println(capturedOutput);
    }

    @Test
    void 성공__수익_통계_출력_퍼센트_반올림_테스트_올림() {
        // given
        ProfitStatisticsDto dto = new ProfitStatisticsDto(
                List.of(
                        new PrizeCountEntry(Prize.NONE, 0),
                        new PrizeCountEntry(Prize.FIFTH, 0),
                        new PrizeCountEntry(Prize.FOURTH, 0),
                        new PrizeCountEntry(Prize.THIRD, 3),
                        new PrizeCountEntry(Prize.SECOND, 2),
                        new PrizeCountEntry(Prize.FIRST, 1)
                ),
                200.55
        );

        // when
        consoleOutput.printProfitStatistics(dto);
        String capturedOutput = outputStreamCaptor.toString().trim();

        // then
        String expected = "당첨 통계\n" +
                          "---\n" +
                          "3개 일치 (5,000원) - 0개\n" +
                          "4개 일치 (50,000원) - 0개\n" +
                          "5개 일치 (1,500,000원) - 3개\n" +
                          "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n" +
                          "6개 일치 (2,000,000,000원) - 1개\n" +
                          String.format("총 수익률은 %.1f%%입니다.", 200.6);
        Assertions.assertEquals(expected, capturedOutput);

        System.setOut(originalOut);
        System.out.println(capturedOutput);
    }

    @Test
    void 성공__구매한_로또_출력() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        // when
        consoleOutput.printPurchasedLottos(lottos);

        // then
        String expected = "8개를 구매했습니다.\n" +
                          "[8, 21, 23, 41, 42, 43]\n" +
                          "[3, 5, 11, 16, 32, 38]\n" +
                          "[7, 11, 16, 35, 36, 44]\n" +
                          "[1, 8, 11, 31, 41, 42]\n" +
                          "[13, 14, 16, 38, 42, 45]\n" +
                          "[7, 11, 30, 40, 42, 43]\n" +
                          "[2, 13, 22, 32, 38, 45]\n" +
                          "[1, 3, 5, 14, 22, 45]";
        assert (outputStreamCaptor.toString().trim().equals(expected));
    }
}
