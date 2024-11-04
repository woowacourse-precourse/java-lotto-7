package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRankGroup {
    private final List<LottoRank> ranks;

    public LottoRankGroup(List<LottoRank> ranks) {
        this.ranks = ranks;
    }

    public static LottoRankGroup of(LottoGroup lottoGroup, Lotto winner, Integer bonusNumber) {
        return new LottoRankGroup(lottoGroup.getLottos()
                .stream()
                .map(lotto -> LottoRank.of(lotto, winner, bonusNumber))
                .toList());
    }

    public List<String> getInstructions() {
        List<String> instructions = new ArrayList<>();
        for (LottoRank rank : ranks.reversed()) {
            if (rank == LottoRank.NONE) continue;
            instructions.add(rank.getConditionInstruction() + countInstruction(rank));
        }
        return instructions;
    }

    public double getRateOfRevenue(){
        return Math.round(turnToPercentage((double)revenue()/cost()) * 10) / 10.0;
    }

    private double turnToPercentage(double number){
        return number*100;
    }

    private long cost(){
        return (long) Lotto.PRICE * ranks.size();
    }


    private long revenue() {
        long revenue = 0;
        for(LottoRank rank : ranks) {
            revenue += rank.getPrizeMoney() * getCount(rank);
        }
        return revenue;
    }

    private String countInstruction(LottoRank rank) {
        return String.format(" - %d개", getCount(rank));
    }

    private int getCount(LottoRank rank) {
        return ranks.stream()
                .filter(r -> r == rank)
                .toList()
                .size();
    }

    // TODO
    //  - [x] 로또 등수를 이용하여 통계를 출력한다.
    //  - [x] 로또 등수를 이용하여 수익율을 계산한다.
    //  - [x] 로또 수익율 출력한다.
    //
}
