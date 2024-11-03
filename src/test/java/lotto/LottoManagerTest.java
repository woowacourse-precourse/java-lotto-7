package lotto;

import lotto.constant.Constants;
import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.PurchaseQuantity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoManagerTest {

    @Test
    @DisplayName("구매금액에 맞게 로또가 올바르게 발행되는지 테스트")
    void publishLottoTest() {
        //given
        LottoManager lottoManager = new LottoManager();
        lottoManager.setPurchaseQuantity(new PurchaseQuantity("4000"));

        //when
        List<Lotto> lottos = lottoManager.publishLotto();

        //then
        assertThat(lottos).hasSize(lottoManager.getPurchaseQuantity().getPurchaseQuantity()); // 구매 수량대로 발행되었는지 확인
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(Constants.LOTTO_SIZE.getConstant());

            assertThat(lotto.getNumbers()).allMatch(num -> num >= Constants.LOTTO_NUMBER_START_RANGE.getConstant() &&
                    num <= Constants.LOTTO_NUMBER_END_RANGE.getConstant());

            assertThat(lotto.getNumbers()).isSorted();
        }
    }
}
