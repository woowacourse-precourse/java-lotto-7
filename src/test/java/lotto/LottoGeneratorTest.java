package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    void 랜덤_로또_번호가_6개_생성된다() {
        LottoGenerator generator = new LottoGenerator();
        Lotto lotto = generator.generate();

        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 생성된_로또_번호는_1에서_45_사이의_숫자로_구성된다() {
        LottoGenerator generator = new LottoGenerator();
        Lotto lotto = generator.generate();

        assertThat(lotto.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
    }

    @Test
    void 생성된_로또_번호는_중복되지_않는다() {
        LottoGenerator generator = new LottoGenerator();
        Lotto lotto = generator.generate();

        Set<Integer> uniqueNumbers = new HashSet<>(lotto.getNumbers());
        assertThat(uniqueNumbers.size()).isEqualTo(6);
    }
}
