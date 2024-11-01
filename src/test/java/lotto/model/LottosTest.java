package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    void 로또의_개수를_구할_수_있다() {
        // given
        Lottos lottos = new Lottos();

        // when
        int real = lottos.size();

        // then
        int expected = 0;
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void 로또를_추가할_수_있다() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers.generate());
        Lottos lottos = new Lottos();

        // when
        lottos.add(lotto);

        // then
        int real = lottos.size();
        int expected = 1;
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void 로또_정보를_가져올_수_있다() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers.generate());
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