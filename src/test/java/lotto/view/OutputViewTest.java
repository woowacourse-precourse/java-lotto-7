package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.Lotto;
import lotto.utils.LottoRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest extends NsTest {
    private static final OutputView outputView = new OutputView();

    @ParameterizedTest
    @DisplayName("로또 수 출력기능")
    @ValueSource(ints = {1, 30, 4, 7, 2})
    void displayLottoCount(int count) {
        outputView.displayPurchasedLottoCount(count);
        assertTrue(output().contains(count + "개를 구매했습니다."));
    }

    @Test
    @DisplayName("구매한 로또 번호 출력")
    void displayLottoTickets() {
        List<List<Integer>> lottoTickets = List.of(List.of(1, 2, 3, 4, 5, 6));
        outputView.displayPurchasedLottoTickets(lottoTickets);
        assertTrue(output().contains("[1, 2, 3, 4, 5, 6]"));
    }

    @Test
    @DisplayName("구매한 로또 번호 낮은 번호부터 출력")
    void displayLottoTicketToSorted() {
        Lotto lotto = new Lotto(List.of(1, 3, 2, 6, 5, 4));
        List<List<Integer>> lottoTicketsForNumbers = List.of(lotto.getLottoNumbers());
        outputView.displayPurchasedLottoTickets(lottoTicketsForNumbers);
        assertTrue(output().contains("[1, 2, 3, 4, 5, 6]"));
    }

    @Test
    @DisplayName("당첨 통계 출력 테스트")
    void displayWinningRankCount() {
        Map<LottoRules.Winning, Integer> winningRankCount = new HashMap<>();
        winningRankCount.put(LottoRules.Winning.WINNING_RANK_1, 1);
        winningRankCount.put(LottoRules.Winning.WINNING_RANK_2, 2);
        winningRankCount.put(LottoRules.Winning.WINNING_RANK_3, 3);
        winningRankCount.put(LottoRules.Winning.WINNING_RANK_4, 4);
        winningRankCount.put(LottoRules.Winning.WINNING_RANK_5, 5);
        outputView.displayWinningStatistics(winningRankCount);
        assertTrue(output().contains(
                "당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - 5개\n" +
                "4개 일치 (50,000원) - 4개\n" +
                "5개 일치 (1,500,000원) - 3개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n" +
                "6개 일치 (2,000,000,000원) - 1개"
        ));
    }

    @Test
    @DisplayName("수익률 출력 테스트")
    void displayYieldRate() {
        outputView.displayYieldRate(62.522);
        assertTrue(output().contains("총 수익률은 62.5%입니다."));
    }


    @Override
    protected void runMain() {

    }
}