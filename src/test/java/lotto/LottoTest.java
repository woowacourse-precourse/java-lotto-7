package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("1등일 경우")
    @Test
    void First() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonus = 7;
        assertThat(lotto.read(List.of(1,2,3,4,5,6),bonus)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("2등일 경우")
    @Test
    void second() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        int bonus = 7;
        assertThat(lotto.read(List.of(1,2,3,4,5,6),bonus)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("3등일 경우")
    @Test
    void third() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,8));
        Lotto lotto2 = new Lotto(List.of(1,2,3,4,7,8));
        int bonus = 7;
        assertThat(lotto1.read(List.of(1,2,3,4,5,6),bonus)).isEqualTo(Rank.THIRD);
        assertThat(lotto2.read(List.of(1,2,3,4,5,6),bonus)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4등일 경우")
    @Test
    void forth() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,8,9));
        Lotto lotto2 = new Lotto(List.of(1,2,3,7,8,9));
        int bonus = 7;
        assertThat(lotto1.read(List.of(1,2,3,4,5,6),bonus)).isEqualTo(Rank.FORTH);
        assertThat(lotto2.read(List.of(1,2,3,4,5,6),bonus)).isEqualTo(Rank.FORTH);
    }

    @DisplayName("5등일 경우")
    @Test
    void fifth() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,8,9,10));
        Lotto lotto2 = new Lotto(List.of(1,2,7,8,9,10));
        int bonus = 7;
        assertThat(lotto1.read(List.of(1,2,3,4,5,6),bonus)).isEqualTo(Rank.FIFTH);
        assertThat(lotto2.read(List.of(1,2,3,4,5,6),bonus)).isEqualTo(Rank.FIFTH);
    }
}
