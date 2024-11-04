package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberMakerTest {

    private final WinningNumberMaker winningNumberMaker = new WinningNumberMaker();


    @DisplayName("잘못된 형식의 당첨번호 입력시 예외가 발생한다.")
    @Test
    void 잘못된_형식의_당첨_번호_문자열_변환시_예외_발생() {
        String invalidWinningNumbers = "1,2,three,4,5,6"; // 숫자가 아닌 단어 포함

        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
            winningNumberMaker.transWinningNumberToList(invalidWinningNumbers);
        });

        assertEquals("[ERROR] 올바른 숫자를 입력해 주세요.", exception.getMessage());
    }

    @DisplayName("잘못된 형식의 보너스번호 입력시 예외가 발생한다.")
    @Test
    void 잘못된_형식의_보너스번호_입력시_예외_발생(){
        String invalidBonusNumber = "four";

        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
            winningNumberMaker.transBonusInputToInt(invalidBonusNumber);
        });
        assertEquals("[ERROR] 올바른 숫자형식의 보너스 번호를 입력해주세요.", exception.getMessage());
    }
}
