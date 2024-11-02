package lotto.models;

import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PreIssueModelTest {
    @DisplayName("구매 금액을 정수로 입력했을 때, 올바른 로또 발행 수를 계산한다.")
    @Test
    void 기능_테스트() {
        PreIssueModel preIssueModel = new PreIssueModel("5000");
        assertThat(preIssueModel.getAmount()).isEqualTo(5);
    }

    @DisplayName("구입 금액이 음수인 경우 예외가 발생한다.")
    @Test
    void 음수_구입금액() {
        assertThatThrownBy(() -> new PreIssueModel("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 정수가 아닌 경우 예외가 발생한다.")
    @Test
    void 정수가_아닌_구입금액() {
        assertThatThrownBy(() -> new PreIssueModel("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public void runPreIssueModelTest() {
        Application.main(new String[]{});
    }
}