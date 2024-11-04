package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {

    @Test
    void 일치_갯수를_토대로_당첨_등수를_분류한다(){
        WinningNumbers winningNumbers = new WinningNumbers(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Number(20));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 20));

        Reward reward = winningNumbers.getReward(lotto);

        Assertions.assertThat(reward).isEqualTo(Reward.SECOND);
    }

    @Test
    void 당첨_번호와_보너스_번호가_중복되는지_확인한다(){
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Number bonus = new Number(6);

        assertThrows(IllegalArgumentException.class,
                ()->{
            new WinningNumbers(winningNumber,bonus);
                });
    }

}