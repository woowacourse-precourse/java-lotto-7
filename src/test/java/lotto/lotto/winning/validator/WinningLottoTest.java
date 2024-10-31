package lotto.lotto.winning.validator;

import lotto.constant.ErrorMessage;
import lotto.lotto.winning.domain.WinningLotto;
import lotto.util.ValidationProcess;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningLottoTest {
    @Test
    @DisplayName("6자리 숫자 테스트")
    void numberCountTest() {
        List<String> exceptionData = List.of("1", "1,2", "1,2,3", "1,2,3,4", "1,2,3,4,5", "1,2,3,4,5,6,7");
        ValidationProcess.createThrownBy(exceptionData, WinningLotto::of, ErrorMessage.NUMBER_COUNT);
    }

    @Test
    @DisplayName("중복 테스트")
    void duplicateTest() {
        List<String> exceptionData = List.of("1,1,3,4,5,6", "2,2,3,4,5,6", "3,3,3,3,3,3", "11,1,1,1,1,1");
        ValidationProcess.createThrownBy(exceptionData, WinningLotto::of, ErrorMessage.DUPLICATE);
    }

    @Test
    @DisplayName("1 ~ 45까지 범위의 숫자가 아닌경우 예외가 발생한다")
    void withinRangeLottoNumberTest() {
        List<String> exceptionData = List.of("45,46,47,48,49,50", "0,1,2,3,4,5", "1,324,113,135,53,2", "1,2,3,4,5,46");
        ValidationProcess.createThrownBy(exceptionData, WinningLotto::of, ErrorMessage.WITHIN_RANGE);
    }

    @Test
    @DisplayName("WinningLotto 생성시 1 ~ 45까지 범위의 숫자가 아닌경우 예외가 발생한다")
    void createWinningLottoTest() {
        List<String> exceptionData = List.of("2147483648,2,3,4,5,6", "21474836471,2,3,4,5,6", "2132131232,2,3,4,5,6");
        ValidationProcess.createThrownBy(exceptionData, WinningLotto::of, ErrorMessage.WITHIN_RANGE);
    }
}
