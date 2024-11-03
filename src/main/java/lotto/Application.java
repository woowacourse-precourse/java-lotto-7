package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.LottoConstants.LOTTO_PRICE;
import static lotto.LottoConstants.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.Arrays;
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
//        System.out.println("구입금액을 입력해 주세요.");
//        try {
//            amount = Integer.parseInt(readLine());
//            System.out.println();
//        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
//        }
//        if (amount < 0) {
//            throw new IllegalArgumentException("[ERROR] 0이상의 값을 입력해야 합니다.");
//        }
//        if (amount % LOTTO_PRICE != 0) {
//            throw new IllegalArgumentException("[ERROR] 1000원으로 나눠 떨어지는 값을 입력해야 합니다.");
//        }
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
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] tokens = readLine().split(",");
        List<Integer> winningNumbersNoBonus = Arrays.stream(tokens).map(token -> {
            try {
                return Integer.parseInt(token.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 쉼표로 구분된 숫자만 입력해야 합니다.");
            }
        }).toList();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());
        System.out.println();

        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersNoBonus, bonusNumber);

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
