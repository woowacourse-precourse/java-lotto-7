package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    @DisplayName("사용자 로또 번호와 당첨 번호의 일치 개수를 확인한다.")
    @Test
    void 맞춘_번호_개수_테스트() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        int matchingCount = winningLotto.countMatchingNumbers(userLotto);

        assertThat(matchingCount).isEqualTo(3);
    }
}