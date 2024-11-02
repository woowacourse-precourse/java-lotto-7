package lotto.purchase;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("숫자 배열이 주어지면 정렬한다.")
    @Test
    void shouldSortNumbersWhenGiveRawNumbers() {
        // give
        List<Integer> actualNumbers = new ArrayList<>(List.of(1, 4, 5, 2, 10, 17));
        List<Integer> expectedNumbers = List.of(1, 2, 4, 5, 10, 17);
        LottoGenerator lottoGenerator = new LottoGenerator();

        // when
        lottoGenerator.manufactureRawNumbers(actualNumbers);

        // then
        Assertions.assertThat(actualNumbers).isEqualTo(expectedNumbers);
    }

    @DisplayName("원하는 숫자만큼 로또를 발행하여 반환한다.")
    @Test
    void shouldMakeLotteriesWhenRequestCreate() {
        // give
        int expectedTotalLotteryCount = 3;
        LottoGenerator lottoGenerator = new LottoGenerator();

        // when
        int actualTotalLotteryCount = lottoGenerator.createLotteries(expectedTotalLotteryCount).size();

        // then
        Assertions.assertThat(actualTotalLotteryCount).isEqualTo(expectedTotalLotteryCount);
    }
}
