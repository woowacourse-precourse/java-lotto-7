package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.Map;
import lotto.customer.LottoCustomer;
import lotto.item.WinningLotto;
import lotto.numberSelector.RandomSelector;
import org.junit.jupiter.api.Test;

class LottoCustomerTest extends NsTest {

    LottoCustomer lottoCustomer = new LottoCustomer();

    @Test
    void buy() {
        assertSimpleTest(() -> {
            run("8000");
            assertThat(lottoCustomer.buy(new RandomSelector()).size()).isEqualTo(8);
            assertThat(output()).contains("8개를 구매했습니다.");
        });
    }

    @Test
    void setWinningLotto() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5,6", "7");
            WinningLotto result = lottoCustomer.setWinningLotto();
            assertThat(result.getNumbers()).containsExactly(1,2,3,4,5,6);
            assertThat(result.getBonusNum()).isEqualTo(7);
        });
    }

    @Test
    void countPrizeAndStatistics() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            Map<Prize, Integer> result = lottoCustomer.countPrize(
                    lottoCustomer.buy(new RandomSelector()), lottoCustomer.setWinningLotto());
            assertThat(result).contains(
                    Map.entry(Prize.FIFTH, 0),
                    Map.entry(Prize.FOURTH, 1),
                    Map.entry(Prize.THIRD, 2),
                    Map.entry(Prize.SECOND, 3),
                    Map.entry(Prize.FIRST, 2)
                    );

            lottoCustomer.statistics(result);
            assertThat(output()).contains(
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 2개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 3개",
                    "6개 일치 (2,000,000,000원) - 2개",
                    "총 수익률은 " +
                            String.format("%.1f" , calExpected(8000, 0,1,2,3,2))+
                            "%입니다."
            );
        },
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,7),
                List.of(1,2,3,4,5,7),
                List.of(1,2,3,4,5,7),
                List.of(1,2,3,4,5,8),
                List.of(1,2,3,4,5,8),
                List.of(1,2,3,4,8,9));
    }

    private float calExpected(int money, int fifth, int fourth, int third, int second, int first) {
        long total = 0;
        total += 5000L * fifth;
        total += 50000L * fourth;
        total += 1500000L * third;
        total += 30000000L * second;
        total += 2000000000L * first;

        return (float) total / money * 100;
    }

    @Override
    protected void runMain() {

    }
}