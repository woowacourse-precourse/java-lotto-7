package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class PurchasedLottoTest {

    @Test
    void 새_로또번호_추가_테스트(){
        PurchasedLotto purchasedLotto = new PurchasedLotto();

        purchasedLotto.addLotto(new Lotto(List.of(1,2,3,4,5,6)));
        purchasedLotto.addLotto(new Lotto(List.of(1,2,3,4,5,6)));
        purchasedLotto.addLotto(new Lotto(List.of(1,2,3,4,5,6)));

        assertThat(purchasedLotto.getLottos()).hasSize(3);
    }

    @Test
    void 당첨결과_확인_테스트(){
        PurchasedLotto purchasedLotto = new PurchasedLotto();

        purchasedLotto.addLotto(new Lotto(List.of(1,2,3,4,5,6))); //4 일치ㅎ
        purchasedLotto.addLotto(new Lotto(List.of(3,4,10,11,23,44))); //4 일치
        purchasedLotto.addLotto(new Lotto(List.of(10,11,15,17,22,40))); // 2 + 1 일치
        purchasedLotto.matchLotto(new WinningNumber(new Lotto(List.of(1,2,3,4,10,11)), 15));
        Map<Prize, Integer> prizes = purchasedLotto.getPrizes();

        assertThat(prizes.get(Prize.FOURTH)).isEqualTo(2);
        assertThat(prizes.get(Prize.FAIL)).isEqualTo(1);
    }

    @Test
    void 수익률_반환_테스트(){
        PurchasedLotto purchasedLotto = new PurchasedLotto();

        purchasedLotto.addLotto(new Lotto(List.of(1,2,3,4,5,6)));
        purchasedLotto.addLotto(new Lotto(List.of(12,13,14,15,16,17)));
        purchasedLotto.addLotto(new Lotto(List.of(12,13,14,15,16,17)));
        purchasedLotto.addLotto(new Lotto(List.of(12,13,14,15,16,17)));
        purchasedLotto.addLotto(new Lotto(List.of(12,13,14,15,16,17)));
        purchasedLotto.addLotto(new Lotto(List.of(12,13,14,15,16,17)));
        purchasedLotto.addLotto(new Lotto(List.of(12,13,14,15,16,17)));
        purchasedLotto.addLotto(new Lotto(List.of(12,13,14,15,16,17)));

        purchasedLotto.matchLotto(new WinningNumber(new Lotto(List.of(1,2,3,9,10,11)), 15));

        assertThat(purchasedLotto.getRateOfReturn()).isEqualTo(62.5);
    }

    @Test
    void 다중_1등_당첨_테스트(){
        PurchasedLotto purchasedLotto = new PurchasedLotto();

        purchasedLotto.addLotto(new Lotto(List.of(1,2,3,4,5,6)));
        purchasedLotto.addLotto(new Lotto(List.of(1,2,3,4,5,6)));
        purchasedLotto.addLotto(new Lotto(List.of(1,2,3,4,5,6)));
        purchasedLotto.addLotto(new Lotto(List.of(1,2,3,4,5,6)));
        purchasedLotto.addLotto(new Lotto(List.of(1,2,3,4,5,6)));

        purchasedLotto.matchLotto(new WinningNumber(new Lotto(List.of(1,2,3,4,5,6)), 15));

        assertThat(purchasedLotto.getRateOfReturn()).isEqualTo(200000000.0);
    }
}
