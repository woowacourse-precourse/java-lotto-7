package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class LottoNumGeneratorTest {

    @DisplayName("generateNum 메소드는 6개의 중복되지 않는 숫자를 반환한다.")
    @RepeatedTest(100)
    void generateNum_returnsSixUniqueNumbers() {
        LottoNumGenerator generator = new LottoNumGenerator();
        List<Integer> numbers = generator.generateNum();

        // 리스트의 크기가 6인지 확인
        assertThat(numbers).hasSize(6);

        // 숫자들이 1~45 범위 내에 있는지 확인
        for (int number : numbers) {
            assertThat(number).isBetween(1, 45);
        }

        // 중복된 숫자가 없는지 확인
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertThat(uniqueNumbers).hasSize(6);

        // 오름차순으로 정렬되어 있는지 확인
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        assertThat(numbers).isEqualTo(sortedNumbers);
    }
}
