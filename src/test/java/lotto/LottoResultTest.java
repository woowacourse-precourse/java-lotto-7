package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("당첨 통계를 올바르게 계산한다.")
    void calculateResultsCorrectly() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9))
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResult result = new LottoResult(lottos, winningNumbers, bonusNumber);
        result.printResult(); // 수동으로 출력 확인 가능

        // 자동 검증은 수익률에 대한 assert로 가능
        double expectedYield = (2000000000 + 30000000 + 1500000) / (double) (lottos.size() * 1000) * 100;
        assertThat(result.calculateYield(2000000000 + 30000000 + 1500000)).isEqualTo(expectedYield);
    }
}