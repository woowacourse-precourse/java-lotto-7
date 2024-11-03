package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.db.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPaymentViewTest {

    @DisplayName("로또 구매 후 로또 개수와 로또 번호를 출력한다.")
    @Test
    void viewFormat() {
        // given
        List<Lotto> lotties = new ArrayList<>(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(11, 12, 13, 14, 15, 16))));
        LottoPaymentView view = new LottoPaymentView(lotties);
        // when
        String viewStr = view.render();
        // then
        assertThat(viewStr).
                matches("\n\\d+개를 구매했습니다."
                        + "\n\\[\\d+, \\d+, \\d+, \\d+, \\d+, \\d+\\]"
                        + "\n\\[\\d+, \\d+, \\d+, \\d+, \\d+, \\d+\\]");
    }
}