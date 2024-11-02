package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개가_안되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 1에서 45를 벗어난 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_범위_벗어난_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호에 공백이 포함되면 예외가 발생한다.")
    void 로또_번호에_공백이_포함되면_예외가_발생한다() {
        String inputWithEmptyValue = "1, 2,  , 4, 5, 6";
        assertThatThrownBy(() -> {
            List<Integer> numbers = parseInputToNumbers(inputWithEmptyValue);
            new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private List<Integer> parseInputToNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(this::parseAndValidateNumber)
                .collect(Collectors.toList());
    }

    private Integer parseAndValidateNumber(String token) {
        if (token.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 빈 값이 포함될 수 없습니다.");
        }
        return Integer.parseInt(token);
    }

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    void 구입_금액이_단위_오류이면_예외가_발생한다() {
        String invalidAmount = "1500";  // 1,000원 단위가 아님
        assertThatThrownBy(() -> validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @Test
    @DisplayName("구입 금액 입력 시 숫자 이외의 값이 포함되면 예외가 발생한다.")
    void 구입_금액에_숫자_이외의_값이_포함되면_예외가_발생한다() {
        String invalidAmount = "1000원";  // 숫자 이외의 값이 포함됨
        assertThatThrownBy(() -> validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액만 입력해주세요.");
    }

    private void validatePurchaseAmount(String amount) {
        if (!amount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 금액만 입력해주세요.");
        }
        int numericAmount = Integer.parseInt(amount);
        if (numericAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }


}
