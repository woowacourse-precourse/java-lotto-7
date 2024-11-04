package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("[]가 잘 사라지는가?")
    void substringTest() {
        assertThat(lottoService.extractLottoNumber("[123]")).isEqualTo("123");
        assertThat(lottoService.extractLottoNumber("[]")).isEqualTo("");
        assertThat(lottoService.extractLottoNumber("[1,2,3]")).isEqualTo("1,2,3");
    }
}