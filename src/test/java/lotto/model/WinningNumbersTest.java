package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void 보너스_번호_당첨_번호_중복_확인_테스트() {
        //given
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        int bonusNumber = 1;

        //when & then
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new WinningNumbers(winningNumber, bonusNumber));
    }
}