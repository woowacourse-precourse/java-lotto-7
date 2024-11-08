package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    private static final String INPUT_MONEY_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM= "보너스 번호를 입력해 주세요.";

    public static void main(String[] args) {
        try{
            Customer customer = inputPurchase();
            LottoNumberFormatter formatter = new LottoNumberFormatter();

            List<Integer> winningNums = inputWinningNums(formatter);
            int bonusNum = inputBonusNum(formatter);

            try{
                formatter.hasDuplicateNum(winningNums, bonusNum);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                winningNums = inputWinningNums(formatter);
                bonusNum = inputBonusNum(formatter);
            }

            LottoChecker lottoChecker = new LottoChecker(winningNums, bonusNum);
            lottoChecker.lottoCheck(customer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Customer inputPurchase() {
        try {
            System.out.println(INPUT_MONEY_AMOUNT);
            String purchase = Console.readLine();
            System.out.println();

            Customer customer = new Customer();
            customer.buyLottos(purchase);
            return customer;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchase();
        }
    }

    public static List<Integer> inputWinningNums(LottoNumberFormatter formatter) {
        try {
            System.out.println(INPUT_WINNING_NUMS);
            String inputWinningNumbers = Console.readLine();
            System.out.println();

            List<Integer> winningNums = formatter.splitInput(inputWinningNumbers);
            formatter.hasDuplicateWinningNum(winningNums);
            return winningNums;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNums(formatter);
        }
    }

    public static int inputBonusNum(LottoNumberFormatter formatter) {
        try {
            System.out.println(INPUT_BONUS_NUM);
            String inputBonusNum = Console.readLine();
            System.out.println();

            return formatter.convertToBonusNum(inputBonusNum);
        } catch (IllegalArgumentException e) {
            return inputBonusNum(formatter);
        }
    }
}
