package lotto.util.validator;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoValidatorTest {

    @Test
    @DisplayName("정상 적인 입력이 들어오는 경우")
    void checkInNormalCase(){
        // given
        List<Integer> list = List.of(1,2,3,4,5,6);

        // when
        Lotto lotto = new Lotto(list);

        // then
        assertThat(lotto).isInstanceOf(Lotto.class);

    }

    @Test
    @DisplayName("Lotto 생성시에 번호가 6개가 아닌 경우")
    void checkItHasNotSixNumbers() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        // then
        assertThrows(IllegalArgumentException.class,

                // when
                () -> new Lotto(list));
    }

    @Test
    @DisplayName("Lotto 생성시에 번호가 1-45 사이가 아닌 경우")
    void checkItIsNotInThreshold() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 66);

        // then
        assertThrows(IllegalArgumentException.class,

                // when
                () -> new Lotto(list));
    }

    @Test
    @DisplayName("Lotto 생성시에 번호가 중복되는 경우")
    void checkItIsDuplicate(){
        // given
        List<Integer> list = List.of(1,2,3,4,5,5);

        // then
        assertThrows(IllegalArgumentException.class,

                // when
                ()-> new Lotto(list));
    }
}