package lotto.exception;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import lotto.Application;
import lotto.Console.InputConsole;
import lotto.Lotto;
import lotto.enums.ErrorType;
import org.junit.jupiter.api.Test;

class CheckInputTest {

    @Test
    void 로또_당첨번호_포맷이_잘못되었을때_예외가_발생한다(){
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkLottoNumbers("strange format")
        );
        assertEquals(ErrorType.INVALID_LOTTO_NUMBER_FORMAT.getErrorMessage(), exception.getMessage());
    }

    @Test
    void 로또_당첨번호_범위가_잘못되었을때_예외가_발생한다(){
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkLottoNumbers("1,2,3,4,5,48")
        );
        assertEquals(ErrorType.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage(), exception.getMessage());
    }

    @Test
    void 로또_당첨번호_갯수가_6개가_아닐때_예외가_발생한다(){
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkLottoNumbers("1, 2, 3, 4, 5, 6, 7")
        );
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    void 로또_보너스번호의_범위가_잘못되었을때_예외가_발생한다(){

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto inputLotto = new Lotto(list);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkBonusNumber(48, inputLotto)
        );
        assertEquals(ErrorType.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage(), exception.getMessage());
    }

    @Test
    void 로또_보너스번호가_당첨_번호와_중복될_경우_예외가_발생한다(){

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto inputLotto = new Lotto(list);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkBonusNumber(6, inputLotto)
        );
        assertEquals(ErrorType.INVALID_LOTTO_BONUS_NUMBER_DUPLICATE.getErrorMessage(), exception.getMessage());
    }
}