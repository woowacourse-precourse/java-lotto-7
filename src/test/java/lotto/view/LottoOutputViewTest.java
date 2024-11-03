package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoOutputViewTest {

    @DisplayName("구매한 로또 수량을 출력한다")
    @Test
    void printLottoCount() {
        LottoOutputView outputView = new LottoOutputView();
        assertThat(outputView.getLottoCountMessage(3)).isEqualTo("3개를 구매했습니다.");
    }
}