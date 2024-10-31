package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("InputValidator 클래스 테스트")
public class InputValidatorTest {

    @Test
    void 금액이_1000_단위로_나누어_떨어지지_않으면_예외를_발생() {
        // given
        int purchaseAmount = 10500;
        // when & then
        Assertions.assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("구입 금액은 1,000원 단위로만 가능합니다.");
    }

    @Test
    void 쉼표가_연속적으로_입력된_경우_예외를_발생() {
        //given
        String inputWinnigNumber = "1,,2,3,4,5,6";

        //when & then
        Assertions.assertThatThrownBy(
                () -> InputValidator.validateInputWinnigNumber(inputWinnigNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력에 쉼표가 연속적으로 입력되었습니다.");
    }

    @Test
    void 입력_당첨_번호가_정상_범위_밖이면_예외를_발생() {
        //given
        List<Integer> winningNumbers = List.of(0, 1, 2, 3, 4, 5);
        //when & then
        Assertions.assertThatThrownBy(
                () -> InputValidator.validateWinningNumberRange(winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호의 숫자 범위는 1~45까지입니다.");
    }

    @Test
    void 입력_당첨_번호가_중복되면_예외를_발생() {
        //given
        List<Integer> winningNumbers = List.of(1, 1, 2, 3, 4, 5);
        //when & then
        Assertions.assertThatThrownBy(
                () -> InputValidator.validateWinningNumberDuplicate(winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력된 당첨 번호가 중복됩니다.");
    }

    @Test
    void 입력_당첨_번호가_개수가_6개가_아니면_예외를_발생() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4);
        //when & then
        Assertions.assertThatThrownBy(
                () -> InputValidator.validateWinningNumberCount(winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("당첨 번호 개수는 6개이어야 합니다.");
    }

    @Test
    void 보너스_번호가_정상_범위_밖이면_예외를_발생() {
        //given
        int bonusNumber = 0;
        //when & then
        Assertions.assertThatThrownBy(() -> InputValidator.validateBonusNumberRange(bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호의 숫자 범위는 1~45까지입니다.");
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외를_발생() {
         //given
        int bonusNumber = 1;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        //when & then
        Assertions.assertThatThrownBy(() -> InputValidator.validateBonusNumberDuplicate(bonusNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("보너스 번호가 로또 번호와 중복됩니다.");
    }
}
