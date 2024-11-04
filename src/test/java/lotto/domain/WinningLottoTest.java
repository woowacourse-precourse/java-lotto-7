package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("보너스번호가 1보다 작으면 예외를 일으킨다.")
    @Test
    void 보너스번호가_1보다_작으면_예외를_일으킨다() {
        Lotto lotto = Lotto.quickPick();
        assertThrows(IllegalArgumentException.class, () -> WinningLotto.of(lotto, 0),
                "보너스 번호는 1-45 범위 내 숫자여야 합니다.");

    }

    @DisplayName("보너스번호가 45보다 크면 예외를 일으킨다.")
    @Test
    void 보너스번호가_45보다_크면_예외를_일으킨다() {
        Lotto lotto = Lotto.quickPick();
        assertThrows(IllegalArgumentException.class, () -> WinningLotto.of(lotto, 46),
                "보너스 번호는 1-45 범위 내 숫자여야 합니다.");
    }

    @DisplayName("보너스번호가 로또 번호와 중복되면 예외를 일으킨다.")
    @Test
    void 보너스번호가_로또_번호와_중복되면_예외를_일으킨다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThrows(IllegalArgumentException.class, () -> WinningLotto.of(lotto, 1),
                "보너스 번호와 당첨번호가 중복될 수 없습니다.");
    }

    @DisplayName("일정한 출력형식을 갖는다.")
    @Test
    void 일정한_출력형식을_갖는다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(lotto, 7);
        assertEquals(winningLotto.toString(), "Number = [1, 2, 3, 4, 5, 6], Bonus = 7");
    }
}