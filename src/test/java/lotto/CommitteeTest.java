package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CommitteeTest {
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThatThrownBy(() -> new Committee(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_1부터_45사이가_아니면_예외가_발생한다() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 46;

        assertThatThrownBy(() -> new Committee(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호와_보너스_번호가_중복되지_않으면_정상적으로_생성된다() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        new Committee(winningNumbers, bonusNumber);
    }

    @Test
    void 사용자_로또_결과_체크기능_확인() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Committee committee = new Committee(winningNumbers, bonusNumber);
        User user = new User(1000);
        user.getLottos().clear();
        user.getLottos().add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        user.getLottos().add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        user.getLottos().add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        user.getLottos().add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        user.getLottos().add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        user.getLottos().add(new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)));
        user.getLottos().add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));
        user.getLottos().add(new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13)));
        user.getLottos().add(new Lotto(Arrays.asList(9, 10, 11, 12, 13, 14)));
        user.getLottos().add(new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)));
        committee.checkLottos(user);
        assertThat(user.getPrizes().get(Prize.FIRST)).isEqualTo(1);
        assertThat(user.getPrizes().get(Prize.SECOND)).isEqualTo(1);
        assertThat(user.getPrizes().get(Prize.THIRD)).isEqualTo(0);
        assertThat(user.getPrizes().get(Prize.FOURTH)).isEqualTo(1);
        assertThat(user.getPrizes().get(Prize.FIFTH)).isEqualTo(1);
        assertThat(user.getPrizes().get(Prize.FAIL)).isEqualTo(6);
    }
}
