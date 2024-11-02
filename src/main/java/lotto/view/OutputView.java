package lotto.view;

import java.util.List;
import lotto.model.Result;

public class OutputView {

    public void printRanks(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getThreeCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getFourCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getFiveCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getBonusCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getSixCount() + "개");
    }

    public void printReturnRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rate * 100);
    }

    public void count(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLotto(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }
}
