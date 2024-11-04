package lotto.domain;

import java.util.List;
import lotto.global.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @DisplayName("getWinningLottos_메서드_테스트_01")
    @Test
    void 기능_테스트() {
        Lotto lotto = new Lotto(List.of(5, 10, 15, 20, 25, 30));
        Lotto lotto1 = new Lotto(List.of(7, 14, 21, 28, 35, 42));
        Lotto lotto2 = new Lotto(List.of(3, 9, 12, 18, 24, 33));
        Lotto winningLotto1 = new Lotto(List.of(1, 2, 3, 4, 27, 38));
        Lotto winningLotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        int BonusNum = 7;

        Lottos lottos = new Lottos(List.of(lotto, lotto1, lotto2, winningLotto1, winningLotto2));
        List<LottoRank> expected = lottos.getWinningLottos(winningNumbers, BonusNum);

        Assertions.assertThat(expected).hasSize(2);
    }
}
