package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {

    @Test
    void 구매한_개수만큼_로또를_가지고있다() throws Exception {
        LottoPurchase purchase = LottoPurchase.purchase(provideLottos(50));
        assertThat(purchase.count()).isEqualTo(50);
    }

    @Test
    void 구입한_로또들의_등수를_확인할_수_있다() throws Exception {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoPurchase purchase = LottoPurchase.purchase(List.of(lotto));
        Winning winning = new Winning(List.of(1, 2, 3, 27, 36, 45), 7);

        Map<Lotto, Rank> lottoRanks = purchase.rankLottos(winning);
        Collection<Rank> ranks = lottoRanks.values();

        assertThat(ranks.size()).isEqualTo(1);
        assertThat(ranks).containsOnly(Rank.FIFTH);
    }

    @DisplayName("구매할 로또가 하나도 없으면 예외가 발생한다.")
    @Test
    void 구매할_로또가_하나도_없으면_예외가_발생한다() throws Exception {
        assertThatThrownBy(() -> LottoPurchase.purchase(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또가 1000개를 넘으면 예외가 발생한다")
    @Test
    void 구매할_로또가_1000개를_넘으면_예외가_발생한다() throws Exception {
        assertThatThrownBy(() -> LottoPurchase.purchase(provideLottos(1001)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Lotto> provideLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, amount)
            .forEach(sequence -> lottos.add(new Lotto(List.of(1, 9, 18, 27, 36, 45))));

        return lottos;
    }
}