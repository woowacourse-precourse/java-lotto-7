package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import common.validate.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.Test;

class BuyerTest {

    @Test
    void 구매자는_로또를_구매할_수_있어야한다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Buyer buyer = Buyer.buyLotto(3000);
                    assertThat(buyer.toString()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]");
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @Test
    void 구매한_로또_당첨_내역() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Buyer buyer = Buyer.buyLotto(3000);
                    assertThat(buyer.getRanks(
                            List.of(8, 21, 23, 41, 42, 43),
                            11
                    )).isEqualTo(List.of(Rank.FIRST_PLACE));
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @Test
    void 구입_금액_단위_예외_처리() {
        assertSimpleTest(
                () -> {
                    assertThatThrownBy(() -> Buyer.buyLotto(1500))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE.format(1000));
                }
        );
    }
}