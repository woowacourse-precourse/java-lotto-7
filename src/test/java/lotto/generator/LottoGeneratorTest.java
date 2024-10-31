package lotto.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGeneratorImpl();
    }
    @Test
    void 로또_번호_6개_생성_테스트() {
        List<Integer> lottoNumbers = lottoGenerator.generate();
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    void 로또_번호_범위_테스트() {
        List<Integer> lottoNumbers = lottoGenerator.generate();
        assertThat(lottoNumbers).allMatch(number -> number >= 1 && number <= 45);
    }
}
