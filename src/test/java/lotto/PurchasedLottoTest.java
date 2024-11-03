package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PurchasedLottoTest {

    @Test
    void 로또_생성(){
        //given
        int generateCount = 10;

        //when
        PurchasedLotto purchasedLotto = PurchasedLotto.generateLottos(generateCount);

        //then
        assertThat(purchasedLotto.getSize()).isEqualTo(generateCount);
    }

}