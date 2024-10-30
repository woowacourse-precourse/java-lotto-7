package lotto.domain.user;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.user.BonusLotto;
import lotto.domain.lottos.user.UserLotto;
import org.junit.jupiter.api.Test;

class UserLottoTest {

    @Test
    void 보너스_메인_로또_번호_중복_예외_처리(){
        Lotto mainLotto = new Lotto(new ArrayList<>(List.of(
                1,2,3,4,5,6
        )));

        BonusLotto bonusLotto = new BonusLotto(1);

        assertThatThrownBy(() -> new UserLotto(mainLotto, bonusLotto))
                .isInstanceOf(IllegalArgumentException.class);

    }

}