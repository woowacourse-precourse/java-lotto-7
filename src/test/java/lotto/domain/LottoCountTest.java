package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountTest {
    private LottoCount lottoCount;

    @BeforeEach
    public void setUp() {
        this.lottoCount = new LottoCount(new LottoPrice(14000));
    }

    @DisplayName("로또 갯수")
    @Test
    void 로또_갯수() {
        assertThat(lottoCount.getCount()).isEqualTo(14);
    }
}
