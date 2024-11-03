package lotto;

import static lotto.LottoConstants.LOTTO_PRICE;
import static lotto.LottoConstants.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        int lottoCount;
        List<Lotto> lottos = new ArrayList<>();
        int totalPrice = 0;

        // 로또 구매
        int amount = InputHandler.getPurchaseAmount();
        lottoCount = amount / LOTTO_PRICE;

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = RandomMaker.generateLottoNumbers(NUMBER_COUNT);
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();

        // 당첨번호 입력
        WinningNumbers winningNumbers = InputHandler.getWinningNumbers();

        // EnumMap으로 등수 갯수 계산
        Map<Rank, Integer> rankCountMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCountMap.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            Rank rank = LottoChecker.check(lotto, winningNumbers);
            rankCountMap.put(rank, rankCountMap.get(rank) + 1);
            totalPrice += rank.getPrize();
        }

        // 결과 출력
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            System.out.print(rank.getMatchCount());
            System.out.print("개 일치");
            if (rank.isRequireBonus()) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.print(" (" + String.format("%,d", rank.getPrize()) + "원)");
            System.out.println(" - " + rankCountMap.get(rank) + "개");
        }

        System.out.println("총 수익률은 " + String.format("%.1f", (double) totalPrice / amount * 100) + "%입니다.");
    }
}
