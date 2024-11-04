package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPoolTest {

    @DisplayName("로또 풀에 로또가 하나 추가된다.")
    @Test
    void add_whenOneLottoIsAdded() {
        //given
        LottoPool lottoPool = new LottoPool();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        lottoPool.add(lotto);

        //then
        assertThat(lottoPool).hasSize(1);
    }

    @DisplayName("로또 풀에 로또가 여러 개 추가된다.")
    @Test
    void add_whenMultipleLottosAreAdded() {
        //given
        LottoPool lottoPool = new LottoPool();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        lottoPool.add(lotto1);
        lottoPool.add(lotto2);
        lottoPool.add(lotto3);

        //then
        assertThat(lottoPool).hasSize(3);
    }
}