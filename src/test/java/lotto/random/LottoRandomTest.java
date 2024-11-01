package lotto.random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoRandomTest {

    private LottoRandom lottoRandom;

    @BeforeEach
    void setup() {
        lottoRandom = () -> List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 뽑은_로또_번호_숫자의_범위는_1부터_45_사이이다() {
        List<Integer> lottoNumbers = lottoRandom.getLottoNumbers();
        assertThat(lottoNumbers.getFirst()).isBetween(1, 45);
    }

    @Test
    void 뽑은_로또_번호_숫자는_중복되지_않는다() {
        List<Integer> lottoNumbers = lottoRandom.getLottoNumbers();
        Set<Integer> filteredNumbers = new HashSet<>();
        filteredNumbers.addAll(lottoNumbers);
        assertThat(lottoNumbers.size()).isEqualTo(filteredNumbers.size());
    }

    @Test
    void 뽑은_번호는_총_6개이다() {
        List<Integer> lottoNumbers = lottoRandom.getLottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
