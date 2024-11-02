package lotto.view;

import lotto.constant.LottoGuide;

import java.util.List;

public class OutputView {
    public static void printPriceGuide(){
        System.out.println(LottoGuide.PRICE_GUIDE.getMessage());
    }

    public static void printPurchaseCount(int count){
        System.out.printf(LottoGuide.PURCHASE_COUNT.getMessage(), count);
        System.out.println();
    }

    public static void printLottoTicket(List<Integer> lottoTicket){
        System.out.println(lottoTicket);
    }

    public static void printWinningNumberGuide(){
        System.out.println(LottoGuide.WINNING_NUMBER_GUIDE.getMessage());
    }

    public static void printBonusNumberGuide(){
        System.out.println(LottoGuide.BONUS_NUMBER_GUIDE.getMessage());
    }

    public static void changeLine(){
        System.out.println();
    }
}
