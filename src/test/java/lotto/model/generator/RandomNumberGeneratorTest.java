package lotto.model.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("로또 번호는 1~45 범위의 숫자 6개를 생성한다.")
    void testGenerateRandomLottoNumber() {
        List<Integer> numbers = new RandomNumberGenerator().generateLottoNumbers();

        assertThat(numbers).hasSize(6);
        assertThat(numbers).allMatch(number -> 1 <= number && number <= 45);
        assertThat(numbers.size()).isEqualTo(new HashSet<>(numbers).size());
    }

}