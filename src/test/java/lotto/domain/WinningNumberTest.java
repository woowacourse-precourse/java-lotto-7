package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    WinningNumber winningNumber;

    @Test
    void 당첨번호_비교_테스트(){
        Lotto winLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto compareLotto = new Lotto(List.of(1,3,5,7,9,11));
        winningNumber = new WinningNumber(winLotto, 7);

        assertThat(winningNumber.matchCount(compareLotto)).isEqualTo(Prize.valueOf("FIFTH"));
    }

    @Test
    void 당첨번호_내_보너스번호_존재시_예외발생(){
        Lotto winLotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThatThrownBy(()->new WinningNumber(winLotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
