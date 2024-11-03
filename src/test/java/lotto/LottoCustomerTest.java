package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoCustomerTest extends NsTest {

    LottoCustomer lottoCustomer = new LottoCustomer();

    @Test
    void buy() {
        assertSimpleTest(() -> {
            assertThat(lottoCustomer.buy(Lotto.class, 8000).size()).isEqualTo(8);
            assertThat(output()).contains("8개를 구매했습니다.");
        });
    }

    @Test
    void viewTotalProfit() {
        lottoCustomer.viewTotalProfit(5000, 1248);
        assertThat(output()).contains("총 수익률은 25.0%입니다.");
    }

    @Test
    void setWinningLotto() {
        assertSimpleTest(() -> {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 7;
            WinningLotto result = lottoCustomer.setWinningLotto(numbers, bonusNumber);
            assertThat(result.getNumbers()).containsExactly(1,2,3,4,5,6);
            assertThat(result.getBonusNum()).isEqualTo(7);
        });
    }

    @Test
    void showStatistics() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            List<Lotto> lottoTickets = lottoCustomer.buy(Lotto.class, 3000);
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 7;
            WinningLotto winningLotto = lottoCustomer.setWinningLotto(numbers, bonusNumber);
            lottoCustomer.showStatistics(lottoTickets, winningLotto);
            assertThat(output()).contains(
                    "당첨 통계",
                    "- - -",
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개"
                    );
        }, List.of(1,2,3,7,8,9), List.of(1,2,7,8,9,10), List.of(1,7,8,9,10,11));
    }

    @Override
    protected void runMain() {

    }
}