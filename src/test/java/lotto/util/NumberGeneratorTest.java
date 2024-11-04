package lotto.util;

import lotto.constant.NumberConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.NumberConstant.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    @DisplayName("로또 번호의 숫자 범위는 1~45이다.")
    @Test
    void 로또번호_범위_테스트() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> pickNumbers = numberGenerator.pickNumInRange();

        pickNumbers
                .forEach(n -> assertThatComparable(n).isBetween(1, 45));
    }

    @DisplayName("중복되지 않는 숫자를 뽑는다.")
    @Test
    void 로또번호_갯수_테스트() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> pickNumbers = numberGenerator.pickNumInRange();

        long size = pickNumbers.stream()
                .distinct()
                .count();

        assertThat(size).isEqualTo(LOTTO_NUMBER_PICK_COUNT);
    }
}