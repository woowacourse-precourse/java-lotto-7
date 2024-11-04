package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        LottoGenerator lottoGenerator = new LottoGenerator(amount); //1000단위 입력 확인
        TotalLotto totalLotto = new TotalLotto(lottoGenerator.generateTotalLotto());

        System.out.println(lottoGenerator.lottoCount + "개를 구매했습니다.");
        totalLotto.getLottos().stream()
                .forEach(lotto -> System.out.println(lotto.getNumbers().toString()));

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> hitNumbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        System.out.println("당첨 통계");
        System.out.println("---");
        HitLotto hitLotto = new HitLotto(hitNumbers, bonusNumber);

        Map<Rank, Integer> hitDetails = PlayLotto.getHitDetails(totalLotto, hitLotto);
        hitDetails.entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.LAST_PLACE)
                .forEach(entry -> {
                    if (entry.getKey() == Rank.SECOND_PLACE) {
                        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                                entry.getKey().getMatchingCount(),
                                getFormattingPrice(entry.getKey().getWinningPrice()),
                                entry.getValue());
                        return;
                    }
                    System.out.printf("%d개 일치 (%s원) - %d개\n",
                            entry.getKey().getMatchingCount(),
                            getFormattingPrice(entry.getKey().getWinningPrice()),
                            entry.getValue());
                });

        long winningAmount = PlayLotto.getHitAmount(hitDetails);
        double lottoYield=PlayLotto.getLottoYield(winningAmount, amount);
        System.out.println("총 수익률은 "+lottoYield+"%입니다.");
    }
    private static String getFormattingPrice(int winningPrice) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(winningPrice);
    }





}
