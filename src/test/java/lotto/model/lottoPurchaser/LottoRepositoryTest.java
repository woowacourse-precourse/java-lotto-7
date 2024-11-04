package lotto.model.lottoPurchaser;

import lotto.model.lotto.Lotto;
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
    @DisplayName("로또 저장소에 하나의 로또가 잘 저장되는지 확인한다.")
    void shouldStoreOneLottoSuccessfully() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        lottoRepository.saveLotto(lotto);

        // then
        assertThat(lottoRepository.findAllLotto().size()).isEqualTo(1);
    }


    @Test
    @DisplayName("로또 저장소에 두개의 로또가 잘 저장되는지 확인한다.")
    void shouldStoreTwoLottosSuccessfully() {
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
