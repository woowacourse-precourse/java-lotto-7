package print;

import java.util.List;

public class InfoPrinter {
    public void purchasedLottoInfoPrint(int sum, List<List<Integer>> lottos) {
        System.out.println(sum + "개를 구매했습니다");
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    /**
     * 차후에 변경할 메서드입니다. 존재의 의미를 잊지 않기 위해 임시로 구현해두었습니다.
     */
    public void winningResultPrint(int matchCount, boolean isBonusMatch) {
        System.out.println(matchCount + "개 일치" + (isBonusMatch ? ", 보너스 볼 일치" : ""));
    }
}
