package lotto.system.formater.winning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.system.utils.PrizeType;
import lotto.system.unit.LottoTicket;
import lotto.system.unit.LottoNumber;

public class LottoWinningAnalyzer {

    public static Map<PrizeType, Integer> analyzeWinningStatistics(
            /** 유저가 발행 받은 티켓들 **/ List<LottoTicket> issueTickets,
            /** 당첨 로또 번호 리스트 **/ List<Integer> winningNumbers,
            /** 당첨 보너스 번호 **/ int bonusNumber) {

        Map<PrizeType, Integer> statistics = new HashMap<>();

        for (PrizeType prizeType : PrizeType.values()) {
            statistics.put(prizeType, 0);
        }

        for (LottoTicket issueTicket : issueTickets) {
            PrizeType prizeType = match(issueTicket, winningNumbers, bonusNumber);
            statistics.put(prizeType, statistics.get(prizeType) + 1);
        }

        return statistics;
    }

    public static PrizeType match(
            /** 유저가 발행 받은 티켓 한 장 **/ LottoTicket issueTicket,
            /** 당첨 로또 번호 리스트 **/ List<Integer> winningNumbers,
            /** 당첨 보너스 번호 **/ int bonusNumber) {

        int count = matchLotto(issueTicket, winningNumbers);
        boolean matchBonus = matchBonus(issueTicket, bonusNumber);

        if (matchBonus && count == 5) {
            return PrizeType.getTypeByCode(6);
        }
        else if (count == 6) {
            return PrizeType.getTypeByCode(7);
        }
        else {
            return PrizeType.getTypeByCode(count);
        }
    }

    public static int matchLotto(LottoTicket issueTicket, List<Integer> winningNumbers) {
        int count = 0;
        for (LottoNumber number : issueTicket.getTicket()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    public static boolean matchBonus(LottoTicket issueTicket, int bonusNumber) {
        return issueTicket.getTicket().contains(bonusNumber);
    }
}
