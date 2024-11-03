package lotto.domain.generator;

import lotto.dto.result.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersGeneratorTest {

    private final WinningNumbersGenerator generator = new WinningNumbersGenerator();

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("당첨 번호가 정상적으로 생성되며 6개의 고유한 번호를 포함한다.")
        void 당첨_번호_생성_성공() {
            WinningNumbers winningNumbers = generator.generate();

            assertThat(winningNumbers.lottoNumbers()).hasSize(6);
            assertThat(new HashSet<>(winningNumbers.lottoNumbers()).size()).isEqualTo(6);
        }

        @Test
        @DisplayName("생성된 당첨 번호는 1과 45 사이의 숫자만 포함한다.")
        void 당첨_번호_범위_확인() {
            WinningNumbers winningNumbers = generator.generate();

            assertThat(winningNumbers.lottoNumbers())
                    .allMatch(number -> number >= 1 && number <= 45);
        }
    }
}
