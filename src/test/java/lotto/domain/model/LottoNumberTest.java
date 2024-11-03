package lotto.domain.model;

import static lotto.domain.constant.LottoConstraintProperties.MAXIMUM_NUMBER_VALUE;
import static lotto.domain.constant.LottoConstraintProperties.MINIMUM_NUMBER_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @Test
    void 로또의숫자는1이상45이하숫자만으로생성할수있다() {
        //given
        int expectedSize = MAXIMUM_NUMBER_VALUE - MINIMUM_NUMBER_VALUE + 1;
        //when
        var lottoNumbers = IntStream.rangeClosed(MINIMUM_NUMBER_VALUE, MAXIMUM_NUMBER_VALUE)
                .boxed()
                .map(number -> new LottoNumber(number))
                .toList();
        //then
        assertThat(lottoNumbers.size()).isEqualTo(expectedSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void _0이하_또는_46이상의_숫자는_로또숫자_객체를_생성할수_없다(int invalidNumber) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new LottoNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}