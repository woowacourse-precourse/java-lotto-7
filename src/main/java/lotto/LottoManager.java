package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import lotto.DTO.TryCountDTO;
import lotto.DTO.VictoryInfoDTO;

public class LottoManager {
    private LinkedHashMap<Integer, List<Integer>> lottoTicket;
    private Lotto lotto;
    private int[] matchCounts;

    public LottoManager(TryCountDTO tryCountDTO) {
        lottoTicket = new LinkedHashMap<>();
        for (int i = 0; i < tryCountDTO.getTryCount(); i++) {
            List<Integer> list = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(list);
            lotto = new Lotto(list);
            lottoTicket.put(i, list);
        }
    }

    public int[] match(VictoryInfoDTO victoryInfoDTO) {
        List<Integer> victoryNumbers = victoryInfoDTO.getVictoryNumbers();
        LinkedHashMap<Integer, List<Integer>> userTickets = this.lottoTicket;
        int bonusNumber = victoryInfoDTO.getBonusNumber();

        matchCounts = new int[Rank.values().length];
        for (List<Integer> ticket : userTickets.values()) {
            int matchCount = countMatches(ticket, victoryNumbers);
            boolean bonusMatch = ticket.contains(bonusNumber);
            updateMatchCount(matchCounts, matchCount, bonusMatch);
        }
        return matchCounts;
    }

    private void updateMatchCount(int[] matchCounts, int matchCount, boolean bonusMatch) {
        int index = -1;

        if (matchCount == 3) {
            index = Rank.THREE.ordinal();
        }

        if (matchCount == 4) {
            index = Rank.FOUR.ordinal();
        }

        if (matchCount == 5) {
            if (bonusMatch) {
                index = Rank.FIVE_AND_BONUS.ordinal();
            }
            if (!bonusMatch) {
                index = Rank.FIVE.ordinal();
            }
        }

        if (matchCount == 6) {
            index = Rank.SIX.ordinal();
        }

        if (index != -1) {
            matchCounts[index]++;
        }
    }

    private int countMatches(List<Integer> ticket, List<Integer> victoryNumbers) {
        int matchCount = 0;
        for (int i : ticket) {
            if (victoryNumbers.contains(i)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public LinkedHashMap<Integer, List<Integer>> getLottoTicket() {
        return lottoTicket;
    }

    public double revenue(TryCountDTO tryCountDTO) {
        int totalPrizeMoney = 0;
        for (Rank rank : Rank.values()) {
            totalPrizeMoney += matchCounts[rank.ordinal()] * rank.getPrizeMoney();
        }
        double revenue = ((double) totalPrizeMoney / tryCountDTO.getBuyPrice()) * 100;
        return Math.round(revenue * 10.0) / 10.0;

    }
}
