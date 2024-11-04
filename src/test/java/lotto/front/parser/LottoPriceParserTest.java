package lotto.front.parser;

import static org.assertj.core.api.Assertions.*;

import lotto.global.exception.InvalidLottoPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPriceParserTest {

    @Test
    @DisplayName("가격 입력을 파싱하여 Integer 타입으로 반환")
    void 가격_파싱_테스트() {
        //given
        String input = "1000";
        //when
        Integer price = LottoBonusNumberParser.parse(input);
        //then
        assertThat(price).isEqualTo(1000);
    }

    @Test
    @DisplayName("숫자가 아닌 가격 입력을 파싱했을 때 예외 발생")
    void 가격_파싱_예외_테스트() {
        //given
        String input = "1000asd";
        //when
        //then
        assertThatThrownBy(() -> LottoPriceParser.parse(input)).isInstanceOf(InvalidLottoPriceException.class);
    }
}