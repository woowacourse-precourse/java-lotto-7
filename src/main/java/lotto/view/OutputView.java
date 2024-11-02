package lotto.view;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public static void printPurchaseAmountMessage(int count){
        System.out.println("\n"+count+PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printUserLotto(List<List<Integer>> lottoNumbers){
        for(List<Integer> lotto:lottoNumbers){
            System.out.println(lotto);
        }
    }
}
