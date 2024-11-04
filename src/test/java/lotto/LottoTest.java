package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

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
    void 범위에_해당하지_않는_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨_번호와_똑같으면_예외가_발생한다() {
        BonusNumberInput bonusNumberInput = new BonusNumberInput();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber = 3;

        assertThatThrownBy(() -> bonusNumberInput.checkNumber(duplicateBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_범위_밖이면_예외가_발생한다() {
        BonusNumberInput bonusNumberInput = new BonusNumberInput();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int outOfRangeBonusNumber = 46;

        assertThatThrownBy(() -> bonusNumberInput.checkNumber(outOfRangeBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률_계산_정확도_확인() {
        WinningDetailsDisplay winningDetailsDisplay = new WinningDetailsDisplay();
        int price = 8000;
        Map<WinningType, Integer> result = new EnumMap<>(WinningType.class);

        result.put(WinningType.THREE, 1);
        result.put(WinningType.FOUR, 0);
        result.put(WinningType.FIVE, 0);
        result.put(WinningType.FIVE_BONUS, 0);
        result.put(WinningType.SIX, 0);

        double calculatedRate = winningDetailsDisplay.calculateRate(price, result);
        double expectedRate = 62.5;

        assertThat(calculatedRate).isCloseTo(expectedRate, within(0.1));
    }

    @Test
    void 보너스_번호_미포함_일치개수_계산() {
        LottoCompare lottoCompare = new LottoCompare();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 8, 9);
        List<List<Integer>> lottoNumbers = List.of(List.of(1, 2, 3, 4, 5, 10));
        int bonusNumber = 10;

        List<Integer> result = lottoCompare.compareLottoNumbers(winningNumbers, lottoNumbers, bonusNumber);

        assertThat(result).containsExactly(4);
    }

    @Test
    void 보너스_번호_포함_일치개수_계산() {
        LottoCompare lottoCompare = new LottoCompare();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<List<Integer>> lottoNumbers = List.of(List.of(1, 2, 3, 4, 5, 7));
        int bonusNumber = 7;

        List<Integer> result = lottoCompare.compareLottoNumbers(winningNumbers, lottoNumbers, bonusNumber);

        assertThat(result).containsExactly(7);
    }
}