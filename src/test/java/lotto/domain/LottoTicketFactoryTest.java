package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.utils.LottoNumberGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketFactoryTest {

    LottoTicketFactory factory = new LottoTicketFactory(new LottoNumberGenerator());

    @Test
    public void 로또_생성() {
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //noinspection unchecked
        assertRandomUniqueNumbersInRangeTest(() -> {
            factory.generateLottoTickets(1);
        }, expectedNumbers);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void 로또_생성_여러장(int ticketCount) {
        assertThat(factory.generateLottoTickets(ticketCount)).hasSize(ticketCount);
    }

}