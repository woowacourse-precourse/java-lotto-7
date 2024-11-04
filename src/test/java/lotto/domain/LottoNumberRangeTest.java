package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberRangeTest {

    @ParameterizedTest
    @ValueSource(ints = { 0, 46 })
    void 로또_번호가_범위_내에_없으면_True를_반환(int number) {
        //when
        boolean isExclude = LottoNumberRange.excludeRange(number);

        //then
        assertThat(isExclude).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 45 })
    void 로또_번호가_범위_내에_있으면_False를_반환(int number) {
        //when
        boolean isExclude = LottoNumberRange.excludeRange(number);

        //then
        assertThat(isExclude).isFalse();
    }
}