package lotto.exception.constants;

import static lotto.exception.constants.ExceptionMessage.ERROR_PREFIX;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("예외 메세지 테스트")
class ExceptionMessageTest {

    @Test
    @DisplayName("예외 메세지 형식을 생성한다.")
    void 성공_형식() {
        // Given

        // When
        String errorMessage = ERROR_PREFIX.format("message");

        // Then
        assertThat(errorMessage).startsWith(ERROR_PREFIX.getMessage())
                .contains("message");
    }
}
