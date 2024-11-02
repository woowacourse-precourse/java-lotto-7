package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import java.util.Set;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    private final LottoGenerator generator = new LottoGenerator();

    @Test
    void 로또번호_검증() {
        //given
        List<Integer> lottoNumbers = generator.getLottoNumbers();
        Set<Integer> lottoNumbersSet = Set.copyOf(lottoNumbers);

        assertThat(lottoNumbersSet).hasSize(6);
        assertThat(lottoNumbersSet).allMatch(num -> num >= 1 && num <= 45);
    }


}