package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.EnumMap;
import java.util.List;
import lotto.constant.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    @DisplayName("올바른 입력을 통한 객체 생성 시도")
    @Test
    void 올바른_입력을_통한_객체_생성_시도() {
        List<WinningType> inputWinningTypes = List.of(
                WinningType.FIRST,
                WinningType.SECOND, WinningType.SECOND,
                WinningType.THIRD, WinningType.THIRD, WinningType.THIRD,
                WinningType.FORT, WinningType.FORT, WinningType.FORT, WinningType.FORT,
                WinningType.FIFTH, WinningType.FIFTH, WinningType.FIFTH, WinningType.FIFTH, WinningType.FIFTH
        );

        WinningResult winningResult = new WinningResult(inputWinningTypes);

        EnumMap<WinningType, Integer> countPerWinningType = winningResult.getCountPerWinningType();
        assertThat(countPerWinningType.get(WinningType.FIRST)).isEqualTo(1);
        assertThat(countPerWinningType.get(WinningType.SECOND)).isEqualTo(2);
        assertThat(countPerWinningType.get(WinningType.THIRD)).isEqualTo(3);
        assertThat(countPerWinningType.get(WinningType.FORT)).isEqualTo(4);
        assertThat(countPerWinningType.get(WinningType.FIFTH)).isEqualTo(5);
        assertThat(countPerWinningType.get(WinningType.NONE)).isEqualTo(0);
    }

    @DisplayName("잘못된 입력을 통한 객체 생성 시도")
    @Test
    void 잘못된_입력을_통한_객체_생성_시도() {
        List<WinningType> inputWinningTypes = null;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningResult(inputWinningTypes))
                .withMessage(WinningResult.NULL_WINNING_TYPES_EXCEPTION_MESSAGE);
    }
}