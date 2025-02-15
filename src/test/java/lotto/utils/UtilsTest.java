package lotto.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    @DisplayName("로또 당첨 번호 입력 형식이 틀리면 오류를 던진다.")
    void givenInvalidInputFormat_whenValidateInputWinningNumbers_thenIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.validateInputWinningNumbers(",1,2,3,4"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.validateInputWinningNumbers("1,2,3,4,"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.validateInputWinningNumbers(",,,"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.validateInputWinningNumbers("a,b,c,d,e"));
    }

    @Test
    @DisplayName("숫자가 아닌 값으 들어오면 오류를 던진다.")
    void givenInvalidNumber_whenParseNumber_thenIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.parseNumber("100고등어"));
    }

}