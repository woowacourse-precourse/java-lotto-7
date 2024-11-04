package lotto.service;

import static lotto.util.Constant.MAX_LOTTO_NUMBER;
import static lotto.util.Constant.MIN_LOTTO_NUMBER;
import static lotto.util.Constant.WINNING_NUMBER_COUNT;
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
        assertThat(numbers).hasSize(WINNING_NUMBER_COUNT);
        assertThat(numbers).allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER);
        assertThat(numbers).doesNotHaveDuplicates();
    }
}