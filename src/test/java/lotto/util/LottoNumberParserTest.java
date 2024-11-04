package lotto.util;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberParserTest {

    @Test
    @DisplayName("올바른 숫자 문자열이 입력된 경우")
    public void test1(){
        String strNumbers = "1,2,3,4,5,6";
        List<Integer> intNumbers = LottoNumberParser.parseLottoNumbers(strNumbers);

        assertThat(intNumbers).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("입력된 문자열이 숫자가 아닌 경우")
    public void test2(){
        String strNumbers = "1,2,3,4,5,test";
        assertThatThrownBy(() -> LottoNumberParser.parseLottoNumbers(strNumbers))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("구분자 사이가 빈 값인 경우")
    public void test3(){
        String strNumbers = "1,2,3,4,5,,6";
        assertThatThrownBy(() -> LottoNumberParser.parseLottoNumbers(strNumbers))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("첫 글자가 구분자로 시작하는 경우")
    public void test4(){
        String strNumbers = ",1,2,3,4,5,6";
        assertThatThrownBy(() -> LottoNumberParser.parseLottoNumbers(strNumbers))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("마지막 숫자 뒤에 구분자가 입력된 경우")
    public void test5(){
        String strNumbers = "1,2,3,4,5,6,";
        assertThatThrownBy(() -> LottoNumberParser.parseLottoNumbers(strNumbers))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_INPUT.getMessage());
    }
}