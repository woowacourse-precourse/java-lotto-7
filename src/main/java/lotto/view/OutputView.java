package lotto.view;

import lotto.constant.Rank;
import lotto.model.Lotto;

import java.util.HashMap;
import java.util.List;

import static lotto.constant.OutPutMessage.*;

public class OutputView {

    public void printPurchasePriceMessage(){
        System.out.println(PURCHASE_PRICE_MESSAGE.getMessage());
    }

    public void printPurchaseLottoQuantity(Integer purchaseQuantity){System.out.println(NEW_LINE.getMessage() + purchaseQuantity + PURCHASE_QUANTITY_MESSAGE.getMessage());}

    public void printLotto(List<Lotto> lottos){
        for(Lotto lotto: lottos){
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printWinningNumbersMessage(){System.out.println(WINNING_NUMBER_MESSAGE.getMessage());}

    public void printBonusNumberMessage(){System.out.println(NEW_LINE.getMessage()+BONUS_NUMBER_MESSAGE.getMessage());}

    public void printResult(HashMap<Rank, Integer> result){
        System.out.println();
        System.out.println(WINNING_STATISTICS.getMessage());

        for (Rank rank : Rank.values()) {
            int count = result.get(rank);
            System.out.print(rank.getCount() + String.valueOf(MATCHING_AMOUNT_MESSAGE.getMessage()));
            if (rank.equals(Rank.SECOND)) System.out.print(MATCHING_BONUS_MESSAGE.getMessage());
            System.out.println(LEFT_PARENTHESIS.getMessage() + rank.getPrize() + RIGHT_PARENTHESIS.getMessage() + count + AMOUNT.getMessage());
        }
    }

    public void printProfitRate(double profitRate){
        System.out.println(String.format(String.valueOf(TOTAL_PROFIT_RATE_MESSAGE.getMessage()), profitRate));
    }
}
