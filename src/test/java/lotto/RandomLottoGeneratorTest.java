package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoGeneratorTest {
    private final LottoGenerator randomLottoGenerator = new RandomLottoGenerator();

    @DisplayName("랜덤으로 생성된 로또 번호는 1부터 45 사이의 고유한 6개의 숫자여야 한다.")
    @Test
    void 랜덤으로_생성된_로또_번호는_고유해야한다() {
        Lotto lotto = randomLottoGenerator.generate();
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).hasSize(6); // 번호 개수는 6개여야 함
        assertThat(numbers).allMatch(num -> num >= 1 && num <= 45); // 각 번호는 1과 45 사이여야 함

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertThat(uniqueNumbers.size()).isEqualTo(numbers.size()); // 모든 번호는 고유해야 함
    }
}
