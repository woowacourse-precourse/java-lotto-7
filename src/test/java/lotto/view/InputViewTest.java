package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.dto.LottoPurchasedAmountInput;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    void 입력된_문자열이_null_이면_예외가_발생한다() {
        LottoException exception = assertThrows(LottoException.class, () -> {
            LottoPurchasedAmountInput.from(null);
        });
        assertEquals(ErrorMessage.NULL_INPUT_ERROR.getMessage(), exception.getMessage());
    }

    @Test
    void 입력된_문자열이_빈_문자열이면_예외가_발생한다() {
        LottoException exception = assertThrows(LottoException.class, () -> {
            LottoPurchasedAmountInput.from("");
        });
        assertEquals(ErrorMessage.EMPTY_INPUT_ERROR.getMessage(), exception.getMessage());
    }
}
