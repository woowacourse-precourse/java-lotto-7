package lotto.dto;

import java.util.List;
import lotto.model.budget.Budget;
import lotto.model.win.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("수익률 계산에 반올림 등이 잘 적용되는지 확인한다.")
    @Test
    void 수익률_계산_확인() {
        LottoResult result = LottoResult.builder()
                .budget(new Budget(13000))
                .addAllPrize(List.of(Prize.FIFTH, Prize.FOURTH))
                .build();

        System.out.println(result.rate());
        Assertions.assertThat(result.rate())
                .isEqualTo(423.1d);
    }
}
