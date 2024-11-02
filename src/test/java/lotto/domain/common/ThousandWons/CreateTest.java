package lotto.domain.common.ThousandWons;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("ThousandWons - 생성")
public class CreateTest {

    @DisplayName("생성한다")
    @Test
    void 생성한다() {
        // given
        String money = "5000";

        // expect
        Assertions.assertThatCode(() -> ThousandWons.of(money))
                .doesNotThrowAnyException();
    }

    @DisplayName("정수 그리고 천원단위 아니면 생성 실패")
    @ParameterizedTest()
    @ValueSource(strings = {"300", "999", "1001", "0", "-1"})
    void 천원단위_아니면_생성_실패(String money) {

        // expect
        Assertions.assertThatThrownBy(() -> ThousandWons.of(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 단위로 입력 가능 합니다.");
    }

    @DisplayName("정수도 아니고 천원단위 아니면 생성 실패")
    @ParameterizedTest()
    @ValueSource(strings = {"0.1", "@!#"})
    void 정수도_아니고_천원단위_아니면_생성_실패(String money) {

        // expect
        Assertions.assertThatThrownBy(() -> ThousandWons.of(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자로 변환할 수 없는 값입니다.");
    }

}
