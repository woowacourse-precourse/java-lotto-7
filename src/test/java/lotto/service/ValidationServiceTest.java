package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoException;
import lotto.exception.ViewInputException;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationServiceTest {

    private final ValidationService service;
    public ValidationServiceTest() {
        this.service = new ValidationService();
    }

    @DisplayName("정수 변환을 잘 처리하는지 획인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "AA", "A10", "3.141592", "3.00", "++10", "--10"})
    void 숫자_예외처리(String input) {
        assertThatThrownBy(() -> {
            service.isNumber(input);
        }).isInstanceOf(ViewInputException.class);
    }

    @DisplayName("리스트 포맷을 잘 감지하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", ",", "1,2,3,", ",1,2,3", "A,B,C", "1,2,A"})
    void 리스트_포맷_예외처리(String input) {
        assertThatThrownBy(() -> {
            service.isListFormat(input);
        }).isInstanceOf(ViewInputException.class);
    }
}
