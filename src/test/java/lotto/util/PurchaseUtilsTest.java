package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.util.PurchaseUtils.getThousandUnitCount;
import static org.assertj.core.api.Assertions.assertThat;

class PurchaseUtilsTest {
    @Test
    @DisplayName("1,000원 단위로 로또 구매한 수")
    void 천원_단위로_로또_구매한_수() {
        int thousandUnitCount = getThousandUnitCount("10000");
        assertThat(thousandUnitCount).isEqualTo(10);
    }
}