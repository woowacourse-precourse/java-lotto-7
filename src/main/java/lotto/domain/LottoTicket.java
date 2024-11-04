package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoConst;
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
            Rank rank = findRank(winningNumber, bonusNumber, lotto);
            result.put(rank, result.get(rank) + LottoConst.INCREMENT_BY_ONE);
        }
        return result;
    }

    private static Rank findRank(Lotto winningNumber, int bonusNumber, Lotto lotto) {
        int countNumber = lotto.countContainNumber(winningNumber);
        boolean needBonusNumber = lotto.needBonusNumber(countNumber, bonusNumber);
        Rank rank = Rank.getRank(countNumber, needBonusNumber);
        return rank;
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }
}
