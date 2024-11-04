package lotto;

import lotto.validator.LottoNumberValidator;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @DisplayName("지나치게 큰 로또 번호 리스트를 방지한다 (메모리 보호)")
    @Test
    void validateExcessiveLottoNumbers() {
        List<Integer> hugeList = new ArrayList<>();
        IntStream.range(0, 1001).forEach(hugeList::add);

        assertThatThrownBy(() -> LottoNumberValidator.validate(hugeList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 리스트가 너무 큽니다.");
    }

    @DisplayName("입력값에 SQL Injection이나 XSS 공격 패턴이 포함된 경우를 검증한다")
    @Test
    void validateMaliciousInput() {
        String maliciousInput = "1,2,3,4,5,<script>alert('xss')</script>";

        assertThatThrownBy(() -> InputValidator.parseNumbers(maliciousInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 입력값입니다.");
    }

    @DisplayName("특수문자가 포함된 입력을 검증한다")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,;",
            "1,2,3,4,5,--",
            "1,2,3,4,5,'"
    })
    void validateSpecialCharacters(String input) {
        assertThatThrownBy(() -> InputValidator.parseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 입력값입니다.");
    }

    @DisplayName("Unicode 이스케이프 문자가 포함된 입력을 검증한다")
    @Test
    void validateUnicodeEscape() {
        String unicodeInput = "1,2,3,4,5,\u0000";

        assertThatThrownBy(() -> InputValidator.parseNumbers(unicodeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 입력값입니다.");
    }

    @DisplayName("매우 긴 입력 문자열을 검증한다")
    @Test
    void validateLongInput() {
        StringBuilder longInput = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            longInput.append("1,");
        }
        longInput.append("2");

        assertThatThrownBy(() -> InputValidator.parseNumbers(longInput.toString()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력이 너무 깁니다.");
    }
}