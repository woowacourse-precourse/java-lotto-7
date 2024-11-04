package lotto.front.parser;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

import lotto.global.exception.InvalidLottoNumberFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersParserTest {

    @Test
    @DisplayName("쉼표로 구분된 로또 넘버를 받았을 때 List<Integer>로 파싱하여 반환")
    void 로또번호_파싱_테스트() {
        //given
        String input = "1,2,3,4,5,6";
        //when
        List<Integer> lottoNumbers = LottoNumbersParser.parse(input);
        //then
        assertThat(lottoNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("입력 포맷에 맞지 않은 로또 번호들을 받았을 때 예외 발생")
    void 로또번호_파싱_예외_테스트() {
        //given
        String input = "1,2,3,4,5,6,";
        //when
        //then
        assertThatThrownBy(() -> LottoNumbersParser.parse(input)).isInstanceOf(InvalidLottoNumberFormatException.class);
    }
}