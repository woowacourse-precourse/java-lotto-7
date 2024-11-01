package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    void 구매한_로또들을_당첨번호와_비교하여_당첨된_등수를_저장한다() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        Lottos lottos = new Lottos();
        lottos.saveLotto(lotto1);
        lottos.saveLotto(lotto2);
        lottos.saveLotto(lotto3);

        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(
                7,
                List.of(1, 2, 3, 4, 5, 6)
        );

        LottoResult lottoResult = new LottoResult(lottos, winningNumbers, bonusNumber);

        assertThat(lottoResult.getLottoResult())
                .isEqualTo(
                        Map.of(
                                Rank.FIRST, 1,
                                Rank.SECOND, 1,
                                Rank.THIRD, 0,
                                Rank.FOURTH, 0,
                                Rank.FIFTH, 1,
                                Rank.NONE, 0
                        )
                );
    }
}
