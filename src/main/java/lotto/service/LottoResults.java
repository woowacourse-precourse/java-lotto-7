package lotto.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.SequencedMap;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

public class LottoResults {
    private final SequencedMap<Rank,Integer> lottoResults = new LinkedHashMap<>();

    public LottoResults(){
        initializeResults();
    }

    private void initializeResults(){
        for (Rank rank : Rank.values()) {
            lottoResults.put(rank,0);
        }
    }

    public long calculateTotalEarnings(){
        long totalEarnings = 0;
        for (Entry<Rank, Integer> entry : lottoResults.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalEarnings += rank.getPrize() * count;
        }
        return totalEarnings;
    }

    public void calculateResults(LottoTickets lottoTickets , WinningNumbers winningNumbers , BonusNumber bonusNumber){
        for (Lotto lottoTicket : lottoTickets.getLottoTickets()) {
            Rank rank = determineRank(winningNumbers,bonusNumber,lottoTicket);
            lottoResults.put(rank,lottoResults.get(rank)+1);
        }
    }

    private Rank determineRank(WinningNumbers winningNumbers,BonusNumber bonusNumber,Lotto lotto){
        int matchCount = calculateMatchCount(winningNumbers,lotto);
        boolean bonusMatch = lotto.contains(bonusNumber.getBonusNumber());
        return Rank.matchLotto(matchCount,bonusMatch);
    }

    private int calculateMatchCount(WinningNumbers winningNumbers, Lotto lotto) {
        int matchCount =0;
        List<Integer> winningNumber = winningNumbers.getWinningNumbers();
        for (Integer number : winningNumber) {
            if (winningNumber.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

}
