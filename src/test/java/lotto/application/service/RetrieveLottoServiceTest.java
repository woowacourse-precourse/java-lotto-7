package lotto.application.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.repository.InMemoryLottoRepository;
import lotto.domain.repository.LottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RetrieveLottoServiceTest {

    private LottoRepository lottoRepository = InMemoryLottoRepository.getInstance();
    private RetrieveLottoService retrieveLottoService = new RetrieveLottoService(lottoRepository);

    @BeforeEach
    void setUp() {
        lottoRepository.clear();
    }

    @DisplayName("저장된 로또를 모두 가져온다.")
    @Test
    void getAll() {
        Assertions.assertSimpleTest(() -> {
            List<Lotto> lottos = List.of(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(5, 6, 7, 8, 9, 10)),
                    new Lotto(List.of(1, 2, 3, 4, 5, 6))
            );
            lottoRepository.saveAll(lottos);
            List<Lotto> retrieveLottos = retrieveLottoService.retrieveAll();
            assertThat(retrieveLottos).hasSize(3);
            assertThat(retrieveLottos.get(1).getNumbers()).isEqualTo(List.of(5, 6, 7, 8, 9, 10));
        });
    }
}
