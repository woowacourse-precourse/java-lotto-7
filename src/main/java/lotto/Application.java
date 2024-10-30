package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.converter.PurchaseCountConverter;
import lotto.generator.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String inputPurchaseAmount = Console.readLine();

        PurchaseCountConverter purchaseCountConverter = new PurchaseCountConverter(inputPurchaseAmount);
        int purchaseCount = purchaseCountConverter.convert();

        List<RandomNumber> randomNumberList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            randomNumberList.add(RandomNumber.generate());
        }
    }
}
