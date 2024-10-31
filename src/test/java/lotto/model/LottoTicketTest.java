package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketTest {

    @DisplayName("로또 티켓 내부에는 구입 수량만큼의 로또가 생성되어야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 1", "12, 12", "100, 100"})
    void createLottoTicket(int lottoCount, int expected) {

        LottoTicket lottoTicket = new LottoTicket(lottoCount);

        assertThat(lottoTicket.getLottoCount()).isEqualTo(expected);
    }
}