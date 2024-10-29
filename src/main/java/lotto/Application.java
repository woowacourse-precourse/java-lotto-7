package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.converter.PurchaseCountConverter;

public class Application {
    public static void main(String[] args) {

        String inputPurchaseAmount = Console.readLine();

        PurchaseCountConverter purchaseCountConverter = new PurchaseCountConverter();
        int purchaseCount = purchaseCountConverter.getPurchaseCount(inputPurchaseAmount);
    }
}
