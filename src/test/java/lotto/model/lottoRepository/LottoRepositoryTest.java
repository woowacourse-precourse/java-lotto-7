package lotto.model.lottoRepository;

import lotto.model.lotto.Lotto;
import lotto.model.lottoBuyer.InMemoryLottoRepository;
import lotto.model.lottoBuyer.LottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoRepositoryTest {

    private LottoRepository lottoRepository;

    @BeforeEach
    void setUp() {
        lottoRepository = new InMemoryLottoRepository();
    }

    @Test
    @DisplayName("로또 저장소에 로또가 잘 저장되는지를 저장된 로또 개수로 확인한다")
    void saveLottoInLottoRepositoryTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        lottoRepository.saveLotto(lotto);

        // then
        assertThat(lottoRepository.findAllLotto().size()).isEqualTo(1);
    }


    @Test
    void saveLottoInLottoRepositoryTest2() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(11, 22, 33, 44, 55, 66));

        // when
        lottoRepository.saveLotto(lotto1);
        lottoRepository.saveLotto(lotto2);

        // then
        assertThat(lottoRepository.findAllLotto().size()).isEqualTo(2);
    }
}
