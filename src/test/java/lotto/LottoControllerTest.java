package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {
    @Test
    void createLotto() {
        String expected = new Lotto(List.of(8, 21, 23, 41, 42, 43)).numbersToString();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoController lottoController = new LottoController();
                    assertThat(lottoController.createLotto().numbersToString()).isEqualTo(expected);
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Test
    void getWinningDetails() {
        LottoRankGroups lottoRankGroups = new LottoRankGroups(List.of(LottoRank.FIFTH));
        LottoController lottoController = new LottoController();
        assertThat(lottoController.getWinningDetails(lottoRankGroups)).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개");
    }


    @Test
    void getLottoSatus() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18)));
        LottoController lottoController = new LottoController();

        assertThat(lottoController.getLottoStatus(lottos)).contains(
                "3개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "[7, 8, 9, 10, 11, 12]",
                "[13, 14, 15, 16, 17, 18]"
        );
    }

    @Test
    void getRateOfCost() {
        LottoRankGroups lottoRankGroups = new LottoRankGroups(List.of(LottoRank.FIFTH));
        LottoController lottoController = new LottoController();
        assertThat(lottoController.getRateOfReturn(lottoRankGroups)).isEqualTo("500.0%");
    }
}