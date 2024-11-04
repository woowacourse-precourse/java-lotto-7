package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.error.ErrorMessage;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.Winstatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OVERLAPLOTTONUMBER.getMessage());
    }

    @DisplayName("로또 번호가 6개가 아닌경우")
    @Test
    void lottoNumbersNotSixCount() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTONUMBERCOUNTNOTSIX.getMessage());
    }

    @Test
    @DisplayName("로또 번호 발행기능 테스트")
    public void createLotto() {

        Lottos lottos = new Lottos(List.of("1", "2", "3", "4", "5", "6"), 2000, 1);

        lottos.generateLotto();

        assertThat(lottos.getLottos().size()).isEqualTo(2);
    }
}
