package lotto.view;

import java.util.Map;
import lotto.enums.WinningPrizeMessage;
import lotto.enums.Prize;
import lotto.model.LottoCollection;

public class OutputView {

    public static void outputErrorMessage(Exception e) {
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
    }

    public static void outputLottoCollection(LottoCollection lottoCollection) {
        // TODO: message 상수로 빼기
        System.out.println();
        System.out.println(lottoCollection.getLottoCount() + "개를 구매했습니다.");
        System.out.println(lottoCollection.toString());
    }

    public static void outputWinningResult(Map<Integer, Long> lottoWinningResult){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        StringBuilder sb = new StringBuilder();
        Prize[] prizes = Prize.values();
        for(int i = 1; i < prizes.length; ++i) {
            Prize prize = prizes[i];
            sb.append(WinningPrizeMessage.valueOf(prize.name()).getMessage());
            sb.append(lottoWinningResult.getOrDefault(prize.getPrize(), 0L));
            sb.append("개\n");
        }
        System.out.println(sb.toString());
    }

}
