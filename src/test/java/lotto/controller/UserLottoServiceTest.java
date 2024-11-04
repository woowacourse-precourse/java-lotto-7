package lotto.controller;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.service.UserLottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserLottoServiceTest {

    private UserLottoService userLottoService;

    @BeforeEach
    void setUp() {
        userLottoService = new UserLottoService();
    }

    @Nested
    @DisplayName("당첨 번호 검증")
    class ValidateDefaultNumber {

        @Test
        @DisplayName("빈 입력이 들어오면 예외가 발생한다")
        void validateEmptyInput() {
            assertThatThrownBy(() -> userLottoService.validateDefaultNumber(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 입력값입니다.");
        }

        @Test
        @DisplayName("숫자가 아닌 입력이 들어오면 예외가 발생한다")
        void validateInvalidFormat() {
            List<String> input = Arrays.asList("1", "2", "3", "a", "5", "6");
            assertThatThrownBy(() -> userLottoService.validateDefaultNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해주세요.");
        }

        @Test
        @DisplayName("범위를 벗어난 숫자가 입력되면 예외가 발생한다")
        void validateInvalidRange() {
            List<String> input = Arrays.asList("1", "2", "3", "46", "5", "6");
            assertThatThrownBy(() -> userLottoService.validateDefaultNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45 사이의 숫자를 입력해주세요.");
        }

        @Test
        @DisplayName("6개가 아닌 경우 예외가 발생한다")
        void validateInvalidSize() {
            List<String> input = Arrays.asList("1", "2", "3", "4", "5");
            assertThatThrownBy(() -> userLottoService.validateDefaultNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개, 보너스 번호는 1개를 입력해주세요.");
        }

        @Test
        @DisplayName("중복된 번호가 있으면 예외가 발생한다")
        void validateDuplicateNumbers() {
            List<String> input = Arrays.asList("1", "2", "3", "3", "4", "5");
            assertThatThrownBy(() -> userLottoService.validateDefaultNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 번호입니다.");
        }
    }

    @Nested
    @DisplayName("보너스 번호 검증")
    class ValidateBonusNumber {

        @BeforeEach
        void setUpDefaultNumbers() {
            userLottoService.validateDefaultNumber(Arrays.asList("1", "2", "3", "4", "5", "6"));
        }

        @Test
        @DisplayName("빈 입력이 들어오면 예외가 발생한다")
        void validateEmptyBonus() {
            assertThatThrownBy(() -> userLottoService.validateBonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 입력값입니다.");
        }

        @Test
        @DisplayName("숫자가 아닌 입력이 들어오면 예외가 발생한다")
        void validateInvalidFormatBonus() {
            assertThatThrownBy(() -> userLottoService.validateBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해주세요.");
        }

        @Test
        @DisplayName("범위를 벗어난 숫자가 입력되면 예외가 발생한다")
        void validateInvalidRangeBonus() {
            assertThatThrownBy(() -> userLottoService.validateBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45 사이의 숫자를 입력해주세요.");
        }

        @Test
        @DisplayName("당첨 번호와 중복된 번호가 입력되면 예외가 발생한다")
        void validateDuplicateBonusNumber() {
            assertThatThrownBy(() -> userLottoService.validateBonusNumber("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 번호입니다.");
        }
    }
}