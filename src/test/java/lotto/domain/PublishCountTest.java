package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PublishCountTest 클래스 테스트")
public class PublishCountTest {

    @Test
    void 발행_횟수가_30회_초과면_오류() {
        assertThatThrownBy(() -> PublishCount.getInstance(40))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
