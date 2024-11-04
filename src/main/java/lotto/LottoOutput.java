package lotto;

import java.util.List;

public class LottoOutput {
    public void printLottoCount(int lottoQuantity) {
        System.out.println("\n" + lottoQuantity + "개를 구매했습니다.");
    }

    public void printUserLottoNumbers(List<List<Integer>> allUserLottoNumbers) {
        for (List<Integer> userLottoNumbers : allUserLottoNumbers) {
            System.out.println(userLottoNumbers);
        }
    }

    public void printResults(LottoMatcher lottoMatcher) {
        int[] matchCounts = lottoMatcher.getMatchCounts();

        System.out.println("3개 일치 (5,000원) - " + matchCounts[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCounts[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts[4] + "개");
    }
}
