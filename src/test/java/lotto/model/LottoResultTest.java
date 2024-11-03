package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("당첨 확인 테스트")
    @Test
    void getMatchCountTest() {
        List<Lotto> tickets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)));
        List<Integer> winningNUm = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;

        LottoResult result = new LottoResult(tickets, winningNUm, bonusNum);
        Map<Rank, Integer> matchCnt = result.getMatchCount();

        assertThat(matchCnt.get(Rank.FIRST)).isEqualTo(2);
        assertThat(matchCnt.get(Rank.SECOND)).isEqualTo(1);
        assertThat(matchCnt.get(Rank.THIRD)).isEqualTo(0);
        assertThat(matchCnt.get(Rank.THIRD)).isEqualTo(0);
        assertThat(matchCnt.get(Rank.FOURTH)).isEqualTo(1);
    }

    @DisplayName("널값 예외 테스트")
    @Test
    void getMatchCountExceptionTest() {
        List<Lotto> tickets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                null
        );

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThatThrownBy(() -> new LottoResult(tickets, winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수익률 확인 테스트")
    @Test
    void getProfitRateTest() {
        List<Lotto> tickets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)));
        List<Integer> winningNUm = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;

        LottoResult result = new LottoResult(tickets, winningNUm, bonusNum);
        double profit = (2000000000 + 2000000000 + 30000000 + 50000) / (4 * 1000.0) * 100;

        assertThat(result.getProfitRate()).isEqualTo(profit);
    }
}