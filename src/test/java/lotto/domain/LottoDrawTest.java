package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDrawTest {

    @DisplayName("여러 개의 로또를 생성한다.")
    @Test
    void generateLottosTest() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("3000");
        NumbersGenerator fixedNumbersGenerator = () -> List.of(1, 2, 3, 4, 5, 6);
        LottoDraw lottoDraw = new LottoDraw(purchaseAmount, fixedNumbersGenerator);

        LottoTicket lottoTicket = lottoDraw.generateLottos();

        lottoTicket.getLottos().forEach(lotto ->
                assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6))
        );
    }
}
