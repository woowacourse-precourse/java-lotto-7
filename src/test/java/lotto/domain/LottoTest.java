package lotto.domain;

import lotto.model.LottoPrize;
import net.bytebuddy.build.Plugin.WithInitialization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개보다 적으면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 45보다 큰 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_45보다_큰_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1보다 작은 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_1보다_작은_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 오름차순 정렬되어야 한다.")
    @Test
    void 로또_번호는_오름차순_정렬되어야_한다() {
        Lotto lotto = Lotto.quickPick();
        assertTrue(isSorted(lotto),
                "로또 번호는 오름차순 정렬되야 합니다");
        ;
    }

    private boolean isSorted(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1).compareTo(numbers.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    @DisplayName("로또 번호가 지정된 형식대로 출력돼야 한다.")
    @Test
    void 로또_번호가_지정된_형식대로_출력돼야_한다() {
        Lotto lotto = Lotto.quickPick();
        assertTrue(lotto.toString().matches("\\[\\d+, \\d+, \\d+, \\d+, \\d+, \\d+\\]"),
                "toString() 결과가 '[숫자, 숫자, 숫자, 숫자, 숫자, 숫자]' 형식이어야 합니다.");
    }

    @DisplayName("로또 번호에 입력이 존재하면 true를 반환한다.")
    @Test
    void 로또_번호에_입력이_존재하면_true를_반환한다() {
        Lotto lotto = new Lotto(List.of(
                1, 2, 3, 4, 5, 6
        ));
        assertTrue(lotto.contains(1));
    }

    @DisplayName("로또 번호에 입력이 존재하지 않으면 false를 반환한다.")
    @Test
    void 로또_번호에_입력이_존재하지_않으면_false를_반환한다() {
        Lotto lotto = new Lotto(List.of(
                1, 2, 3, 4, 5, 6
        ));
        assertFalse(lotto.contains(7));
    }

    @DisplayName("로또 2등 당첨 시 올바른 등수를 반환한다.")
    @Test
    void 로또_2등_당첨_시_올바른_등수를_반환한다() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        WinningLotto winningLotto = WinningLotto.of(
                new Lotto((List.of(1,2,3,4,5,6))),
                7
        );
        assertEquals(LottoPrize.SECOND, lotto.scratch(winningLotto));
    }

    @DisplayName("로또 당첨 시 올바른 등수를 반환한다.")
    @Test
    void 로또_당첨_시_올바른_등수를_반환한다() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        WinningLotto winningLotto = WinningLotto.of(
                new Lotto((List.of(1,2,3,4,5,6))),
                45
        );
        assertEquals(LottoPrize.THIRD, lotto.scratch(winningLotto));
    }
}
