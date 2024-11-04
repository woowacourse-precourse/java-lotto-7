package lotto;

import lotto.model.Lotto;
import lotto.service.LottoResultManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    void 로또번호와_당첨번호를_비교한다() {
        LottoResultManager lottoResultManager = new LottoResultManager();

        List<Integer> lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        int result = lottoResultManager.compareLottoNumber(lotto, winningLotto, bonusNumber);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 당첨결과를_저장한다() {
        LottoResultManager lottoResultManager = new LottoResultManager();

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 9, 20)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        int[] result = lottoResultManager.saveLottoWinningResult(lottos, winningLotto, bonusNumber);
        assertThat(result[0]).isEqualTo(1);
        assertThat(result[1]).isEqualTo(1);
        assertThat(result[2]).isEqualTo(0);
        assertThat(result[3]).isEqualTo(1);
        assertThat(result[4]).isEqualTo(1);
    }

}
