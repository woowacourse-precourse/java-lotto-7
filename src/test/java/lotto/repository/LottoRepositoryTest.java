package lotto.repository;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRepositoryTest {
    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    @BeforeEach
    void setUp() {
        lottoRepository.findAll().clear();
    }

    @Test
    @DisplayName("로또 추가")
    void addLotto() {
        // given
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        // when
        lottoRepository.addLotto(lotto);
        // then
        assertThat(lottoRepository.findAll()).contains(lotto);
    }

    @Test
    @DisplayName("모든 로또 조회")
    void findAll() {
        // given
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        // when
        lottoRepository.addLotto(lotto);
        // then
        assertThat(lottoRepository.findAll()).contains(lotto);
        assertThat(lottoRepository.getLottoCount()).isEqualTo(1);

    }

    @Test
    @DisplayName("로또 개수 count")
    void getLottoCount() {
        // given
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        // when
        lottoRepository.addLotto(lotto);
        // then
        assertThat(lottoRepository.getLottoCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("인스턴스 생성")
    void getInstance() {
        LottoRepository lottoRepository2 = LottoRepository.getInstance();
        assertNotNull(lottoRepository);
        assertNotNull(lottoRepository2);
    }


    @Test
    @DisplayName("getInstance 같은 객체를 반환하는지 테스트")
    void getInstance2() {
        // given
        // when
        LottoRepository lottoRepository2 = LottoRepository.getInstance();

        // then
        assertEquals(lottoRepository, lottoRepository2);
    }

}