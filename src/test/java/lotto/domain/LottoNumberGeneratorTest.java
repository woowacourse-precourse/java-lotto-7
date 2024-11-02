package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.utils.LottoNumberGenerator;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    LottoNumberGenerator generator = new LottoNumberGenerator();

    @Test
    public void 로또번호_생성_테스트() {
        List<Integer> numbers = generator.generator();

        assertThat(numbers).hasSize(6);
        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
        assertThat(numbers).doesNotHaveDuplicates();
    }

}