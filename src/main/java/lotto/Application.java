package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<Integer> winningNumber;
        String purchaseAmount;
        while (true) {
            try {
                purchaseAmount = PurchaseAmountValidator.validate(Console.readLine());
                winningNumber = stringToList(Console.readLine());
                Lotto lotto = new Lotto(winningNumber);
                String bonusNumber = Console.readLine();
                BonusNumberValidator.validate(bonusNumber, winningNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        LottoGenerator lottoGenerator = new LottoGenerator(Integer.parseInt(purchaseAmount) / 1000);
        LottoCalculator lottoCalculator = new LottoCalculator(LottoGenerator.getGeneratedTickets(), winningNumber,
                BonusNumberValidator.getBonusNumber(), Integer.parseInt(purchaseAmount));

        lottoCalculator.displayResults();



    }

    static List<Integer> stringToList(String str) {
        return Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
