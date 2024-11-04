package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    private final WinningNumber winningNumber = new WinningNumber();


    @DisplayName("당첨번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개가_아니면_예외_발생(){
        List<Integer> invalidNumbers = Arrays.asList(1,2,3,4,5);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->{
            winningNumber.setWinningNumbers(invalidNumbers);
        });
        assertEquals("[ERROR] 당첨 번호는 6개여야 합니다.", exception.getMessage());

    }
    @DisplayName("당첨번호가 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호가_중복된_숫자가_있으면_예외_발생(){
        List<Integer> invalidNumbers = Arrays.asList(1,2,3,4,4,5);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->{
            winningNumber.setWinningNumbers(invalidNumbers);
        });
        assertEquals("[ERROR] 당첨번호는 중복되지 않아야 합니다.", exception.getMessage());

    }
    @DisplayName("당첨번호가 1과 45 범위가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호가_1과_45_범위가_아니면_예외_발생(){
        List<Integer> invalidNumbers = Arrays.asList(1,2,3,4,5,65);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->{
            winningNumber.setWinningNumbers(invalidNumbers);
        });
        assertEquals("[ERROR] 당첨 번호는 1부터 45사이의 숫자여야 합니다.", exception.getMessage());

    }



}
