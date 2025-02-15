package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TargetLottoTest {

    @Test
    void 타겟_로또_생성_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 45;

        TargetLotto targetLotto = new TargetLotto(lotto, bonus);
    }

    @Test
    void 타겟_로또의_보너스번호는_로또번호와_중복될_수_없다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 6;

        Assertions.assertThatThrownBy(() -> new TargetLotto(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 타겟_로또의_보너스번호도_로또의_범위를_지켜야한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 46;

        Assertions.assertThatThrownBy(() -> new TargetLotto(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
