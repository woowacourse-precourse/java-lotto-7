package lotto.repository;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRepositoryImplTest {

    private LottoRepositoryImpl lottoRepository;
    private Lotto sampleLotto;

    @BeforeEach
    void setUp() {
        lottoRepository = new LottoRepositoryImpl();
        sampleLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 로또를_저장하고_찾을_수_있다() {
        Lotto savedLotto = lottoRepository.save(sampleLotto);
        assertThat(savedLotto).isEqualTo(sampleLotto);

        Lotto foundLotto = lottoRepository.findWinningNums();
        assertThat(foundLotto).isEqualTo(sampleLotto);
    }
}
