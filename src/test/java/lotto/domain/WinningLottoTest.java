package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    @DisplayName("당첨 로또 검사")
    void matchWinningLotto() {
        WinningLotto winningLotto = WinningLotto.builder()
                .winningNumbers(List.of(1, 2, 3, 4, 5, 6))
                .bonusNumber(7)
                .build();

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Rank rank = winningLotto.match(lotto);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("당첨 번호 중복값")
    void createWinningLottoWithDuplicates() {
        assertThatThrownBy(() -> WinningLotto.builder()
                .winningNumbers(List.of(1, 2, 3, 4, 5, 5))
                .bonusNumber(7)
                .build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 존재합니다.");
    }

    @Test
    @DisplayName("보너스 번호 중복값")
    void createWinningLottoWithBonusNumberDuplicate() {
        assertThatThrownBy(() -> WinningLotto.builder()
                .winningNumbers(List.of(1, 2, 3, 4, 5, 6))
                .bonusNumber(6)
                .build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 존재합니다.");
    }

    @Test
    @DisplayName("부적절한 값 갯수")
    void createWinningLottoWithInvalidSize() {
        assertThatThrownBy(() -> WinningLotto.builder()
                .winningNumbers(List.of(1, 2, 3, 4, 5, 6, 7))
                .bonusNumber(8)
                .build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("크기가 적절하지 않습니다. 현재 크기:");
    }
}
