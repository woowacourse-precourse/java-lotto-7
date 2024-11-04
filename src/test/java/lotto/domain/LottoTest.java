package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.generator.LottoGenerator;
import org.junit.jupiter.api.Test;

class LottoTest {
    private final LottoGenerator lottoGenerator = () -> List.of(1, 2, 3, 4, 5, 6);

    @Test
    void 정해진_숫자의_로또_생성_성공() {
        Lotto lotto = Lotto.createFixedNumberLotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(Lotto.createFixedNumberLotto(List.of(1, 2, 3, 4, 5, 6)).getNumbers())
                .isEqualTo(lotto.getNumbers());
    }

    @Test
    void 랜덤_로또_생성_성공() {
        Lotto lotto = Lotto.createFixedNumberLotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(Lotto.createRandomNumberLotto(lottoGenerator).getNumbers())
                .isEqualTo(lotto.getNumbers());
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.createFixedNumberLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.createFixedNumberLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개가_안되면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.createFixedNumberLotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_범위가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.createFixedNumberLotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.createFixedNumberLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_중복되면_예외가_발생한다() {
        Lotto lotto = Lotto.createFixedNumberLotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.validateBonusNumber("6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_숫자가_아니면_예외가_발생한다() {
        Lotto lotto = Lotto.createFixedNumberLotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.validateBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
