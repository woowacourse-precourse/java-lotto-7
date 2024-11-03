package lotto.back.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.global.exception.InvalidLottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("[1, 45] 사이의 수가 들어왔을 때 객체 생성")
    void 객체_생성_테스트() {
        //given
        Integer number = 5;
        //when
        LottoNumber lottoNumber = new LottoNumber(number);
        //then
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(number);
    }

    @Test
    @DisplayName("1미만의 수가 들어왔을 때 객체 생성")
    void 로또_번호_예외_테스트1() {
        //given
        Integer number = 0;
        //when
        //then
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(InvalidLottoNumberRangeException.class);
    }

    @Test
    @DisplayName("46 이상의 수가 들어왔을 때 객체 생성")
    void 로또_번호_예외_테스트2() {
        //given
        Integer number = 46;
        //when
        //then
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(InvalidLottoNumberRangeException.class);
    }
}