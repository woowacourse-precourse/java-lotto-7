package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Controller.IssueTicketController;
import lotto.Controller.WinningTotalController;
import lotto.Model.Lotto;
import lotto.Model.MyLottos;
import lotto.View.OutputWinningTotalView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningTotalTest extends NsTest {
    WinningTotalController winningTotalController = new WinningTotalController();
    IssueTicketController issueTicketController = new IssueTicketController();

    @DisplayName("당첨_통계를 올바르게 내면 통과")
    @Test
    void 당첨_통계를_숫자_맵으로_출력한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    MyLottos mylottos = issueTicketController.issueTickets(8);
                    Map<String, Integer> winningTotal = winningTotalController.calculateWinningTotal(mylottos, winningLotto, bonusNumber);
                    Map<String, Integer> testMap = Map.of("FIRST", 0, "SECOND", 0, "THIRD", 0, "FOURTH", 0, "FIFTH", 1);
                    assert (winningTotal.equals(testMap));
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45));
    }

    @DisplayName("당첨_통계_출력을 알맞은 순서대로 하면 통과")
    @Test
    void 당첨_통계_출력이_알맞은_값으로_출력된다() {
        Map<String, Integer> testMap = Map.of("FIRST", 0, "SECOND", 0, "THIRD", 0, "FOURTH", 0, "FIFTH", 1);
        OutputWinningTotalView outputWinningTotalView = new OutputWinningTotalView(testMap);

        assertSimpleTest(
                () -> {
                    outputWinningTotalView.printWinningTotal();
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
