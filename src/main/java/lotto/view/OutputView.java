package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;

import java.util.List;
import java.util.Map;

import static lotto.constant.NumberConstant.*;

public class OutputView {

    public void inputLottoMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void inputWinningNumber() {
        System.out.printf("%n당첨 번호를 입력해 주세요.%n");
    }

    public void inputBonusNumber() {
        System.out.printf("%n보너스 번호를 입력해 주세요.%n");
    }

    public void purchaseLottoAmount(int amount) {
        System.out.printf("%n%d개를 구매했습니다.%n", amount / LOTTO_PRICE);
    }

    public void purchaseLottoNumbers(Lottos lottos) {
        List<Lotto> purchaseLottos = lottos.getLottos();
        purchaseLottos.forEach(l -> System.out.println(l.toString()));
    }

    public void winningDetails(Map<Prize, Integer> matchResult) {
        System.out.printf("%n당첨 통계%n");
        System.out.printf("---%n");

        matchResult.entrySet().stream()
                .filter(entry -> entry.getKey() != Prize.NOTHING)
                .sorted(Map.Entry.comparingByKey())
                .forEach(OutputView::printDetails);
    }

    private static void printDetails(Map.Entry<Prize, Integer> entry) {
        Prize prize = entry.getKey();

        String matchDescription = getMatchDescription(prize);

        System.out.printf("%s (%,d원) - %d개%n",
                matchDescription,
                entry.getKey().getPrizeMoney(),
                entry.getValue());
    }

    private static String getMatchDescription(Prize prize) {
        String matchDescription = prize.getMatchCount() + "개 일치";

        if (prize == Prize.SECOND) {
            matchDescription = "5개 일치, 보너스 볼 일치";
        }
        return matchDescription;
    }

    public void earnRate(double earnRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", earnRate);
    }
}
