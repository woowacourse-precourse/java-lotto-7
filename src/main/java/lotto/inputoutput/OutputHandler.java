package lotto.inputoutput;

import lotto.model.Lotto;
import lotto.model.LottoList;

public abstract class OutputHandler {
    public static void printLottoStatus(LottoList lottoList) {
        System.out.println(lottoList.getLottoList().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }
    }
    public static void printLottoResult(double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
