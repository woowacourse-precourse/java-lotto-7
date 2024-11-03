package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class UserLottoTest {

    @Test
    void 유저_로또_번호를_정상적으로_저장한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        UserLotto userLotto = new UserLotto(numbers);

        assertThat(userLotto.getNumbers()).isEqualTo(numbers);
    }

    @Test
    void 당첨_등수를_설정하고_반환한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        UserLotto userLotto = new UserLotto(numbers);
        WinningRank winningRank = WinningRank.FIRST; // 예시로 FIRST 등수를 사용

        userLotto.setWinningRank(winningRank);

        assertThat(userLotto.getWinningRank()).isEqualTo(winningRank);
    }

    @Test
    void 보너스_번호를_설정하고_검사한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        UserLotto userLotto = new UserLotto(numbers);

        userLotto.setHasBonusNum(6);
        assertThat(userLotto.getHasBonusnum()).isTrue();

        userLotto.setHasBonusNum(7);
        assertThat(userLotto.getHasBonusnum()).isFalse();
    }
}
