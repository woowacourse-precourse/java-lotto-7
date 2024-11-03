package lotto.purchase;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyLottoTest {

    @DisplayName("당첨 로또를 알려주면 일치하는 숫자 개수를 반환한다.")
    @Test
    void shouldReturnCountMatchingNumbersWhenGiveWinningLotto() {
        // give
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        MyLotto myLotto = new MyLotto(List.of(1, 2, 3, 7, 8, 9));
        int expectedMatchingCount = 3;

        // when
        int actualMatchingCount = myLotto.countMatches(winningLotto);

        // then
        Assertions.assertThat(actualMatchingCount).isEqualTo(expectedMatchingCount);
    }
}
