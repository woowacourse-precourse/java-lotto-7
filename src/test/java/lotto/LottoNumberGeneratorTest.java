package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @DisplayName("로또의 총 개수로부터 로또를 추첨할 수 있다")
    @Test
    void generateTest() {
        assertThat(LottoNumberGenerator.generate(2).size()).isEqualTo(2);
    }
}