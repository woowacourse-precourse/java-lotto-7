package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final String INPUT_PURCHASE = "구입금액을 입력해 주세요.";
    private static final Integer LOTTO_PRICE = 1000;
    private static final String WHAT_CHOOSED_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String WHAT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WRONG_BONUS_NUM = "보너스 번호는 당첨번호중에 될 수 없습니다.";

    private static final String INVALID_INPUT_MESSAGE = "[ERROR] 구입금액은 숫자여야 합니다.";
    private static final String NOT_DIVISIBLE_BY_THOUSAND_MESSAGE = "[ERROR] 구입금액은 천 단위여야 합니다.";
    private static final String WRONG_BONUS_NUM_MESSAGE = "[ERROR] 보너스 번호는 당첨번호 중에 포함될 수 없습니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money = 0;

        while (money<=0){
            try {
                System.out.println(INPUT_PURCHASE);
                String inputMoney = Console.readLine();
                if (!isValidInput(inputMoney)) {
                    throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
                }
                if(!isInputdivideThousands(inputMoney)){
                    throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND_MESSAGE);
                }
                money = Integer.parseInt(inputMoney);
            } catch (IllegalArgumentException e){
                System.out.print(e.getMessage());
            }
        }



        int toPurchaseSize = money / LOTTO_PRICE;

        List<List<Integer>> purchaseLotto = Lotto.generatePurchaseLotto(toPurchaseSize);
        Lotto.printPurchaseLotto(purchaseLotto);

        System.out.println(WHAT_CHOOSED_NUMBERS);
        String nums = Console.readLine();

        String[] choosedNumbers = nums.split(",");
        List<Integer> num = new ArrayList<>();
        for (String c : choosedNumbers) {
            num.add(Integer.parseInt(c));
        }
        Lotto lotto = new Lotto(num);

        System.out.println(WHAT_BONUS_NUMBER);
        String bonusNum = Console.readLine();
        Integer bonusNumber = Integer.parseInt(bonusNum);

        isWrongBonusNum(bonusNumber, num);

        Qualifier result = new Qualifier(lotto.getNumbers(), bonusNumber);
        List<Integer> history = result.analysis(purchaseLotto);
        result.printResult(money, history);

    }

    public static boolean isInputdivideThousands(String inputMoney) {
        int money = Integer.parseInt(inputMoney);

        if (money % LOTTO_PRICE == 0 && money > 0) {
            return true;
        }
        return false;
    }

    public static boolean isValidInput(String input){
        return input.matches("\\d+");
    }

    public static void isWrongBonusNum(Integer bonusNumber, List<Integer> num){
        if(num.contains(bonusNumber)){
            throw new IllegalArgumentException(WRONG_BONUS_NUM);
        }
    }
}
