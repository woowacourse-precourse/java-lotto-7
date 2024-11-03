package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoOutputViewTest {

    @DisplayName("구매한 로또 수량을 출력한다")
    @Test
    void printLottoCount() {
        LottoOutputView outputView = new LottoOutputView();
        assertThat(outputView.getLottoCountMessage(3)).isEqualTo("3개를 구매했습니다.");
    }

    @DisplayName("로또 번호를 출력한다")
    @Test
    void printLottoNumbers() {
        LottoOutputView outputView = new LottoOutputView();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(outputView.getLottoNumbersMessage(numbers)).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}