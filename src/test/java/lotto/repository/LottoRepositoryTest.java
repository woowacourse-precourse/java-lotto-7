package lotto.repository;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoRepositoryTest {

    private static LottoRepository lottoRepository;
    @BeforeEach
    void setup(){
        lottoRepository = new LottoRepositoryImpl(new ArrayList<>());
    }
    @Test
    void 로또_저장_테스트(){
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lottoRepository.save(lotto1);
        lottoRepository.save(lotto2);

        List<Lotto> lottos = lottoRepository.findAll();

        Assertions.assertThat(lottos)
                .hasSize(2)
                .contains(lotto1)
                .containsExactly(lotto1, lotto2);
    }

}
