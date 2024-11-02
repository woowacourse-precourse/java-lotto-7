package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningNumbersPoolGeneratorTest {

    private final WinningNumbersPoolGenerator generator = new WinningNumbersPoolGenerator();

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("올바른 번호 풀을 생성한다.")
        void 올바른_번호_풀_생성() {
            List<Integer> numbersPool = generator.createWinningNumbersPool();
            assertThat(numbersPool).hasSize(7);
            assertThat(numbersPool).doesNotHaveDuplicates();
            assertThat(numbersPool).allMatch(num -> num >= 1 && num <= 45);
        }
    }
}
