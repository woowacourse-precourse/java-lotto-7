package lotto.domain.user;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.user.UserLotto;
import org.junit.jupiter.api.Test;

class UserLottoTest {

    @Test
    void 보너스_메인_로또_번호_중복_예외_처리() {
        UserLotto.Builder builder = new UserLotto.Builder();
        builder.mainLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        assertThatThrownBy(() -> builder.bonusLotto(6))
                .isInstanceOf(IllegalArgumentException.class);

    }

}