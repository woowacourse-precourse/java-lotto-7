package lotto;

import lotto.model.Amount;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AmountTest {
    @Test
    public void 금액_입력이_정상적으로_처리되는지_확인한다() {
        Amount amount = new Amount("3000");
        assertEquals(3000, amount.getAmount());
        assertEquals(3, amount.getPublishCount());
    }

    @Test
    public void 금액이_천원으로_나누어지지_않으면_예외_처리한다(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Amount("3500");
        });
        assertEquals("[ERROR] 로또의 금액이 1000원 단위가 아닙니다.", exception.getMessage());
    }

    @Test
    public void 금액이_빈_문자열이면_예외_처리한다() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Amount("");
        });
    }

    @Test
    public void 금액에_숫자가_아닌_다른_문자가_있으면_예외_처리한다() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Amount("abc");
        });
    }

    @Test
    public void 금액이_영으로만_이루어져_있으면_예외_처리한다() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Amount("000");
        });
    }
}
