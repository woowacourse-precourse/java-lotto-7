package lotto;

import static lotto.service.exception.LottoExceptionMessage.INVALID_BONUS_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.dto.WinningNumbersDto;
import lotto.service.exception.LottoException;
import lotto.view.validation.BonusNumberValidator;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    private final WinningNumbersDto winningNumbersDto = new WinningNumbersDto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void 보너스_번호에_1_미만의_숫자가_포함된다면_예외발생() {
        String bonusNumber = "0";
        LottoException e = assertThrows(LottoException.class, () -> {
            BonusNumberValidator.validate(winningNumbersDto, bonusNumber);
        });
        assertEquals(INVALID_BONUS_NUMBER.message(), e.getMessage());
    }
}
