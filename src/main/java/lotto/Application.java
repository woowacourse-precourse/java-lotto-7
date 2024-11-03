package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        Input input = new Input(new InputValidator());

        Integer amount = input.getAmountWithMessage();
        Integer count = amount/1000;
        Lotto winNumberLotto = input.getWinNumberLotto();
        WinLotto winLotto = input.getBonusNumber(winNumberLotto);
        LottoService lottoService = new LottoService(new LottoGenerator(new RandomStrategy()));
        Lottos lottos = lottoService.createLottos(count);

        System.out.println(count+"개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            String string = Arrays.toString(lotto.getNumbers().toArray());
            System.out.println(string);
        }


        List<Rank> ranks = lottos.compareWithWinLotto(winLotto);

        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
        for (Rank rank : ranks) {
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + rankCounts.get(Rank.FIFTH) +"개");
        System.out.println("4개 일치 (50,000원) - " + rankCounts.get(Rank.FOURTH) +"개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCounts.get(Rank.THIRD) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCounts.get(Rank.SECOND) +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCounts.get(Rank.FIRST) +"개");


        // 수익률을 계산
        double revenue = lottoService.calculateRevenue(ranks, amount);
        System.out.println("총 수익률은 " + revenue+"%입니다.");
    }
}
