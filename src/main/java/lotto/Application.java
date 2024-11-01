package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = 0;
        Lotto winningNumbersLotto;
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchasePriceInput = Console.readLine();
            try {
                int purchasePrice = validatePurchasePrice(purchasePriceInput);

                if (purchasePrice % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위만 허용됩니다.");
                }

                purchaseAmount = purchasePrice / 1000;

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");
        List<Lotto> myLottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            myLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        printLottos(myLottos);


        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String[] winningNumbersInput = Console.readLine().split(",");
            List<Integer> winningNumbers = new ArrayList<>();
            try{
                if (winningNumbersInput.length != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.(쉼표(,)로 구분)");
                }

                for (String winningNumber : winningNumbersInput) {
                    int number = validateNumber(winningNumber);
                    winningNumbers.add(number);
                }

                winningNumbersLotto = new Lotto(winningNumbers);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumberInput = Console.readLine();
            try{
                int bonusNumber = validateBonusNumber(bonusNumberInput, winningNumbersLotto);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
    static int validatePurchasePrice(String purchasePriceInput) {
        try{
            return Integer.parseInt(purchasePriceInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위의 숫자만 허용됩니다.");
        }
    }

    static int validateNumber(String numberInput) {
        try{
            return Integer.parseInt(numberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.(쉼표(,)로 구분)");
        }
    }
    static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }
    static int validateBonusNumber(String bonusNumberInput, Lotto winningNumbersLotto) {
        try {
           int bonusNumber = Integer.parseInt(bonusNumberInput);

           if (bonusNumber < 1 || bonusNumber > 45) {
               throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
           }

           if (winningNumbersLotto.contains(bonusNumber)) {
               throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
           }

           return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }
}
