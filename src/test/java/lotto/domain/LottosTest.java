package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @Test
    @DisplayName("Lottos 내부의 로또 리스트가 불변임을 증명하는 테스트")
    void lottos_변화_테스트() {
        //given
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        //when
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(lottoNumbers));

        Lottos lottos = new Lottos(lottoList);

        //then
        assertThatThrownBy(() -> {
            List<Lotto> retrievedLottos = lottos.getLottos();
            retrievedLottos.add(new Lotto(List.of(new LottoNumber(7), new LottoNumber(8),
                    new LottoNumber(9), new LottoNumber(10),
                    new LottoNumber(11), new LottoNumber(12))));
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}
