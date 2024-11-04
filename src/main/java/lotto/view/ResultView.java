package lotto.view;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printLottoSetCount(int lottoSetCount) {
        System.out.println(lottoSetCount+"개를 구매했습니다.");
    }

    public static void printMatchResult(Map<String, Integer> matchResults) {
        System.out.println("3개 일치 (5,000원) - " + matchResults.get("3"));
        System.out.println("4개 일치 (50,000원) - " + matchResults.get("4"));
        System.out.println("5개 일치 (1,500,000원) - " + matchResults.get("5"));
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchResults.get("5+Bonus"));
        System.out.println("6개 일치 (2,000,000,000원) - " + matchResults.get("6"));
    }
}
