package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Application {

    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        User user = inputNewUser();
        printPurchaseStatus(user.getLottos());

        Committee committee = inputNewCommittee();
        committee.checkLottos(user);

        printPrizes(user.getPrizes(), user.getReturnRate());
    }

    private static User inputNewUser() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int purchaseAmount = validateStringToNumber(Console.readLine());
            return new User(purchaseAmount);
        } catch (NoSuchElementException e) {
            throw e;
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return inputNewUser();
        }
    }

    private static Committee inputNewCommittee() {
        try {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            String[] numbers = input.split(",");

            Lotto winningNumbers = getWinningNumbers(numbers);

            return inputBonusNumber(winningNumbers);
        } catch (NoSuchElementException e) {
            throw e;
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return inputNewCommittee();
        }
    }

    private static Committee inputBonusNumber(Lotto winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNumber = validateStringToNumber(input);
        return new Committee(winningNumbers, bonusNumber);
    }

    public static void printPurchaseStatus(ArrayList<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printPrizes(Map<Prize, Integer> prizes, double returnRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (int i = Prize.values().length - 1; i >= 0; i--) {
            Prize prize = Prize.values()[i];
            if (prize != Prize.FAIL) {
                System.out.println(prize.getDescription() + " - " + prizes.get(prize) + "개");
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }

    private static Lotto getWinningNumbers(String[] numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            winningNumbers.add(validateStringToNumber(number));
        }
        return new Lotto(winningNumbers);
    }

    private static int validateStringToNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 숫자로 입력해야 합니다.");
        }
    }
}
