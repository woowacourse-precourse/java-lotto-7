package lotto;

import lotto.number.LottoNumber;
import lotto.winner.WinnerLottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    void 구매_개수_만큼_로또_구매() {
        Lottos lottos = new Lottos();
        lottos.purchaseLottos(2, () -> {
            return List.of(1, 2, 3, 4, 5, 6);
        });

        assertThat(lottos.getLottos().size()).isEqualTo(2);
        assertThat(lottos.getLottos().getFirst()).isEqualTo(Lotto.createOfLotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 로또_구매_당첨_상금_테스트() {
        Lottos lottos = new Lottos(List.of(Lotto.createOfLotto("1,2,3,4,5,6"), Lotto.createOfLotto("1,2,3,4,5,7"), Lotto.createOfLotto("1,2,7,8,9,10"), Lotto.createOfLotto("1,2,3,4,5,8")));

        WinnerLottoNumber winnerLottoNumber = WinnerLottoNumber.createOfWinnerLottoNumber("1,2,3,4,5,6");
        lottos.hitLottoNumbers(winnerLottoNumber, new LottoNumber(7));

        assertThat(lottos.getPrizes()).isEqualTo(Map.of(Prize.ONE, 1, Prize.TWO, 1, Prize.THREE, 1, Prize.NOTHING, 1));
    }

}
