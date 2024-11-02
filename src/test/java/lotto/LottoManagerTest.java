package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

class LottoManagerTest {

    //총 당첨금액 계산
    @BeforeEach
    void 로또_매니저_세팅(){
        LottoManager lottoManager=new LottoManager();
        Lotto winningLotto=new Lotto(List.of(1,2,3,4,5,6));
        lottoManager.setWinningLotto(winningLotto);
        lottoManager.setBonus(7);
    }

    @Test
    void 로또를_발행한다(){
        List<Lotto> lottos=new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));

        lottoManager.makeLotto(List.of(1,2,3,4,5,6));
        lottoManager.makeLotto(List.of(1,2,3,4,5,6));

        final List<Lotto> expected=lottos;
        final List<Lotto> actual=lottoManager.checkLottos();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 총_당첨금액을_계산한다(){
        List<Lotto> lottos=new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,7,8,9)));
        lottos.add(new Lotto(List.of(10,21,31,41,13,23)));

        final int expected=5000;
        final int actual=lottoManager.calculatePrices();

        assertThat(1).isEqualTo(5000);
    }
}
