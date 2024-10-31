package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomLottoNumberGeneratorTest {

    @RepeatedTest(1000)
    @DisplayName("랜덤 로또 번호 생성기는 중복된 번호를 생성하지 않는다.")
    void whenGenerateLottoNumberThenReturnUniqueNumbers() {
        //given
        boolean expected = true;

        // when
        RandomLottoNumberGenerator generator = new RandomLottoNumberGenerator();
        List<Integer> numbers = generator.generateLottoNumbers();
        Set<Integer> setNumbers = new HashSet<>(numbers);
        boolean actual = numbers.size() == setNumbers.size();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
