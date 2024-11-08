package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinNumberTest {
    @Test
    void 일치하는숫자가몇개인지반환하는기능() {
        // given
        WinNumber winNumber = new WinNumber("1,2,3,4,5,6", "7");

        // when
        System.out.println("=====Logic Start=====");

        int matchNumberCount = winNumber.countMatchingNumbers(List.of(1, 2, 3, 4, 5, 6));

        System.out.println("=====Logic End=====");
        // then
        assertThat(matchNumberCount).isEqualTo(6);
    }

    @Test
    void 로또번호에숫자가아닌값이들어간경우예외테스트() {
        // given
        // when
        // then
        assertThrows(IllegalArgumentException.class,()->new WinNumber("1,2,3,4,5,6j", "7"));
    }

    @Test
    void 보너스번호에숫자가아닌값이들어간경우예외테스트() {
        // given
        // when
        // then
        assertThrows(IllegalArgumentException.class,()->new WinNumber("1,2,3,4,5,6", "7j"));
    }
}