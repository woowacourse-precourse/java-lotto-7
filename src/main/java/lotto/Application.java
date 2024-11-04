package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.LottoRank.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
        int cnt = amount / 1000;

        System.out.println(cnt + "개를 구매했습니다.");
        List<Lotto> lottos = generateLotto(cnt);
        printLotto(lottos);

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> input = Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt).toList();
        Lotto winning = new Lotto(input);

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = Integer.parseInt(Console.readLine());

        System.out.println("당첨 통계");
        System.out.println("---");

        Map<LottoRank, Integer> cntMap = init();

        for(Lotto lotto : lottos) {
            LottoRank lottoRank = matchLotto(lotto, winning, bonusNum);
            put(cntMap, lottoRank);
        }

        for(LottoRank lottoRank : cntMap.keySet()) {
            String choiceText = lottoRank.chooseText(lottoRank, cntMap.get(lottoRank));
            System.out.println(choiceText);
        }

        System.out.println("총 수익률은 " + getPercentage(amount, cntMap) + "%입니다.");
    }

    private static double getPercentage(int amount, Map<LottoRank, Integer> cntMap) {
        int sum = 0;
        for(LottoRank lottoRank : cntMap.keySet()) {
            sum += cntMap.get(lottoRank) * lottoRank.getPrize();
        }

        return (double) sum / amount;
    }

    private static EnumMap<LottoRank, Integer> init(){
        EnumMap<LottoRank, Integer> map = new EnumMap<>(LottoRank.class);
        map.put(FIFTH, 0);
        map.put(FOURTH, 0);
        map.put(THIRD, 0);
        map.put(SECOND, 0);
        map.put(FIRST, 0);
        return map;
    }

    private static LottoRank matchLotto(Lotto lotto, Lotto answer, int bonusNum) {
        int matchCnt = (int) lotto.getNumbers().stream()
                .filter(answer.getNumbers()::contains)
                .count();
        boolean hasBonus = lotto.getNumbers().contains(bonusNum);
        return LottoRank.getRank(matchCnt, hasBonus);
    }

    private static void put(Map<LottoRank, Integer> map, LottoRank rank){
        if(rank != LottoRank.NONE) {
            map.put(rank, map.get(rank) + 1);
        }
    }





    private static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.print();
        }
    }

    private static Lotto buyLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private static List<Lotto> generateLotto(int cnt){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < cnt; i++) {
            lottos.add(buyLotto());
        }
        return lottos;
    }
}
