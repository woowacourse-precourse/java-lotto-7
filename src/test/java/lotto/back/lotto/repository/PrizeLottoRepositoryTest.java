package lotto.back.lotto.repository;

import java.util.List;
import java.util.UUID;
import lotto.back.lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PrizeLottoRepositoryTest {

    private final PrizeLottoRepository prizeLottoRepository = new PrizeLottoRepository();

    @Test
    void 기본_동작_테스트() {
        // given
        UUID uuid = UUID.randomUUID();
        Lotto prizeLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        prizeLottoRepository.save(uuid, prizeLotto);
        Lotto savedLotto = prizeLottoRepository.findById(uuid);

        // then
        Assertions.assertThat(savedLotto).isEqualTo(prizeLotto);
    }



}