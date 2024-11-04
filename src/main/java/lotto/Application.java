package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;
        System.out.println("\n" + numberOfLottos + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }

        inputWinningNumbers();
    }

    private static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                int amount = Integer.parseInt(input);

                if (amount % LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException();
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            }
        }
    }

    private static void inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        while (winningNumbers.size() < 6) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String winningInput = Console.readLine();
                winningNumbers = parseNumbers(winningInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int bonusNumber = 0;
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                bonusNumber = Integer.parseInt(Console.readLine());
                validateBonusNumber(winningNumbers, bonusNumber);
                break; // 유효한 보너스 번호가 입력된 경우 루프 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
            }
        }
    }

    private static List<Integer> parseNumbers(String input) {
        String[] numbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            validateLottoNumber(num); // 각 번호에 대해 유효성 검사
            winningNumbers.add(num);
        }
        return winningNumbers;
    }

    private static void validateLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
