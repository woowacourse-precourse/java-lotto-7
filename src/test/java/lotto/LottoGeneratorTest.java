package lotto;

import lotto.service.LottoGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    void 구입금액에_따른_로또_갯수_계산() {
        int purchaseAmount = 8000;
        int expectedCount = 8;
        int actualCount = LottoGenerator.calculateLottoCount(purchaseAmount);

        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Test
    void 로또_번호_6개_생성() {
        List<Integer> lottoNumbers = LottoGenerator.generateLottoNumbers();
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    void 로또_번호_중복되지_않는지_확인() {
        List<Integer> lottoNumbers = LottoGenerator.generateLottoNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
        assertThat(uniqueNumbers.size()).isEqualTo(6);
    }

    @Test
    void 구입금액에_따른_여러_로또_티켓_생성() {
        int purchaseAmount = 5000;
        int expectedTicketCount = 5;
        List<List<Integer>> lottoTickets = LottoGenerator.generateLottoTickets(purchaseAmount);

        assertThat(lottoTickets).hasSize(expectedTicketCount);

        for (List<Integer> ticket : lottoTickets) {
            assertThat(ticket).hasSize(6);

            Set<Integer> uniqueNumbers = new HashSet<>(ticket);
            assertThat(uniqueNumbers.size()).isEqualTo(6);
        }
    }
}
