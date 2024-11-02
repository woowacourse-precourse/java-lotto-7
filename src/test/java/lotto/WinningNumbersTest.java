package lotto;

import lotto.store.Lotto;
import lotto.store.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest {
    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void test1() {
        Lotto winningLotto = toLotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonus = new LottoNumber(3);

        assertThatThrownBy(() -> new WinningNumbers(winningLotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Lotto toLotto(int... numbers) {
        return new Lotto(toLottoNumbers(numbers));
    }


    private static List<LottoNumber> toLottoNumbers(int... numbers) {
        return Arrays.stream(numbers).boxed().map(LottoNumber::new).toList();
    }

}