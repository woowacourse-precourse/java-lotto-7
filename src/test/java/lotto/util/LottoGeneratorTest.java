package lotto.util;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또가 정상적으로 뽑히는지 테스트")
    void generateLottoNumbersTest() {
        // given
        List<Integer> numbers = LottoGenerator.generateLottoNumbers();

        // when
        int numberOfLotto = Lotto.NUMBER_OF_LOTTO;

        // then
        assertEquals(numberOfLotto, numbers.size());
    }

    @Test
    @DisplayName("로또 번호가 오름차순으로 정렬되었는지 테스트")
    void generateLottoNumbersSortedTest() {
        // given
        List<Integer> numbers = LottoGenerator.generateLottoNumbers();

        // when
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();

        // then
        assertEquals(sortedNumbers, numbers);
    }

}
