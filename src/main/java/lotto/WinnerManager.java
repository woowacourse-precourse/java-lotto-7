package lotto;

import constant.Rank;
import input.BonusNumberInputProcessor;
import input.LottoWinnerNumberInputProcessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinnerManager {

    private final LottoWinnerNumberInputProcessor lottoWinnerNumberInputProcessor;
    private final BonusNumberInputProcessor bonusNumberInputProcessor;

    private final List<Rank> rankAggregation;

    private Map<Rank, Long> rankStatistic;
    private Lotto winnerLotto;
    private Integer bonusNumber;


    WinnerManager(LottoWinnerNumberInputProcessor lottoWinnerNumberInputProcessor,
            BonusNumberInputProcessor bonusNumberInputProcessor) {
        this.lottoWinnerNumberInputProcessor = lottoWinnerNumberInputProcessor;
        this.bonusNumberInputProcessor = bonusNumberInputProcessor;
        this.rankAggregation = new ArrayList<>();
        this.rankStatistic = new HashMap<>();
    }

    public void registerWinnerLotto() {
        List<Integer> registedLottoNumber;
        while (true) {
            registedLottoNumber = lottoWinnerNumberInputProcessor.putValue();
            registerBonusNumber();
            try {
                winnerLotto = new Lotto(registedLottoNumber, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void registerBonusNumber() {
        bonusNumber = bonusNumberInputProcessor.putValue();
    }

    public void rankStatistic() {
        rankStatistic = rankAggregation.stream()
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    public void printRankStatistic() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Map.Entry<Rank, Long> entry : rankStatistic.entrySet()) {
            System.out.println(entry.getKey().showRankCondition() + entry.getValue() + "개");
        }
    }

    public void rankClassification(ArrayList<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            Integer matchCount = lottoTicket.computeMatchNumberCount(winnerLotto);
            boolean bonusMatch = lottoTicket.matchBonusNumber(bonusNumber);
            rankAggregation.add(rankingDecision(matchCount, bonusMatch));
        }
    }

    public Rank rankingDecision(Integer matchCount, boolean bonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.checkRank(matchCount, bonusMatch)) {
                return rank;
            }
        }
        return Rank.UN_RANK;
    }

}
