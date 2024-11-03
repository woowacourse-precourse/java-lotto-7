package lotto;

import java.util.stream.Collectors;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String purchaseAmountInput = promptPurchaseAmount();
        LottoPurchaser lottoPurchaser = new LottoPurchaser(purchaseAmountInput);
        List<Lotto> purchasedLottos = lottoPurchaser.purchaseLotto();
        printPurchasedLottos(purchasedLottos);
        Lotto winningLotto = promptWinningLotto();
    }

    private static Lotto promptWinningLotto() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningLottoInput = readLine();
            try {
                List<Integer> winningLottoNumbers = Arrays.stream(winningLottoInput.split(",")).map(Integer::parseInt).collect(Collectors.toList());
                return new Lotto(winningLottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println("\n" + purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto purchasedLotto : purchasedLottos){
            List<Integer> numbers = purchasedLotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    private static String promptPurchaseAmount() {
        while (true){
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmountInput = readLine();
            try {
                validatePurchaseAmount(purchaseAmountInput);
                return purchaseAmountInput;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validatePurchaseAmount(String purchaseAmountInput) {
        validateIntegerInput(purchaseAmountInput);
        validateThousandUnit(purchaseAmountInput);
    }

    private static void validateIntegerInput(String purchaseAmountInput) {
        boolean isInteger = purchaseAmountInput.chars().allMatch(Character::isDigit);
        if (!isInteger) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하셨습니다.");
        }
    }

    private static void validateThousandUnit(String purchaseAmountInput) {
        int amount = Integer.parseInt(purchaseAmountInput);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
