package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    void 보너스번호는_당첨번호와_중복되면_안됩니다(){
        Lotto lotto = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThatThrownBy(() -> new WinningLotto(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_일치여부_검사(){
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 9);
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,9));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,4,5,6));

        assertThat(winningLotto.isBonus(lotto1)).isEqualTo(true);
        assertThat(winningLotto.isBonus(lotto2)).isEqualTo(false);
    }

    @Test
    void 겹치는_숫자_개수_테스트(){
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 9);
        Lotto lotto1 = new Lotto(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new ArrayList<Integer>(Arrays.asList(6, 7, 8, 3, 1, 24)));
        Lotto lotto3 = new Lotto(new ArrayList<Integer>(Arrays.asList(7, 8, 9, 10, 11, 12)));

        assertThat(winningLotto.equalSize(lotto1)).isEqualTo(6);
        assertThat(winningLotto.equalSize(lotto2)).isEqualTo(3);
        assertThat(winningLotto.equalSize(lotto3)).isEqualTo(0);
    }

}