package service;

import java.util.List;
import model.Lotto;

public class OutputService {

    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";

    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";

    public OutputService(){}

    public void printPurchaseCountMessage(int purchaseCount){
        System.out.println(purchaseCount + PURCHASE_COUNT_MESSAGE);
    }

    public void printWinningStatisticsMessage(){
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }

    public void printLottoNumbers(List<Lotto> purchasedLottos){
        for(var lotto : purchasedLottos){
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printWinningStatics(String lottoRankMessage, int winningCount){
        System.out.println(lottoRankMessage + winningCount);
    }
}
