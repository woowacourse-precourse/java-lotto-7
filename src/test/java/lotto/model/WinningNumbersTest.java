package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoException;
import lotto.model.win.Prize;
import lotto.model.win.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("당첨 로또가 잘 생성되는지 확인")
    @Test
    void 당첨_로또_생성() {
        Assertions.assertThat(new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7))
                .isNotNull();
    }

    @DisplayName("보너스가 로또 번호와 겹칠 때 예외가 발생하는지 확인")
    @Test
    void 보너스_숫자_중복_예외() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(LottoException.class);
    }

    @DisplayName("보너스가 범위를 벗어났을 때 예외가 발생하는지 확인")
    @Test
    void 보너스_숫자_범위_예외() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 99))
                .isInstanceOf(LottoException.class);
    }

    @DisplayName("비교 했을 때 1등으로 당첨되는지 확인")
    @Test
    void 일등_비교_확인() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(winningNumbers.compare(lotto))
                .isEqualTo(Prize.WIN);
    }

    @DisplayName("비교 했을 때 2등으로 당첨되는지 확인")
    @Test
    void 이등_비교_확인() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Assertions.assertThat(winningNumbers.compare(lotto))
                .isEqualTo(Prize.SECOND);
    }

    @DisplayName("비교 했을 때 3등으로 당첨되는지 확인")
    @Test
    void 삼등_비교_확인() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Assertions.assertThat(winningNumbers.compare(lotto))
                .isEqualTo(Prize.THIRD);
    }

    @DisplayName("비교 했을 때 4등으로 당첨되는지 확인")
    @Test
    void 사등_비교_확인() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 8));
        Assertions.assertThat(winningNumbers.compare(lotto))
                .isEqualTo(Prize.FOURTH);
    }

    @DisplayName("비교 했을 때 5등으로 당첨되는지 확인")
    @Test
    void 오등_비교_확인() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 9, 8));
        Assertions.assertThat(winningNumbers.compare(lotto))
                .isEqualTo(Prize.FIFTH);
    }
}
