package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호 입력 테스트 성공")
    void shouldSetWinningLotto() {
        // given
        WinningLotto winningLotto = new WinningLotto();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        winningLotto.setWinningLotto(winningNumbers);

        // then
        assertThat(winningLotto.getWinningLotto().getNumbers()).containsExactlyElementsOf(winningNumbers);
    }

    @Test
    @DisplayName("보너스 번호 입력 테스트 성공")
    void shouldSetBonusNumber() {
        // given
        WinningLotto winningLotto = new WinningLotto();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        winningLotto.setWinningLotto(winningNumbers);
        String inputBonusNumber = "7";

        // when
        winningLotto.setBonusNumber(inputBonusNumber);

        // then
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호 입력 테스트 실패")
    void shouldThrowExceptionForInvalidBonusNumberFormat() {
        // given
        WinningLotto winningLotto = new WinningLotto();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        winningLotto.setWinningLotto(winningNumbers);
        String inputBonusNumber = "abcd";

        // when & then
        assertThatThrownBy(() -> winningLotto.setBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 값을 입력하였습니다.");
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트 범위 초과 실패")
    void shouldThrowExceptionForOutOfRangeBonusNumber() {
        // given
        WinningLotto winningLotto = new WinningLotto();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        winningLotto.setWinningLotto(winningNumbers);
        String inputBonusNumber = "50";

        // when & then
        assertThatThrownBy(() -> winningLotto.setBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호 입력 테스트 중복 입력 실패")
    void shouldThrowExceptionForDuplicateBonusNumber() {
        // given
        WinningLotto winningLotto = new WinningLotto();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        winningLotto.setWinningLotto(winningNumbers);
        String inputBonusNumber = "1";

        // when & then
        assertThatThrownBy(() -> winningLotto.setBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복되는 로또 번호가 존재합니다.");
    }
}
