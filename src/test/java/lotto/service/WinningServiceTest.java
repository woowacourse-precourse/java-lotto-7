package lotto.service;

import lotto.model.UserLotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningServiceTest {
    private WinningService winningService;

    @BeforeEach
    void setUp() {
        winningService = new WinningService();
    }

    @Test
    void 로또_결과_검증_테스트() {
        List<List<Integer>> purchasedLotto = new ArrayList<>();
        purchasedLotto.add(List.of(1, 2, 3, 4, 5, 6)); // 1등 (6개)
        purchasedLotto.add(List.of(1, 2, 3, 4, 5, 7)); // 2등 (5개 + 보너스)
        purchasedLotto.add(List.of(1, 2, 3, 4, 5, 45)); // 3등 (5개)
        purchasedLotto.add(List.of(1, 2, 3, 4, 44, 45)); // 4등 (4개)
        purchasedLotto.add(List.of(1, 2, 3, 43, 44, 45)); // 5등 (3개)

        UserLotto userLotto = new UserLotto();
        userLotto.setNumbers("1,2,3,4,5,6");
        userLotto.setBonusNumber("7");

        winningService.matchLotto(purchasedLotto, userLotto);

        assertThat(WinningLotto.THREE_MATCH.getMatchCount()).isEqualTo(1);
        assertThat(WinningLotto.FOUR_MATCH.getMatchCount()).isEqualTo(1);
        assertThat(WinningLotto.FIVE_MATCH.getMatchCount()).isEqualTo(1);
        assertThat(WinningLotto.FIVE_MATCH_BONUS.getMatchCount()).isEqualTo(1);
        assertThat(WinningLotto.SIX_MATCH.getMatchCount()).isEqualTo(1);
    }

}