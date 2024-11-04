package lotto.application.prize.view.input.request;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeViewRequestTest {

    @DisplayName("작동 테스트")
    @Test
    void 작동_테스트() {
        // given
        List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        PrizeViewRequest request = new PrizeViewRequest(winnerNumbers, bonusNumber);

        // then
        assertAll(
                () -> assertThat(request.winnerNumbers())
                        .isEqualTo(winnerNumbers)
                        .containsExactly(1, 2, 3, 4, 5, 6),
                () -> assertThat(request.bonusNumber())
                        .isEqualTo(bonusNumber),
                () -> assertThat(request.winnerNumbers())
                        .hasSize(6),
                () -> assertThat(request.winnerNumbers())
                        .doesNotContain(bonusNumber)
        );
    }

}
