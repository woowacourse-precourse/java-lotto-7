package lotto.model;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoNumber 클래스")
public class LottoNumberTest {

    @DisplayName("로또 번호가 캐싱되는지 확인한다")
    @Test
    void check() {
        assertThat(LottoNumber.valueOf(1)).isEqualTo(LottoNumber.valueOf(1));
    }

    @DisplayName("로또 번호의 숫자 범위가 1~45를 넘어가면 예외가 발생한다")
    @Test
    void occur() {
        assertThatThrownBy(() -> LottoNumber.valueOf(46))
                .isInstanceOf(IndexOutOfBoundsException.class);
        System.out.println(LottoNumber.valueOf(1).toString());
    }

}
