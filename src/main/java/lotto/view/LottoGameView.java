package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.dto.LottoRankDto;

public class LottoGameView {

    public int requestCost() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 정수를 입력해야 합니다.");
            return requestCost();
        }
    }

    public void displayLottoAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void displayLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String numbers = lotto.getNumbers()
                    .stream()
                    .map(LottoNumber::getValue)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));

            System.out.println(numbers);
        }
        System.out.println();
    }

    public List<Integer> requestWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return makeLottoNumbers();
    }

    public int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 정수를 입력해야 합니다.");
            return requestBonusNumber();
        }
    }

    private List<Integer> makeLottoNumbers() {
        String input = Console.readLine();
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 정수를 입력해야 합니다.");
            return makeLottoNumbers();
        }
    }

    public void displayStatistics(List<LottoRankDto> statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        statistics.sort((o1, o2) -> Integer.compare(o1.getPrize(), o2.getPrize()));

        for (LottoRankDto stat : statistics) {
            displayRankStatistic(stat);
        }
    }

    private static void displayRankStatistic(LottoRankDto lottoRankDto) {
        if (lottoRankDto.getMatchCount() == 0) {
            return;
        }

        System.out.println(
                lottoRankDto.getMatchCount() + "개 일치" + (lottoRankDto.isBonusMatch() ? ", 보너스 볼 일치" : "") +
                        " (" + NumberFormat.getInstance().format(lottoRankDto.getPrize()) + "원) - "
                        + lottoRankDto.getAmount()
                        + "개");
    }

    public void displayProfit(Double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
