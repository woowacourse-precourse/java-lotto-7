package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBonusNumberTest {

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    public void testBonusNumberDuplicate() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        Integer duplicateBonusNumber = 5;

        assertThatThrownBy(() -> winningLotto.validateBonusNumber(duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 번호가 1~45 사이가 아닌 경우 예외를 발생한다.")
    @Test
    void 보너스_로또_번호가_범위에_벗어나면_예외가_발생한다(){
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        Integer duplicateBonusNumber = 48;

        assertThatThrownBy(() -> winningLotto.validateBonusNumber(duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
