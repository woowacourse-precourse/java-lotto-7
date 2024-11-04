package lotto.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InMemoryLottoRepositoryTest {

    InMemoryLottoRepository inMemoryLottoRepository;

    @BeforeEach
    void setUp() {
        inMemoryLottoRepository = InMemoryLottoRepository.getInstance();
    }

    @AfterEach
    void cleanUp() {
        inMemoryLottoRepository.clear();
    }

    @Test
    void getInstance() {
        inMemoryLottoRepository.clear();
    }

    @Test
    void 저장_조회_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        inMemoryLottoRepository.save(lotto);
        //then
        assertThat(List.of(1, 2, 3, 4, 5, 6))
                .isEqualTo(inMemoryLottoRepository.findAllLotto().getFirst().getNumbers());
    }

}
