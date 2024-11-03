package lotto.service;

import static lotto.domain.LottoRule.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.generator.SortedLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @DisplayName("로또를 구매하고 로또의 개수를 확인한다.")
    @Test
    void purchase() {
        //given
        LottoService lottoService = new LottoService(new SortedLottoNumberGenerator());

        //when
        int money = 10000;
        List<Lotto> purchasedLotto = lottoService.purchase(money);

        //then
        assertThat(purchasedLotto.size()).isEqualTo(money / LOTTO_PRICE.getValue());
    }

    @DisplayName("로또 당첨 결과를 반환한다.")
    @Test
    void match() {
        //given
        LottoService lottoService = new LottoService(new SortedLottoNumberGenerator());
        Lotto fisrt = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(List.of(1, 2, 3, 4, 9, 7));
        Lotto third = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        Lotto fourth = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        Lotto fifth = new Lotto(List.of(1, 2, 3, 14, 15, 16));

        List<Lotto> lottos = List.of(fisrt, second, third, fourth, fifth);
        List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        //when
        LottoResult lottoResult = lottoService.match(lottos, winNumber, bonusNumber);

        //then
        assertThat(lottoResult.count(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.count(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.count(Rank.THIRD)).isEqualTo(1);
        assertThat(lottoResult.count(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.count(Rank.FIFTH)).isEqualTo(1);
    }
}