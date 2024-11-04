package lotto.Validator;
import lotto.Exception.CommonErrorCode;
import lotto.Exception.LottoNumber.LottoNumberInputErrorCode;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    void validateCashByInput_입력이_null인_경우_예외_발생() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateCashByInput(null);
        });
        assertEquals(CommonErrorCode.NOT_NULL.getErrorMessage(), thrown.getMessage());
    }

    @Test
    void validateCashByInput_입력이_정수가_아닌_경우_예외_발생() {
        NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> {
            validator.validateCashByInput("three thousand");
        });
        assertEquals(CommonErrorCode.NOT_NUMBER.getArgsErrorMessage("금액"), thrown.getMessage());
    }

    @Test
    void validateLottNumByUser_입력이_null인_경우_예외_발생() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateLottNumByUser(null);
        });
        assertEquals(CommonErrorCode.NOT_NULL.getErrorMessage(), thrown.getMessage());
    }

    @Test
    void validateLottNumByUser_구분자가_잘못된_경우_예외_발생() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateLottNumByUser("1;2;3;4;5;6");
        });
        assertEquals(LottoNumberInputErrorCode.INCORRECT_DELIMITER.getArgsErrorMessage(","), thrown.getMessage());
    }

    @Test
    void validateLottNumByUser_숫자가_아닌_문자가_포함된_경우_예외_발생() {
        // 쉼표 구분자는 올바르나, 숫자가 아닌 값이 포함된 경우 테스트
        NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> {
            validator.validateLottNumByUser("1,2,three,4,5,6");
        });
        assertEquals(CommonErrorCode.NOT_NUMBER.getArgsErrorMessage("로또 번호"), thrown.getMessage());
    }

    @Test
    void validateLottNumByUser_유효한_입력_테스트() {
        List<Integer> result = validator.validateLottNumByUser("1,2,3,4,5,6");
        assertEquals(List.of(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    void validateBonusNumByUser_입력이_null인_경우_예외_발생() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateBonusNumByUser(null);
        });
        assertEquals(CommonErrorCode.NOT_NULL.getErrorMessage(), thrown.getMessage());
    }

    @Test
    void validateBonusNumByUser_보너스_번호가_정수가_아닌_경우_예외_발생() {
        NumberFormatException thrown = assertThrows(NumberFormatException.class, () -> {
            validator.validateBonusNumByUser("bonus");
        });
        assertEquals(CommonErrorCode.NOT_NUMBER.getArgsErrorMessage("보너스 번호"), thrown.getMessage());
    }

    @Test
    void validateBonusNumByUser_유효한_보너스_번호_입력_테스트() {
        int result = validator.validateBonusNumByUser("7");
        assertEquals(7, result);
    }
}
