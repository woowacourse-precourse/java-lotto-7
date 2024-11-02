package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @DisplayName("내 로또 번호와 당첨 번호가 5개가 일치하는 경우")
    @Test
    void 당첨되었을_경우_정상_작동한다_1() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 6, 8));
        BonusNumber bonusNumber = new BonusNumber(12);
        Prize prize = Prize.getPrize(winningLotto, myLotto, bonusNumber);
        assertThat(prize).extracting("rank", "money")
                .contains(Prize.THIRD_PRIZE.getRank(), Prize.THIRD_PRIZE.getMoney());
    }

    @DisplayName("내 로또 번호와 당첨 번호가 3개가 일치하는 경우")
    @Test
    void 당첨되었을_경우_정상_작동한다_2() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 9, 10, 11));
        BonusNumber bonusNumber = new BonusNumber(12);
        Prize prize = Prize.getPrize(winningLotto, myLotto, bonusNumber);
        assertThat(prize).extracting("rank", "money")
                .contains(Prize.FIFTH_PRIZE.getRank(), Prize.FIFTH_PRIZE.getMoney());
    }

    @DisplayName("내 로또 번호와 당첨 번호가 2개 일치하는 경우")
    @Test
    void 당첨되지_못_한경우_정상_작동한다_1() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(5, 6, 9, 10, 11, 12));
        BonusNumber bonusNumber = new BonusNumber(12);
        Prize prize = Prize.getPrize(winningLotto, myLotto, bonusNumber);
        assertThat(prize).extracting("rank", "money")
                .contains(Prize.NO_PRIZE.getRank(), Prize.NO_PRIZE.getMoney());
    }


    @DisplayName("내 로또 번호와 당첨 번호가 1개도 일치하지 않을 경우")
    @Test
    void 당첨되지_못_한경우_정상_작동한다_2() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(7, 8, 9, 10, 11, 12));
        BonusNumber bonusNumber = new BonusNumber(12);
        Prize prize = Prize.getPrize(winningLotto, myLotto, bonusNumber);
        assertThat(prize).extracting("rank", "money")
                .contains(Prize.NO_PRIZE.getRank(), Prize.NO_PRIZE.getMoney());
    }

    @DisplayName("내 로또 번호와 당첨 번호가 전부 일치할 경우 당첨 전략을 조회한다.")
    @Test
    void 당첨_전략을_조회한다() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(12);
        Prize prize = Prize.getPrize(winningLotto, myLotto, bonusNumber);
        assertThat(prize)
                .extracting(Prize::isBonusNumberRequired, Prize::getConditionOfMatchCount)
                .containsExactly(false, 6);
    }
}