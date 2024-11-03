package lotto.model.draw;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.purchase.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"7,8,9,10,11,12:0", "1,7,8,9,10,11:1", "1,2,3,4,5,6:6"}, delimiter = ':')
    void 당첨번호와_중복되는_숫자개수를_구할수있다(String drawNumberInput, Integer matchCount) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        Integer numberMatchCount = lotto.getNumberMatchCount(new DrawNumbers(drawNumberInput));
        // then
        assertThat(numberMatchCount).isEqualTo(matchCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    void 보너스번호_포함여부를_판단할수있다(String bonusNumber, boolean result) {
        // given
        DrawNumbers drawNumbers = new DrawNumbers("10,11,12,13,14,15");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        boolean hasBonusNumber = lotto.hasBonusNumber(new BonusNumber(bonusNumber, drawNumbers));
        // then
        assertThat(hasBonusNumber).isEqualTo(result);
    }
}
