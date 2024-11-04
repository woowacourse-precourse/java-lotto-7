package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    private final LottoGame lottoGame = new LottoGame();

    @Test
    @DisplayName("구입 금액이 숫자일 경우 정상적으로 금액을 반환한다.")
    void parseAndValidateAmount_validAmount() {
        int quantity = lottoGame.parseAndValidateAmount("5000");
        assertThat(quantity).isEqualTo(5); // 5000원을 입력했을 때 로또 5개 구매
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    void parseAndValidateAmount_invalidInput() {
        assertThatThrownBy(() -> lottoGame.parseAndValidateAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 숫자여야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    void parseAndValidateAmount_invalidUnit() {
        assertThatThrownBy(() -> lottoGame.parseAndValidateAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호를 입력하고 매칭된 개수를 계산한다.")
    void calculateMatchCount() {
        // 테스트용 당첨 번호와 로또 티켓 번호를 미리 설정
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> lottoNumbers = List.of(1, 2, 3, 7, 8, 9);

        // 3개 일치 테스트
        int matchCount = (int) lottoNumbers.stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
        assertThat(matchCount).isEqualTo(3);
    }
}
