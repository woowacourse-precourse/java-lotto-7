package lotto.validation;

import java.util.List;
import lotto.exception.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {

    @DisplayName("숫자 이외의 문자를 입력하면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a", ";", "/1","13L","32mill"})
    void 숫자_이외의_문자_예외(String input){
        Assertions.assertThatThrownBy(() -> BonusNumberValidator.validateOnlyNumeric(input))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ErrorMessage.ERROR_BONUS_NUMBER_NOT_NUMERIC.toString());
    }

    @DisplayName("숫자만 입력되어 들어오면 통과")
    @ParameterizedTest
    @ValueSource(strings = {"1", "23", "31"})
    void 숫자_입력_통과(String input){
        BonusNumberValidator.validateOnlyNumeric(input);
    }

    @DisplayName("입력된 보너스 번호가 1~45를 벗어나면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100, 67})
    void 숫자_범위_벗어남_예외(int bonusNumber){
        Assertions.assertThatThrownBy(() -> BonusNumberValidator.validateNumberRange(bonusNumber))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ErrorMessage.ERROR_OUT_OF_RANGE.toString());
    }

    @DisplayName("입력된 보너스 번호가 1~45 이내면 통과")
    @ParameterizedTest
    @ValueSource(ints = {1, 26, 30})
    void 숫자_범위_이내_통과(int bonusNumber){
        BonusNumberValidator.validateNumberRange(bonusNumber);
    }

    @DisplayName("입력된 보너스 번호가 당첨번호와 중복된다면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {1,31,41,29,16,5})
    void 당첨_번호와_숫자_중복_예외(int bonusNumber){
        List<Integer> winningNumbers = List.of(1,31,41,29,16,5);
        Assertions.assertThatThrownBy(() -> BonusNumberValidator.validateDuplicate(winningNumbers,bonusNumber))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ErrorMessage.ERROR_BONUS_NUMBER_DUPLICATE.toString());
    }

    @DisplayName("입력된 보너스 번호가 당첨번호와 중복이 없으면 통과")
    @ParameterizedTest
    @ValueSource(ints = {32, 15, 10})
    void 당첨_번호와_숫자_중복_없음_통과(int bonusNumber){
        List<Integer> winningNumbers = List.of(1,31,41,29,16,5);
        BonusNumberValidator.validateDuplicate(winningNumbers,bonusNumber);
    }


}