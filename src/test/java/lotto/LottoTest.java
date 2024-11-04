package lotto;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_SIZE_MUST_BE_SIX.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_NUMBER_MUST_NOT_DUPLICATE.getMessage());
    }

    @DisplayName("당첨 번호가 int 값을 초과하면 예외가 발생한다.")
    @Test
    void 당첨번호_LONG(){
        assertThatThrownBy(()-> Lotto.createWinningRegularLotto("2200000000,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.CANT_CONVERT_TO_INTEGER.getMessage());
    }

    @DisplayName("당첨 번호가 지정된 값을 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"0","46"})
    void 당첨번호_범위초과시_예외(int value){
        assertThatThrownBy(()-> Lotto.createWinningRegularLotto(value+",2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_NUMBER_MUST_BE_IN_CORRECT_RANGE.getMessage());
    }

    @DisplayName("당첨 번호를 , 기준으로 파싱 불가한 경우 예외가 발생한다.")
    @Test
    void 당첨번호_파싱불가(){
        assertThatThrownBy(()-> Lotto.createWinningRegularLotto("30:1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.CANT_CONVERT_TO_INTEGER.getMessage());
    }

}
