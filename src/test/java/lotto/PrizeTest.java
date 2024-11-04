package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @Test
    void 일치_개수와_보너스_여부에_따라_Prize_Enum_값을_반환한다() {
        assertThat(Prize.valueOf(3, false)).isEqualTo(Prize.THREE_MATCHES);
        assertThat(Prize.valueOf(4, false)).isEqualTo(Prize.FOUR_MATCHES);
        assertThat(Prize.valueOf(5, false)).isEqualTo(Prize.FIVE_MATCHES);
        assertThat(Prize.valueOf(5, true)).isEqualTo(Prize.FIVE_MATCHES_WITH_BONUS);
        assertThat(Prize.valueOf(6, false)).isEqualTo(Prize.SIX_MATCHES);
        assertThat(Prize.valueOf(2, false)).isNull();
    }
}
