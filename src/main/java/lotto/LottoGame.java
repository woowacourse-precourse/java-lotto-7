package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoGame {
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void start() {
        int purchaseAmount = readPurchaseAmount();
        lottos = generateLottos(purchaseAmount);
        printLottos(lottos);
        winningNumbers = readWinningNumbers();
        bonusNumber = readBonusNumber();
    }

    private int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                return validateAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateAmount(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력해주세요.");
        }

        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해 주세요.");
        }

        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 금액은 1,000원 단위의 양수로 입력해 주세요.");
        }

        return amount;
    }

    private List<Lotto> generateLottos(int purchaseAmount) {
        int count = purchaseAmount / 1000;
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                return validateWinningNumbers(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> validateWinningNumbers(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[Error] 당첨 번호를 입력해 주세요.");
        }

        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[Error] 당첨 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[Error] 당첨 번호는 1부터 45까지 입니다.");
            }
            if (!uniqueNumbers.add(num)) {
                throw new IllegalArgumentException("[Error] 당첨 번호에 중복이 있습니다.");
            }
            winningNumbers.add(num);
        }
        Collections.sort(winningNumbers);
        return winningNumbers;
    }

    private int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                return validateBonusNumber(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateBonusNumber(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해 주세요.");
        }

        int bonusNum = Integer.parseInt(input.trim());
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }

        // 보너스 번호는 당첨 번호와 중복되면 안됨
        if (winningNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        return bonusNum;
    }
}
