package lotto.random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("뽑은 로또 번호 숫자는")
class LottoRandomTest {

    private LottoRandom lottoRandom;

    @BeforeEach
    void setup() {
        lottoRandom = new LottoRandomStrategy();
    }

    @Test
    void 범위가_1부터_45_사이다() {
        List<Integer> lottoNumbers = lottoRandom.getLottoNumbers();
        assertThat(lottoNumbers.getFirst()).isBetween(1, 45);
    }

    @Test
    void 서로_중복되지_않는다() {
        List<Integer> lottoNumbers = lottoRandom.getLottoNumbers();
        Set<Integer> filteredNumbers = new HashSet<>();
        filteredNumbers.addAll(lottoNumbers);
        assertThat(lottoNumbers.size()).isEqualTo(filteredNumbers.size());
    }

    @Test
    void 총_6개이다() {
        List<Integer> lottoNumbers = lottoRandom.getLottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
