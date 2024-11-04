package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PurchasedLottoTest {

    @Test
    void 로또_생성() {
        //given
        int generateCount = 10;

        //when
        PurchasedLotto purchasedLotto = PurchasedLotto
                .generateLottos(
                        generateCount,
                        () -> Randoms.pickUniqueNumbersInRange(1, 45, 6)
                );

        //then
        assertThat(purchasedLotto.getSize()).isEqualTo(generateCount);
    }

    @Test
    void 로또_당첨_검사_1등() {
        //given
        int generateCount = 3;
        PurchasedLotto purchasedLotto = PurchasedLotto.generateLottos(generateCount, () -> List.of(1, 2, 3, 4, 5, 6));

        //when
        Map<Prize, Integer> result = purchasedLotto.checkWin(List.of(1, 2, 3, 4, 5, 6), 7);

        //then
        assertThat(result.getOrDefault(Prize.FIRST_PLACE, 0)).isEqualTo(generateCount);
        assertThat(result.getOrDefault(Prize.SECOND_PLACE, 0)).isZero();
        assertThat(result.getOrDefault(Prize.THIRD_PLACE, 0)).isZero();
        assertThat(result.getOrDefault(Prize.FOURTH_PLACE, 0)).isZero();
        assertThat(result.getOrDefault(Prize.FIFTH_PLACE, 0)).isZero();
    }

    @Test
    void 로또_당첨_검사_2등() {
        //given
        int generateCount = 3;
        PurchasedLotto purchasedLotto = PurchasedLotto.generateLottos(generateCount, () -> List.of(1, 2, 3, 4, 5, 6));

        //when
        Map<Prize, Integer> result = purchasedLotto.checkWin(List.of(1, 2, 3, 4, 5, 7), 6);

        //then
        assertThat(result.getOrDefault(Prize.FIRST_PLACE, 0)).isZero();
        assertThat(result.getOrDefault(Prize.SECOND_PLACE, 0)).isEqualTo(3);
        assertThat(result.getOrDefault(Prize.THIRD_PLACE, 0)).isZero();
        assertThat(result.getOrDefault(Prize.FOURTH_PLACE, 0)).isZero();
        assertThat(result.getOrDefault(Prize.FIFTH_PLACE, 0)).isZero();
    }
}