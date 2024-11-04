package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @DisplayName("구매 개수만큼 로또 번호를 생성한다.")
    @Test
    void purchaseLottoNumbersTest() {
        // given
        LottoNumbers lottoNumbers = LottoNumbers.from(new ArrayList<>());
        OutputView outputView = new OutputView();

        // when
        int purchaseCount = 8;
        lottoNumbers.purchaseLotto(purchaseCount, outputView);
        // then
        assertThat(lottoNumbers.getLottoNumbers())
                .hasSize(8);
    }

}