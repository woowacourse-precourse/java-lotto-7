package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int buget;
        List<Lotto> severalLottos = new ArrayList<>();
        int lottoCount;
        int bonusNumber;
        String winningNumbers;

        System.out.println("구입금액을 입력해 주세요.");
        buget = Integer.parseInt(Console.readLine());
        System.out.println();

        lottoCount = buget / 1000;

        for (int i = 0; i < lottoCount; i++) {
            severalLottos.add(new Lotto());
        }
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            System.out.println(severalLottos.get(i).getNumbers());
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningList = Conversion.parseInput(Console.readLine());

        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();

        winningCount.calculatePrizes(severalLottos,winningList,bonusNumber);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n",LottoRank.THREE_MATCH.getCount());
        System.out.printf("4개 일치 (50,000원) - %d개\n",LottoRank.FOUR_MATCH.getCount());
        System.out.printf("5개 일치 (1,500,000원) - %d개\n",LottoRank.FIVE_MATCH.getCount());
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",LottoRank.FIVE_MATCH_BONUS.getCount());
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n",LottoRank.SIX_MATCH.getCount());

        result.profitRate(buget);
        Console.close();// TODO: 프로그램 구현
    }
}
