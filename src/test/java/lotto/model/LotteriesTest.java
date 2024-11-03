package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.util.generator.LottoNumberGenerator;
import lotto.vo.BonusNumber;
import lotto.vo.TicketCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

class LotteriesTest {

    private LottoNumberGenerator testGenerator;

    @BeforeEach
    void setUp() {
        testGenerator = new TestLottoNumberGenerator();
    }

    @DisplayName("티켓 개수에 따라 로또 번호를 생성한다")
    @Test
    void 티켓_개수에_따라_로또_번호_생성() {
        TicketCount ticketCount = new TicketCount(3);

        Lotteries lotteries = Lotteries.createLotteries(ticketCount, testGenerator);

        assertThat(lotteries.getLotteries()).hasSize(ticketCount.count());
        lotteries.getLotteries().forEach(lotto ->
                assertThat(lotto.getNumbers()).containsExactly(1,2,3,45,5,6));
    }

    @DisplayName("보너스 번호 포함 여부를 확인한다.")
    @Test
    void 보너스_번호_포함_여부_확인() {
        TicketCount ticketCount = new TicketCount(3);
        Lotteries lotteries = Lotteries.createLotteries(ticketCount, testGenerator);
        BonusNumber bonusNumber = new BonusNumber(6);

        List<Boolean> bonusContainList = lotteries.checkBonusNumberContain(bonusNumber);

        assertThat(bonusContainList).containsExactly(true, true, true);
    }

    @DisplayName("로또번호와 당첨 번호의 매칭 개수를 계산하여 반환한다.")
    @Test
    void 로또_번호와_당첨_번호_매칭_개수를_계산() {
        TicketCount ticketCount = new TicketCount(2);
        Lotteries lotteries = Lotteries.createLotteries(ticketCount, testGenerator);
        Lotto winningLottoEx1 = Lotto.createWinningLotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto winningLottoEx2 = Lotto.createWinningLotto(List.of(1, 2, 3, 45, 8, 9));

        List<Integer> matchedCount1 = lotteries.countMatchedNumbers(winningLottoEx1);
        List<Integer> matchedCount2 = lotteries.countMatchedNumbers(winningLottoEx2);

        assertThat(matchedCount1).containsExactly(3, 3);
        assertThat(matchedCount2).containsExactly(4, 4);
    }

    @DisplayName("테스트용 LottoNumberGenerator 구현")
    private static class TestLottoNumberGenerator implements LottoNumberGenerator {
        @Override
        public List<Integer> numberGenerator() {
            return List.of(1,2,3,45,5,6);
        }
    }
}