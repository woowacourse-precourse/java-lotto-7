package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoRankGroup {
    public static List<String> RANK_STATUS_INSTRUCION = List.of(
            "당첨 통계",
            "---"
    );
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

    public List<String> getRankInstructions() {
        List<String> instructions = new ArrayList<>(RANK_STATUS_INSTRUCION);
        for (LottoRank rank : Arrays.stream(LottoRank.values()).toList().reversed()) {
            if (rank == LottoRank.NONE) continue;
            instructions.add(rank.getConditionInstruction() + countInstruction(rank));
        }
        instructions.add(getRateOfRevenue());
        return instructions;
    }

    private String getRateOfRevenue(){
        return String.format("총 수익률은 %s입니다.",Math.round(turnToPercentage((double)revenue()/cost()) * 10) / 10.0 + "%");
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
