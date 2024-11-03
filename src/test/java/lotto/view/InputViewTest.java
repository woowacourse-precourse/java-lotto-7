package lotto.view;

import lotto.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    private final InputStream standardIn = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(standardIn);
    }

    @DisplayName("구입금액 입력 확인")
    @Test
    void 구입금액_입력_테스트() {
        System.setIn(new ByteArrayInputStream("8000".getBytes()));
        int amount = InputView.inputPurchaseAmount();
        assertThat(amount).isEqualTo(8000);
    }

    @DisplayName("구입금액 입력 문자 포함 예외")
    @Test
    void 구입금액_입력_문자_포함() {
        String amount = "abcd";
        assertThatThrownBy(() -> InputView.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
    }

    @DisplayName("구입금액 입력 1000원 단위 테스트")
    @Test
    void 구입금액_입력_1000원_단위() {
        String amount = "2500";
        assertThatThrownBy(() -> InputView.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
    }

    @DisplayName("당첨번호 입력 테스트")
    @Test
    void 당첨번호_정상_입력() {
        String winningNumbers = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(winningNumbers.getBytes()));
        Lotto winningLotto = InputView.inputWinningNumbers();
        assertThat(winningLotto.getLotto()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨번호 공백 포함 시 예외발생")
    @Test
    void 당첨번호_공백_포함_예외발생() {
        // 사용자 입력 모의 - 잘못된 포맷의 입력 예시
        String simulatedInput = "1, 2, 3, 4, 5, 6";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertThatThrownBy(InputView::inputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자와 쉼표로만 입력해야 합니다.");
    }

    @DisplayName("당첨번호 특수문자 포함 시 예외발생")
    @Test
    void 당첨번호_특수문자_포함_예외발생() {
        // 사용자 입력 모의 - 잘못된 포맷의 입력 예시
        String simulatedInput = "1,2,3,@4,5,6";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertThatThrownBy(InputView::inputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자와 쉼표로만 입력해야 합니다.");
    }
}
