package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Application {
    public static void main(String[] args) {

        int lottoPrice = 1000;
        System.out.println("구입금액을 입력해 주세요.");
        String inputPrice = Console.readLine();

        if (!isNumeric(inputPrice)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양수로 입력해 주세요.");
        }

        int userPrice = Integer.parseInt(inputPrice);
        if (userPrice % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 " + lottoPrice + "단위로 입력해 주세요.");
        }
        System.out.println();


        int purchasedLottoCount = userPrice / lottoPrice;
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");
        for (int i = 0; i < purchasedLottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = Lotto.createLotto(numbers);
            System.out.println(lotto.printLotto());
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine().trim();
        if (!winningNumbersInput.matches("^\\d+(,\\d+)*$")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)를 기준으로, 6개 입력해 주세요.");
        }
        String[] inputNumbers = winningNumbersInput.split(",");
        if (inputNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)를 기준으로, 6개 입력해 주세요.");
        }

        Set<Integer> winningNumbers = new TreeSet<>();
        for (String inputNumber : inputNumbers) {
            if (!isNumeric(inputNumber)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 양수로 입력해 주세요.");
            }

            int number = Integer.parseInt(inputNumber);
            if (number < 0) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 음수일 수 없습니다.");
            }
            if (number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winningNumbers.add(number);
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복일 수 없습니다.");
        }

    }

    private static boolean isNumeric(String inputPrice) {
        return inputPrice.chars().allMatch(Character::isDigit);
    }
}
