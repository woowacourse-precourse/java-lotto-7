package lotto.domain.numberPicker;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberPickerTest {

    @RepeatedTest(10)
    void 생성된_숫자들의_개수는_요청과_동일하다() {
        //given
        RandomNumberPicker sut = new RandomNumberPicker();

        //when
        List<Integer> result = sut.pickUniqueNumbersInRange(1, 45, 6);

        //then
        assertThat(result.size()).isEqualTo(6);
    }

    @RepeatedTest(10)
    void 생성된_숫자들은_요청의_범위_안에_존재한다() {
        //given
        RandomNumberPicker sut = new RandomNumberPicker();

        //when
        List<Integer> result = sut.pickUniqueNumbersInRange(1, 45, 6);

        //then
        assertThat(result).allMatch(number -> 1 <= number && number <= 45);
    }

    @RepeatedTest(10)
    void 생성된_숫자들은_중복이_없다() {
        //given
        RandomNumberPicker sut = new RandomNumberPicker();

        //when
        List<Integer> result = sut.pickUniqueNumbersInRange(1, 45, 6);

        //then
        assertThat(result).doesNotHaveDuplicates();
    }
}
