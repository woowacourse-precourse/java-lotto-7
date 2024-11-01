package lotto.domain.lottos.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.lottos.Lotto;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserLottoTest {
    private UserLotto userLotto;


    @BeforeEach
    void setUp() {
        Lotto mainLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusLotto bonusLotto = new BonusLotto(7);

        userLotto = new UserLotto(mainLotto, bonusLotto);
    }

    @Test
    void 보너스_로또가_여섯자리_로또와_중복될_때_예외_처리() {
        UserLotto.Builder builder = new UserLotto.Builder();

        builder.mainLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        AssertionsForClassTypes.assertThatThrownBy(() -> builder.bonusLotto(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 여섯자리_로또_일치_개수_반환() {
        Lotto randomLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        int actual = userLotto.getMainLottoMatchedCount(randomLotto);
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    void 보너스_로또_일치_여부_반환() {
        Lotto randomLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        boolean actual = userLotto.isContainBonusLotto(randomLotto);
        boolean expected = true;

        assertEquals(expected, actual);
    }

}