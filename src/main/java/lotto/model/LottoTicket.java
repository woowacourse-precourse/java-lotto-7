package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.util.NumGenerator;

public class LottoTicket {

    private final List<Lotto> lottoTicket;

    public LottoTicket(int ticketCount, NumGenerator generator) {
        lottoTicket = new ArrayList<Lotto>();
        generateLotto(ticketCount, generator);
    }

    private void generateLotto(int ticketCount, NumGenerator generator) {
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto(generator.generate());
            lottoTicket.add(lotto);
        }
    }

    public List<String> getPrintFormNumbers() {
        List<String> printForms = new ArrayList<>();
        lottoTicket.stream()
            .forEach(lotto -> printForms.add(lotto.toString()));
        return printForms;
    }

    public Map<Rank, Integer> getResult(Lotto winningNumber, int bonusNumber) {
        Map<Rank, Integer> result = Rank.makeRankResult();
        for (Lotto lotto : lottoTicket) {
            int countNumber = lotto.countContainNumber(winningNumber);
            boolean needBonusNumber = false;
            if (countNumber == 5) {
                needBonusNumber = lotto.hasBonusNumber(bonusNumber);
            }
            Rank rank = Rank.getRank(countNumber, needBonusNumber);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }
}
