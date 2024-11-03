package lotto.repository;

import lotto.domain.Lotto;
import org.junit.jupiter.api.AfterEach;
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

        lottoRepository.clear();
    }

    @AfterEach
    void tearDown() {
        lottoRepository.clear(); // 테스트 후 로또 저장소 초기화
    }

    @Test
    void 로또를_저장하고_찾을_수_있다() {
        Lotto savedLotto = lottoRepository.save(sampleLotto);
        assertThat(savedLotto).isEqualTo(sampleLotto);

        Lotto foundLotto = lottoRepository.findWinningNums();
        assertThat(foundLotto).isEqualTo(sampleLotto);
    }
}
