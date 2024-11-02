package lotto.constant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LottoRangeTest {

    @Test
    @DisplayName("로또 숫자의 지정 범위를 확인한다")
    void checkLottoNumberRange() {
        //given
        List<Integer> availableRange = new ArrayList<>(List.of(1, 2, 3, 4, 5, 45));

        //when
        boolean expect = LottoRange.isAvailableRange(availableRange);

        //then
        assertThat(expect).isTrue();
    }

    @Test
    @DisplayName("지정된 최소 숫자범위를 만족하지 않으면 false를 반환한다")
    void lottoNumberRange_case1() {
        //given
        List<Integer> availableRange = new ArrayList<>(List.of(0, 2, 3, 4, 5, 6));

        //when
        boolean expect = LottoRange.isAvailableRange(availableRange);

        //then
        assertThat(expect).isFalse();
    }

    @Test
    @DisplayName("지정된 최대 숫자범위를 만족하지 않으면 false를 반환한다")
    void lottoNumberRange_case2() {
        //given
        List<Integer> availableRange = new ArrayList<>(List.of(1, 2, 3, 4, 5, 46));

        //when
        boolean expect = LottoRange.isAvailableRange(availableRange);

        //then
        assertThat(expect).isFalse();
    }
}