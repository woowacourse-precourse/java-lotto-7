package lotto.model;

import lotto.exception.LottoExceptionStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("올바른 로또 번호 생성")
    void validLottoNumber(){
        //given
        List<Integer> numbers = List.of(1,2,3,4,5,6);

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @Test
    @DisplayName("올바르지 않은 로또번호 생성 - 범위 초과")
    void invalidLottoNumber_OutOfRange(){

        //given
        List<Integer> numbers = List.of(1,2,3,4,5,70);

        //when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionStatus.INVALID_GENERATED_LOTTO_NUMBERS_RANGE.getMessage());

    }

    @Test
    @DisplayName("올바르지 않은 로또번호 생성 - 중복")
    void invalidLottoNumber_Duplicate(){

        //given
        List<Integer> numbers = List.of(1,2,3,4,5,5);

        //when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionStatus.INVALID_GENERATED_LOTTO_NUMBERS_DUPLICATE.getMessage());

    }

    @Test
    @DisplayName("올바르지 않은 로또번호 생성 - 6개 생성 안됨")
    void invalidLottoNumber_Size(){

        //given
        List<Integer> numbers = List.of(1,2,3,4,5);

        //when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionStatus.INVALID_GENERATED_LOTTO_NUMBERS_SIZE.getMessage());

    }

}
