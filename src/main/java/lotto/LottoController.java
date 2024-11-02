package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.*;

public class LottoController {
    private static final DecimalFormat formatter = new DecimalFormat("###,###");
    static final int LOTTO_PRICE = 1000;

    public Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<Lotto> purchaseLotto(String cost) {
        validateCost(cost);
        int count = getCount(cost);
        return createLottos(count);
    }

    public Lotto makeWinningLotto(String input){
        return new Lotto(Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList());
    }
    public LottoRankGroups makeRankGroups(List<Lotto> lottos, Lotto winningLotto, String bonus){
        int bounsNumber = Integer.parseInt(bonus);
        validateBonus(winningLotto, bounsNumber);
        return new LottoRankGroups(LottoRank.getRanks(lottos,winningLotto,bounsNumber));
    }

    private static int getCount(String cost) {
        return (int)(Long.parseLong(cost) / LOTTO_PRICE);
    }

    private static void validateCost(String cost) {
        if (Long.parseLong(cost) % LOTTO_PRICE != 0) throw new IllegalArgumentException("Invalid cost");
    }
    private static void validateBonus(Lotto winningLotto, Integer bonus) {
        if(winningLotto.isBonusBallMatch(bonus)) throw new IllegalArgumentException("Invalid bonus");
    }

    public List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    public void printLottoStatus(List<Lotto> lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        lottos.stream()
                .map(Lotto::numbersToString)
                .forEach(System.out::println);
    }

    public void printWinningDetails(LottoRankGroups groups) {
        for (LottoRank rank : LottoRank.values()) {
            System.out.println(String.format("%s (%s원) - %s개",
                    getRankCondition(rank), getRankPrice(rank), getRankCount(groups, rank)));
        }
    }

    public void printRateOfReturn(LottoRankGroups groups) {
        System.out.println("총 수익률은 " + Math.round((double) groups.getAllPrize() / (groups.getRankSize() * LOTTO_PRICE) * 1000) / 10.0 + "%입니다.");
    }

    private List<String> lottosToString(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::numbersToString)
                .toList();
    }

    private String getRankCondition(LottoRank rank) {
        return rank.getCondition();
    }

    private String getRankPrice(LottoRank rank) {
        return formatter.format(rank.getPrice());
    }

    private String getRankCount(LottoRankGroups groups, LottoRank targetRank) {
        return groups.getCount(targetRank).toString();
    }


}


