package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoNumbersTest {

    @Test
    @DisplayName("생성자는 지정 사이즈가 아닌 경우 지정한 메세지와 함께 IllegalArgumentException을 발생한다.")
    public void constructor_WithInvalidSize_ThrowIllegalArgumentExceptionWithExpectedMessage() {
        // given
        List<Integer> numbers1 = List.of(1,2,3,4,5);
        List<Integer> numbers2 = List.of(1,2,3,4,5,6,7);
        List<LottoNumber> lottoNumbers1 = numbers1.stream()
                .map(LottoNumber::new)
                .toList();
        List<LottoNumber> lottoNumbers2 = numbers2.stream()
                .map(LottoNumber::new)
                .toList();

        // when & then
        assertThatThrownBy(() -> new WinningLottoNumbers(lottoNumbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningLottoNumbers.NUMBERS_SIZE_ERROR_MESSAGE);

        assertThatThrownBy(() -> new WinningLottoNumbers(lottoNumbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningLottoNumbers.NUMBERS_SIZE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("생성자는 중복되는 숫자가 존재할 경우에 대해 지정한 메세지와 함께 IllegalArgumentException을 발생한다.")
    public void constructor_WithDuplicatedNumberExist_ThrowIllegalArgumentExceptionWithExpectedMessage() {
        // given
        final int belowMinValue = LottoNumber.MIN_VALUE - 1;
        final int aboveMaxValue = LottoNumber.MAX_VALUE + 1;

        // when & then
        assertThatThrownBy(() -> new LottoNumber(belowMinValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoNumber.OUT_OF_RANGE_ERROR_MESSAGE);

        assertThatThrownBy(() -> new LottoNumber(aboveMaxValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoNumber.OUT_OF_RANGE_ERROR_MESSAGE);
    }
}
