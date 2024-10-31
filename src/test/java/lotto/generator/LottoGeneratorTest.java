package lotto.generator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    void 로또_번호_6개_생성_테스트() {
        List<Integer> lottoNumbers = new lottoGenerator.generate();
        assertThat(lottoNumbers).hasSize(6);
    }
}
