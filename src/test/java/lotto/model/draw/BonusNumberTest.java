package lotto.model.draw;

import static org.assertj.core.api.Assertions.*;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.model.strategy.CustomStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @Test
    void 보너스_번호가_빈_값인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_숫자가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.from("one")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void 보너스_번호가_1부터_45의_값이_아닌_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> BonusNumber.from(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    void 보너스_번호가_1부터_45_범위_안의_값인_경우_보너스번호가_생성된다(String input) {
        BonusNumber bonusNumber = BonusNumber.from(input);
        assertThat(bonusNumber.getNumber()).isEqualTo(Integer.parseInt(input));
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되는_경우_예외가_발생한다() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto winningLotto = lottoGenerator.generateSingleLotto(CustomStrategy.of("1,2,3,4,5,6"));
        BonusNumber bonusNumber = BonusNumber.from("1");

        assertThatThrownBy(() -> bonusNumber.checkDuplicationNumber(winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

}