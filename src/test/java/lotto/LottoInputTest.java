package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.View.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoInputTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }
    @DisplayName("정상적인 구입 금액 입력")
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
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputView.input_purchaseAmount();
        });
        assertEquals("[ERROR] 구입 금액은 양수인 1000원 단위로 입력해주세요.", exception.getMessage());
    }

    @Test
    void 당첨_번호_입력(){
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Integer> result= InputView.input_winningNumber();
        assertArrayEquals(new Integer[]{1,2,3,4,5,6},result.toArray());

    }

    @DisplayName("당첨번호가 1~45의 숫자가 아니면 에러가 발생한다.")
    @Test
    void 당첨번호_범위_아니면_에러가_발생한다(){
        String input = "1,2,3,4,5,46";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputView.input_winningNumber();
        });
        assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

}
