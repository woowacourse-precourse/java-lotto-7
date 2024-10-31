package lotto.common;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.PurchaseOverview;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OutputMakerTest {
    @Test
    void 구매현황_생성_테스트() {
        //given
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.addLotto(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        PurchaseOverview expected = new PurchaseOverview(
                "[1, 2, 3, 4, 5, 6]\n"
                + "[7, 8, 9, 10, 11, 12]\n"
        );

        // when
        PurchaseOverview overview = OutputMaker.makePurchaseOverview(lottos);

        //then
        assertThat(overview.getOverview()).isEqualTo(expected.getOverview());
    }
}