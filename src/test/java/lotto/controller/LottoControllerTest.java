package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.model.Amount;
import lotto.model.LottoTicket;
import lotto.model.Rank;
import lotto.model.WinningTicket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("발행한 로또 수량 및 번호를 출력")
    void purchase() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    LottoController lottoController = new LottoController();
                    LottoTicket lottoTicket = lottoController.purchase(Amount.from("8000"));
                    String output = outContent.toString();

                    Assertions.assertThat(output).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]"
                    );
                }, List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45));
    }

    @Test
    @DisplayName("당첨 내역 출력")
    void compare() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    LottoController lottoController = new LottoController();
                    LottoTicket lottoTicket = LottoTicket.of(8);
                    WinningTicket winningTicket = WinningTicket.of("1,2,3,4,5,6", "7");
                    lottoController.compare(lottoTicket, winningTicket);
                    String output = outContent.toString();

                    Assertions.assertThat(output).contains(
                            "당첨 통계",
                            "---",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                }, List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45));
    }

    @Test
    @DisplayName("수익률 출력")
    void rateOfReturn() {
        assertSimpleTest(() -> {
            LottoController lottoController = new LottoController();
            List<Rank> ranks = List.of(Rank.MISS, Rank.MISS, Rank.MISS, Rank.MISS, Rank.MISS, Rank.MISS, Rank.MISS,
                    Rank.FIFTH);
            long prizeSum = Rank.calcTotalPrize(ranks);
            lottoController.rateOfReturn(8000, prizeSum);
            String output = outContent.toString();

            Assertions.assertThat(output).contains("총 수익률은 62.5%입니다.");
        });
    }
}
