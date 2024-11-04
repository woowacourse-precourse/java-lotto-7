package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VoidViewTest {

    @DisplayName("void 뷰는 빈문자열로 렌더링된다.")
    @Test
    void test() {
        // given
        VoidView view = new VoidView();
        // when & then
        assertThat(view.render()).isEqualTo("");
    }

}