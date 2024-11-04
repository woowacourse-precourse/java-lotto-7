package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.entry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    User user = new User();

    @DisplayName("구입 금액만큼 로또 생성 확인")
    @Test
    void createLotto() {
        assertThat(user.createLotto(10).size()).isEqualTo(10);
    }

    @DisplayName("당첨 개수 계산")
    @Test
    void countRank() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(12, 13, 14, 15, 23, 26)),
                new Lotto(List.of(5, 7, 8, 19, 20, 45)), new Lotto(List.of(1, 2, 3, 4, 7, 9)),
                new Lotto(List.of(1, 2, 3, 4, 9, 10)), new Lotto(List.of(1, 2, 3, 4, 9, 11)));
        Lotto winnigNumbers = new Lotto(List.of(1, 2, 3, 4, 9, 10));
        int bonusNumber = 7;

        assertThat(user.countRank(lottos, winnigNumbers, bonusNumber)).hasSize(5)
                .contains(entry(Rank.FIRST, 1))
                .contains(entry(Rank.SECOND, 1))
                .contains(entry(Rank.THIRD, 1))
                .contains(entry(Rank.FOURTH, 1))
                .contains(entry(Rank.ZERO, 2))
                .doesNotContainKey(Rank.FIFTH);
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateReturn() {
        Map<Rank, Integer> winnings = new HashMap<>();
        winnings.put(Rank.FIFTH, 1);
        int purchaseAmount = 8000;

        assertThat(user.calculateReturn(winnings, purchaseAmount)).isEqualTo(62.5);
    }
}