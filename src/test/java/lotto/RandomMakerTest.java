package lotto;

import static lotto.LottoConstants.NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomMakerTest {
    @DisplayName("생성된 숫자는 중복없음")
    @RepeatedTest(1000)
    void 생성된_숫자의_중복없음_테스트() {
        List<Integer> randomNumbers = RandomMaker.generateLottoNumbers(NUMBER_COUNT);
        assertThat(randomNumbers)
                .doesNotHaveDuplicates();
    }

    @DisplayName("생성된 숫자는 1~45범위이다")
    @RepeatedTest(1000)
    void 생성된_숫자의_범위_테스트() {
        List<Integer> randomNumbers = RandomMaker.generateLottoNumbers(NUMBER_COUNT);
        assertThat(randomNumbers)
                .allMatch(num -> 1 <= num && num <= 45);
    }

    @DisplayName("생성된 숫자는 정렬되어있다")
    @RepeatedTest(1000)
    void 생성된_숫자는_정렬되어있음() {
        List<Integer> randomNumbers = RandomMaker.generateLottoNumbers(NUMBER_COUNT);
        assertThat(randomNumbers)
                .isSorted();  // 리스트가 정렬되어 있는지 검증
    }
}
