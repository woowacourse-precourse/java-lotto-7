package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTypeTest {
    @Test
    void 각_등수에_해당하는_당첨_내역_정보를_가져올_수_있다() {
        assertThat(WinnerType.information()).contains("개 일치")
                .contains("보너스 볼 일치")
                .contains("원")
                .contains("개");
    }
}