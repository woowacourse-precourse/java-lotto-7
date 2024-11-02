package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.dto.LottoBundle;
import lotto.dto.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @DisplayName("원하는 티켓 Lotto의 상태를 올바르게 반환하는지 크기를 확인한다.")
    @Test
    void Given_LottoTicket_When_GetLottoTicketStatus_Then_ReturnLottoBundleWithCorrectNumbers() {
        // Given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18));
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(lotto1, lotto2, lotto3));

        // When
        LottoBundle lottoBundle = lottoTicket.getLottoTicketStatus();

        // Then
        List<LottoNumbers> expectedLottoNumbers = Arrays.asList(
                lotto1.getLottoNumbers(),
                lotto2.getLottoNumbers(),
                lotto3.getLottoNumbers()
        );
        assertThat(lottoBundle.getLottoNumbers().size()).isEqualTo(expectedLottoNumbers.size());
    }
}