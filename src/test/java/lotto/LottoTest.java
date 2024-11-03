package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.providable.NumbersProvidable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6자리의 숫자로 구성된 로또 티켓을 정상적으로 생성한다")
    void createLottoWhenNormalInputs() {
        // given
        List<Integer> inputs = List.of(1, 2, 3, 4, 5, 6);

        // when, then
        assertDoesNotThrow(() -> new Lotto(inputs));
    }

    @Test
    @DisplayName("숫자 컬렉션의 생성 전략을 설정해서 로또 티켓을 생성할 수도 있다")
    void createLottoWithNumberProvidable() {
        assertDoesNotThrow(() -> Lotto.create(
                new NumbersProvidable() {
                    @Override
                    public List<Integer> provide() {
                        return List.of(1, 2, 3, 4, 5, 6);
                    }
                }
        ));
    }
}
