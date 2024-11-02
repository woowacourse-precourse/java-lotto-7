package lotto.view;

import lotto.constant.ViewConstants;
import java.util.List;

public class OutputView {
    public static void printPurchaseCount(int count){
        System.out.println(count + ViewConstants.BOUGHT_LOTTO_MESSAGE.getMessage());
    }

    public static void printLottoNumbers(List<String> lottos){
        for(String lotto: lottos){
            System.out.println(lotto);
        }
    }

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
