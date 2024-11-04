package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.dto.LottoTicketsDto;
import lotto.dto.WinningStatisticsDto;
import lotto.dto.WinningStatisticsDto.WinningCountDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private OutputView outputView;
    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        outputStreamCaptor = new ByteArrayOutputStream();
        standardOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Nested
    class 로또_티켓_출력_테스트 {
        @Test
        void 구매한_로또_수량과_번호를_출력한다() {
            // given
            LottoTicketsDto tickets = new LottoTicketsDto(
                    3,
                    List.of(
                            List.of(1, 2, 3, 4, 5, 6),
                            List.of(7, 8, 9, 10, 11, 12),
                            List.of(13, 14, 15, 16, 17, 18)
                    )
            );

            // when
            outputView.printLottoTickets(tickets);
            String output = outputStreamCaptor.toString();

            // then
            assertThat(output)
                    .contains("""
                            3개를 구매했습니다.
                            [1, 2, 3, 4, 5, 6]
                            [7, 8, 9, 10, 11, 12]
                            [13, 14, 15, 16, 17, 18]
                            """);
        }
    }

    @Nested
    class 당첨_통계_출력_테스트 {
        @Test
        void 전체_당첨_통계를_순서대로_출력한다() {
            // given
            List<WinningCountDto> winningCounts = List.of(
                    new WinningCountDto(3, false, 5000, 1),
                    new WinningCountDto(4, false, 50000, 0),
                    new WinningCountDto(5, false, 1500000, 0),
                    new WinningCountDto(5, true, 30000000, 1),
                    new WinningCountDto(6, false, 2000000000, 0)
            );
            WinningStatisticsDto statistics = new WinningStatisticsDto(
                    winningCounts,
                    37_512.1
            );

            // when
            outputView.printWinningStatistics(statistics);
            String output = outputStreamCaptor.toString();

            // then
            assertThat(output)
                    .contains("""
                            
                            당첨 통계
                            ---
                            3개 일치 (5,000원) - 1개
                            4개 일치 (50,000원) - 0개
                            5개 일치 (1,500,000원) - 0개
                            5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
                            6개 일치 (2,000,000,000원) - 0개
                            총 수익률은 37,512.1%입니다.
                            """
                    );
        }
    }
}
