package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoNumberGeneratorTest {

    private final RandomLottoNumberGenerator generator = new RandomLottoNumberGenerator();

    @Test
    @DisplayName("1에서 45 사이의 중복되지 않는 6개의 로또 번호가 생성되는지 확인")
    void 로또_번호_생성_범위와_중복_검증() {
        List<Integer> numbers = generator.generateNumber();
        assertThat(numbers).hasSize(6);
        assertThat(numbers).allMatch(num -> num >= 1 && num <= 45);
        assertThat(numbers).doesNotHaveDuplicates();
    }
}