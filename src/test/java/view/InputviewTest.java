package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class InputviewTest {
    private Inputview inputView;

    @BeforeEach
    void setUp() {
        inputView = new Inputview();
    }

    @Test
    @DisplayName("문자열을 정수로 변환 - 성공 케이스")
    void stringToInt_ValidNumber()
    {
        String input = "1000";
        int result = inputView.stringToInt(input);
        assertThat(result).isEqualTo(1000);
    }

    @Test
    @DisplayName("문자열을 정수로 변환 - 실패 케이스(문자 포함)")
    void stringToInt_InvalidNumber()
    {
        String input = "1000j";
        assertThatThrownBy(() -> inputView.stringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


    @Test
    @DisplayName("로또 번호 범위 검증 - 유효한 번호")
    void validateNumberInRange_ValidNumber()
    {
        int number = 45;
        assertThatCode(() -> inputView.validateNumberInRange(number))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호 범위 검증 - 범위 초과")
    void validateNumberInRange_InvalidNumber()
    {
        int number = 46;
        assertThatThrownBy(() -> inputView.validateNumberInRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}