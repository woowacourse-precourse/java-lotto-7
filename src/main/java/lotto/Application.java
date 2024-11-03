package lotto;

import static java.lang.Integer.parseInt;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    private static final int PER_LOTTO_PRICE = 1000;
    private static final int RAND_MIN = 1;
    private static final int RAND_MAX = 45;
    private static final int THRESHOLD = 6;
    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        int purchasePrice; // 로또 구입금액
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String purchasePriceStr = Console.readLine();
                purchasePrice = parseInt(purchasePriceStr);
                if (purchasePrice <= 0 || purchasePrice % PER_LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException("[ERROR] 1,000원 단위의 올바른 금액을 입력하세요.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int lottoPieces = purchasePrice / PER_LOTTO_PRICE;
        System.out.printf("%d개를 구매했습니다.%n", lottoPieces);

        List<Lotto> numbersLines = new ArrayList<>();
        for (int i = 0; i < lottoPieces; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(RAND_MIN, RAND_MAX, THRESHOLD));
            Collections.sort(numbers);
            numbersLines.add(new Lotto(numbers));
            System.out.println(numbers);
        }

        List<Integer> winningNumbers = new ArrayList<>(); // 추첨 번호
        while (winningNumbers.size() < 6) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String[] input = Console.readLine().split(DELIMITER);
                if (input.length != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
                }
                for (String number : input) {
                    int num = parseInt(number.trim());
                    if (num < 1 || num > 45) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    winningNumbers.add(num);
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int bonusNumber;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = parseInt(Console.readLine().trim());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}