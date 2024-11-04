package lotto.lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.WinningLotto;
import lotto.util.ValidationProcess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class BonusNumberTest {
    private static WinningLotto winningLotto;

    @BeforeEach
    void init() {
        winningLotto = WinningLotto.of("1,2,3,4,5,6");

    }

    @Test
    @DisplayName("중복 테스트")
    void duplicateTest() {
        List<String> exceptionData = List.of("1", "2", "3", "4", "5", "6");
        ValidationProcess.createThrownBy(winningLotto, exceptionData, BonusNumber::of, LottoValidator::bonusNumberValidate, ErrorMessage.DUPLICATE);
    }

    @Test
    @DisplayName("1 ~ 45까지 범위의 숫자가 아닌경우 예외가 발생한다")
    void withinRangeLottoNumberTest() {
        List<String> exceptionData = List.of("0", "46", "47", "243", "12213123");
        ValidationProcess.createThrownBy(winningLotto, exceptionData, BonusNumber::of, LottoValidator::bonusNumberValidate, ErrorMessage.WITHIN_RANGE);
    }

    @Test
    @DisplayName("BonusNumber 생성시 1 ~ 45까지 범위의 숫자가 아닌경우 예외가 발생한다")
    void createBonusNumberTest() {
        List<String> exceptionData = List.of("231232131232113", "4213213213216", "4721312321312", "221321321312343", "1221123123213213123123");
        ValidationProcess.createThrownBy(exceptionData, BonusNumber::of, ErrorMessage.WITHIN_RANGE);
    }

}