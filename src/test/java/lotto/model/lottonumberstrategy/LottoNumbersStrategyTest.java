package lotto.model.lottonumberstrategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersStrategyTest {

    @DisplayName("1부터 45까지 중복되지 않는 랜덤한 숫자 리스트를 생성한다.")
    @Test
    void generateNumbers() {
        //given
        NumberGeneratorStrategy lottoNumbersStrategy = new LottoNumbersStrategy();

        //when
        List<Integer> numbers = lottoNumbersStrategy.generateNumbers();

        //then
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        assertThat(numberSet.size()).isEqualTo(numbers.size()).isBetween(1, 45);
    }

    @DisplayName("생성된 랜덤 번호는 오름차순으로 정렬된다.")
    @Test
    void sortedRandomNumber() {
        //given
        NumberGeneratorStrategy lottoNumbersStrategy = new LottoNumbersStrategy();

        //when
        List<Integer> numbers = lottoNumbersStrategy.generateNumbers();

        //then
        assertThat(numbers).isSorted();
    }
}
