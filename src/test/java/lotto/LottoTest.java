package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest extends NsTest {

    @Test
    void 로또_결과_단위_테스트() {
        String expectedString = "[1, 2, 3, 4, 5, 6]" + System.lineSeparator();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getLottoNumbersStr())
                .isEqualTo(expectedString);
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 숫자 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 번호가 범위를 초과하면 예외가 발생한다")
    @Test
    void 로또_번호가_범위를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 1000개 초과 구매시 예외가 발생한다.")
    @Test
    void 로또_1000개_초과_구매시_예외가_발생한다(){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        }

        assertThatThrownBy(() -> new Lottos(lottos))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 구매하지 않을시 예외가 발생한다")
    @Test
    void 로또_구매하지_않을시_예외가_발생한다(){
        List<Lotto> lottos = new ArrayList<>();
        assertThatThrownBy(() -> new Lottos(lottos))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
