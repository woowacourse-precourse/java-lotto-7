package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_번호_오름차순_출력() {
        Lotto lotto = new Lotto(List.of(36, 29, 8, 24, 31, 12));
        String expected = "[8, 12, 24, 29, 31, 36]";
        assertThat(lotto.toString()).isEqualTo(expected);
    }

    @Test
    void 로또_등수_계산() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // 0등: 0 ~ 2개 일치
        assertThat(lotto.calculateRank(List.of(7, 8, 9, 10, 11, 12), 13)).isEqualTo(0);
        assertThat(lotto.calculateRank(List.of(1, 8, 9, 10, 11, 12), 13)).isEqualTo(0);
        assertThat(lotto.calculateRank(List.of(1, 2, 9, 10, 11, 12), 13)).isEqualTo(0);
        // 5등: 3개 일치
        assertThat(lotto.calculateRank(List.of(1, 2, 3, 10, 11, 12), 13)).isEqualTo(5);
        // 4등: 4개 일치
        assertThat(lotto.calculateRank(List.of(1, 2, 3, 4, 11, 12), 13)).isEqualTo(4);
        // 3등: 5개 일치
        assertThat(lotto.calculateRank(List.of(1, 2, 3, 4, 5, 12), 13)).isEqualTo(3);
        // 2등: 5개 일치 + 보너스 번호 일치
        assertThat(lotto.calculateRank(List.of(1, 2, 3, 4, 5, 12), 6)).isEqualTo(2);
        // 1등: 6개 일치
        assertThat(lotto.calculateRank(List.of(1, 2, 3, 4, 5, 6), 13)).isEqualTo(1);
    }
}
