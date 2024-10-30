package lotto;

import lotto.View.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoInputTest {
    @Test
    void 구입_금액_입력(){
        String input = "4000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int result= InputView.input_purchaseAmount();
        assertEquals(4000,result);
    }

    @DisplayName("구입 금액 입력 시에 1000원 단위의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액_입력시_1000원_단위가_아니면_예외가_발생한다(){
        String input="2500";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class,()->{
            InputView.input_purchaseAmount();
        });
    }

}
