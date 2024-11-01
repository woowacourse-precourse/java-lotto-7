package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersWithBonusNumberTest {

    @Test
    @DisplayName("생성자는 로또 번호와 겹치는 숫자가 있는 경우 지정한 메세지와 함께 IllegalArgumentException을 발생한다.")
    public void constructor_WithInvalidSize_ThrowIllegalArgumentExceptionWithExpectedMessage() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(6);
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(lottoNumbers);

        // when & then
        assertThatThrownBy(() -> new WinningNumbersWithBonusNumber(winningLottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningNumbersWithBonusNumber.DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE);
    }
}
