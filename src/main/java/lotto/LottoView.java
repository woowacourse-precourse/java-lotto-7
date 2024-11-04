package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LottoView {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printResult(int[] resultCnt, double profitRate) {
        NumberFormat numberFormat = NumberFormat.getInstance();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(LottoRank.FIFTH.getMatchCount() + "개 일치 (" + numberFormat.format(LottoRank.FIFTH.getPrize()) + "원) - " + resultCnt[4] + "개");
        System.out.println(LottoRank.FOURTH.getMatchCount() + "개 일치 (" + numberFormat.format(LottoRank.FOURTH.getPrize()) + "원) - " + resultCnt[3] + "개");
        System.out.println(LottoRank.THIRD.getMatchCount() + "개 일치 (" + numberFormat.format(LottoRank.THIRD.getPrize()) + "원) - " + resultCnt[2] + "개");
        System.out.println(LottoRank.SECOND.getMatchCount() + "개 일치, 보너스 볼 일치 (" + numberFormat.format(LottoRank.SECOND.getPrize()) + "원) - " + resultCnt[1] + "개");
        System.out.println(LottoRank.FIRST.getMatchCount() + "개 일치 (" + numberFormat.format(LottoRank.FIRST.getPrize()) + "원) - " + resultCnt[0] + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
