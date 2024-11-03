package lotto.view;

import java.util.List;
import lotto.model.LottoPurchaseResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultFormatterTest {
    @DisplayName("LottoPurchaseResultFormatter 문자열 반환 형식 테스트")
    @Test
    void formatLottoPurchaseResultTest() {
        ResultFormatter resultFormatter = new ResultFormatter();

        LottoPurchaseResult lottoPurchaseResult = new LottoPurchaseResult(
                List.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12)), 2
        );

        String expectedString = "2개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n";

        Assertions.assertThat(resultFormatter.formatLottoPurchaseResult(lottoPurchaseResult))
                .isEqualTo(expectedString);
    }
}