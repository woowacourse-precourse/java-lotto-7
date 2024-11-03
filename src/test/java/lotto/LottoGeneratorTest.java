package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoGeneratorTest {
    @Test
    void 로또_번호_생성_성공() {
        Lotto lotto = LottoGenerator.generate();
        assertThat(lotto.getNumbers()).hasSize(6);
        assertThat(lotto.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
    }
}
