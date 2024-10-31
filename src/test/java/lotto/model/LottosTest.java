package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    void 로또의_개수를_구할_수_있다() {
        // given
        Lottos lottos = new Lottos();

        // when
        int real = lottos.count();

        // then
        int expected = 0;
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void 로또를_추가할_수_있다() {
        // given
        LottoNumber lottoNumber = new LottoNumber();
        Lotto lotto = new Lotto(lottoNumber.generate());
        Lottos lottos = new Lottos();

        // when
        lottos.add(lotto);

        // then
        int real = lottos.count();
        int expected = 1;
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void 로또_정보를_가져올_수_있다() {
        // given
        LottoNumber lottoNumber = new LottoNumber();
        Lotto lotto = new Lotto(lottoNumber.generate());
        Lottos lottos = new Lottos();

        // when
        lottos.add(lotto);

        // then
        String real = lottos.information();
        assertThat(real).contains("[")
                .contains("]")
                .contains(",");
    }

}