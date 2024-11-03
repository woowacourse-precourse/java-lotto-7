package lotto.store.lotto;

import lotto.store.lotto.Lotto;
import lotto.store.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void test1() {

        assertThatThrownBy(() -> new Lotto(toLottoNumbers(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void test2() {
        assertThatThrownBy(() -> new Lotto(toLottoNumbers(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 범위 밖에 있다면 예외가 발생한다.")
    @Test
    void test3() {
        assertThatThrownBy(() -> new Lotto(toLottoNumbers(1, 2, 3, 999, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 포함 여부를 확인할 수 있다 (포함되는 경우)")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void test4(int number) {
        Lotto lotto = toLotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto.contains(new LottoNumber(number))).isTrue();
    }

    @DisplayName("로또 번호 포함 여부를 확인할 수 있다. (포함되지 않는 경우)")
    @ParameterizedTest
    @ValueSource(ints = {22, 33, 44})
    void test5(int number) {
        Lotto lotto = toLotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto.contains(new LottoNumber(number))).isFalse();
    }


    @DisplayName("두 로또의 맞은 숫자를 파악한다.")
    @Test
    void test6() {
        Lotto lotto1 = toLotto(1, 2, 3, 4, 8, 6);
        Lotto lotto2 = toLotto(1, 2, 3, 4, 5, 45);

        assertThat(lotto1.countMatchingNumber(lotto2)).isEqualTo(4);
        assertThat(lotto2.countMatchingNumber(lotto1)).isEqualTo(4);
    }

    private static Lotto toLotto(int... numbers) {
        return new Lotto(toLottoNumbers(numbers));
    }

    private static List<LottoNumber> toLottoNumbers(int... numbers) {
        return Arrays.stream(numbers).boxed().map(LottoNumber::new).toList();
    }

}
