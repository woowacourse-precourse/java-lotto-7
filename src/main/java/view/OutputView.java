package view;

import lotto.Lotto;
import lotto.LottoResult;

import java.util.ArrayList;

public class OutputView {
    private static final String printLottoCount = "개를 구매했습니다.";
    private static final String printResultLine = "당첨 통계\n---";

    public void printLottoNumbers(int LottoCount, ArrayList<Lotto> lottos){
        System.out.println(LottoCount + printLottoCount);
        for(Lotto lotto : lottos){
            System.out.println(lotto.toString());
        }
    }

    public void printLottoResult(String result){
        System.out.println(printResultLine);
        System.out.println(result);
    }
}
