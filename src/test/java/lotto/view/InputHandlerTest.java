package lotto.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.view.InputHandler.validatePurchaseAmount;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputHandlerTest {

    @ParameterizedTest
    @ValueSource(ints = {-1000, -1, 0, 1, 100, 1001})
    void 구입_금액이_1000의_배수가_아니면_예외_발생(int purchaseAmount) {
        assertThatThrownBy(() -> validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 1000000})
    void 구입_금액이_1000의_배수이면_예외_없음(int purchaseAmount) {
        assertDoesNotThrow(() -> {
            InputHandler.validatePurchaseAmount(purchaseAmount);
        });
    }

    @ParameterizedTest
    @MethodSource("provideIntegerLists")
    void 당첨_번호가_1에서_45_사이의_값이_아니면_예외_발생(List<Integer> winningNumbers) {
        assertThatThrownBy(() -> validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당청 번호는 1에서 45 사이의 값이어야 합니다.");
    }

    static Stream<List<Integer>> provideIntegerLists() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 46),
                List.of(0, 1, 2, 3, 4, 5)
        );
    }
}
