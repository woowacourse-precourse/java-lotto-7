package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.service.RankCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankCalculatorTest {

    private static final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final int BONUS_NUMBER = 7;

    @ParameterizedTest(name = "일치한 번호 개수 {0}, 보너스 번호 일치 여부 {1}, 예상 등수 {2}")
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, NONE",
            "1, false, NONE",
            "0, false, NONE"
    })
    void 로또_등수_계산(int matchCount, boolean bonusMatched, Rank expectedRank) {
        List<Integer> lottoNumbers = generateTicketNumbers(matchCount, bonusMatched);
        Lotto lottoTicket = new Lotto(lottoNumbers);

        Rank rank = RankCalculator.calculateRank(lottoTicket, WINNING_NUMBERS, BONUS_NUMBER);

        assertThat(rank).isEqualTo(expectedRank);
    }

    private List<Integer> generateTicketNumbers(int matchCount, boolean bonusMatched) {
        List<Integer> baseNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        List<Integer> ticketNumbers = getMatchingNumbers(baseNumbers, matchCount);
        addBonusNumberIfMatched(ticketNumbers, bonusMatched);
        addExtraNumbers(ticketNumbers);

        return ticketNumbers;
    }

    private List<Integer> getMatchingNumbers(List<Integer> baseNumbers, int matchCount) {
        return new ArrayList<>(baseNumbers.subList(0, matchCount));
    }

    private void addBonusNumberIfMatched(List<Integer> ticketNumbers, boolean bonusMatched) {
        if (bonusMatched && !ticketNumbers.contains(BONUS_NUMBER)) {
            ticketNumbers.add(BONUS_NUMBER);
        }
    }

    private void addExtraNumbers(List<Integer> ticketNumbers) {
        int extraNumber = 8;
        while (ticketNumbers.size() < 6) {
            if (!WINNING_NUMBERS.contains(extraNumber) && extraNumber != BONUS_NUMBER) {
                ticketNumbers.add(extraNumber);
            }
            extraNumber++;
        }
    }

}
