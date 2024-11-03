package lotto.shop.bandingmachine;

import lotto.MessageCenter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DrawSystemTest {

    DrawnNumbers drawnNumbers = DrawnNumbers.create();
    DrawSystem drawSystem = new DrawSystem(drawnNumbers);

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,100})
    @DisplayName("추첨 후 drawnNumberPacks에 저장된 로또번호묶음의 개수는 구매장수와 같다.")
    void 추첨_후_drawnNumberPacks에_저장된_로또번호묶음의_개수는_totalCount와_같다(int totalCount) {
        assertThat(drawSystem.runDraws(totalCount).size()).isEqualTo(totalCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000, Integer.MIN_VALUE})
    @DisplayName("구매장수가 양의 정수가 아니면 예외가 발생한다.")
    void 구매_장수가_양의_정수가_아니면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> drawSystem.runDraws(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_COUNT.get());
    }

    @ParameterizedTest
    @ValueSource(ints = 0)
    @NullSource
    @DisplayName("구매장수가 NULL이면 예외가 발생한다.")
    void 구매_장수가_0장이거나_NULL이면_예외가_발생한다(Integer input) {
        assertThatThrownBy(() -> drawSystem.runDraws(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_COUNT.get());
    }

    @Test
    @DisplayName("추첨 전 drawNumbers의 사이즈는 0이다.")
    void 추첨_전_drawNumbers의_사이즈는_0이다() {
        assertThat(drawSystem.drawnNumberPacks.size()).isEqualTo(0);
    }
}
