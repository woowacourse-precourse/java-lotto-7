package lotto.policy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoPolicyTest {
    LottoPolicy lottoPolicy = new LottoPolicy();

    @Test
    public void 로또의_숫자는_1에서_45_사이의_숫자가_아니라면_예외를_발생시켜야_한다() {
        // given
        List<Integer> lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 100));

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoPolicy.checkLottoPolicy(lotto);
        });

        // then
        org.assertj.core.api.Assertions.assertThat(exception.getMessage()).contains("[ERROR]");
    }

    @Test
    public void 로또의_숫자는_중복_되어선_안된다() {
        // given
        List<Integer> lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 1));

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoPolicy.checkLottoPolicy(lotto);
        });

        // then
        org.assertj.core.api.Assertions.assertThat(exception.getMessage()).contains("[ERROR]");
    }

    @Test
    public void 로또의_숫자_개수는_6개여야_한다() {
        // given
        List<Integer> lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoPolicy.checkLottoPolicy(lotto);
        });

        // then
        org.assertj.core.api.Assertions.assertThat(exception.getMessage()).contains("[ERROR]");
    }

    @Test
    public void 로또는_오름차순_정렬이_되어있어야_한다() {
        // given
        List<Integer> lotto = new ArrayList<>(List.of(6, 1, 2, 3, 4, 5));

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoPolicy.checkLottoPolicy(lotto);
        });

        // then
        org.assertj.core.api.Assertions.assertThat(exception.getMessage()).contains("[ERROR]");

    }
}