package lotto.front.parser;

import static org.assertj.core.api.Assertions.*;

import lotto.global.exception.InvalidBonusNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBonusNumberParserTest {

    @Test
    @DisplayName("입력받은 보너스 번호를 파싱하여 Integer 반환")
    void 보너스번호_파싱_테스트() {
        //given
        String input = "32";
        //when
        Integer bonusNumber = LottoBonusNumberParser.parse(input);
        //then
        assertThat(bonusNumber).isEqualTo(32);
    }

    @Test
    @DisplayName("입력받은 보너스 번호가 숫자가 아닐 때 예외 발생")
    void 보너스번호_예외_테스트() {
        //given
        String input = "32asd";
        //when
        //then
        assertThatThrownBy(() -> LottoBonusNumberParser.parse(input)).isInstanceOf(InvalidBonusNumberException.class);
    }
}