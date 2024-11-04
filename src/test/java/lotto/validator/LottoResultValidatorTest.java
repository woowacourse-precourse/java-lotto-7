package lotto.validator;

import lotto.entity.BonusNumber;
import lotto.entity.WinningNumber;
import lotto.enums.ExceptionMessage;
import lotto.validator.model.LottoResultValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoResultValidatorTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 당청_번호와_보너스_번호가_중복되면_예외가_발생한다(WinningNumber winningNumber, BonusNumber bonusNumber) {
        assertThatThrownBy(() -> new LottoResultValidator(winningNumber, bonusNumber).validate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_BONUS_NUMBER_DUPLICATED.getMessage());
    }

    static Stream<Arguments> 당청_번호와_보너스_번호가_중복되면_예외가_발생한다() {
        return Stream.of(Arguments.arguments(new WinningNumber("1,2,3,4,5,6"), new BonusNumber("1")));
    }
}
