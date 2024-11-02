package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        int lottoPrice = 1000;
        System.out.println("구입금액을 입력해 주세요.");
        String inputPrice = Console.readLine();

        if (!isNumeric(inputPrice)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양수로 입력해 주세요.");
        }

        long userPrice = Integer.parseInt(inputPrice);
        if (userPrice % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 " + lottoPrice + "단위로 입력해 주세요.");
        }
        System.out.println();


        long purchasedLottoCount = userPrice / lottoPrice;
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchasedLottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = Lotto.createLotto(numbers);
            System.out.println(lotto.printLotto());
            lottos.add(lotto);
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
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로 입력해 주세요.");
            }

            int number = Integer.parseInt(inputNumber);
            if (number <= 0) {
                throw new IllegalArgumentException("[ERROR] 1 이상의 양수로 입력해 주세요.");
            }
            if (number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winningNumbers.add(number);
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복일 수 없습니다.");
        }
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        if (!inputBonusNumber.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자 하나만 입력해 주세요.");
        }
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (bonusNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 이상의 양수로 입력해 주세요.");
        }
        if (bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        winningNumbers.add(bonusNumber);
        if (winningNumbers.size() != 7) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 기존의 당첨 번호들과 중복일 수 없습니다.");
        }
        System.out.println();

        System.out.println("당첨 통계");
        String hyphen = "-";
        System.out.println(hyphen.repeat(3));
        winningNumbers.remove(bonusNumber);

        long profit = 0;
        int[] lottoResultCounts = new int[7];
        for (Lotto lotto : lottos) {
            LottoResult lottoResult = lotto.calculatePrize(winningNumbers, bonusNumber);
            profit += lottoResult.getPrice();
            lottoResultCounts[lottoResult.getRank()]++;
        }

        System.out.println(LottoResult.FIFTH_PRIZE.getDescription() + " - " + lottoResultCounts[5] + "개");
        System.out.println(LottoResult.FOURTH_PRIZE.getDescription() + " - " + lottoResultCounts[4] + "개");
        System.out.println(LottoResult.THIRD_PRIZE.getDescription() + " - " + lottoResultCounts[3] + "개");
        System.out.println(LottoResult.SECOND_PRIZE.getDescription() + " - " + lottoResultCounts[2] + "개");
        System.out.println(LottoResult.FIRST_PRIZE.getDescription() + " - " + lottoResultCounts[1] + "개");

        double yield = (double) profit / userPrice * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }

    private static boolean isNumeric(String inputPrice) {
        return inputPrice.chars().allMatch(Character::isDigit);
    }
}
