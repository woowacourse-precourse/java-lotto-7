package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.converter.PurchaseCountConverter;
import lotto.util.converter.WinningNumberConverter;
import lotto.domain.generator.RandomNumbers;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        String inputPurchaseAmount = Console.readLine();

        PurchaseCountConverter purchaseCountConverter = new PurchaseCountConverter(inputPurchaseAmount);
        int purchaseCount = purchaseCountConverter.convert();

        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.addRandomNumber(purchaseCount);

        String inputWinningNumber = Console.readLine();
        WinningNumberConverter winningNumberConverter = new WinningNumberConverter(inputWinningNumber);
        List<Integer> winningNumbers = winningNumberConverter.convert(); // 로또의 당첨 번호를 외부에서 가공해서 Lotto 클래스에 전달하는게 적절한가?
    }
}
