package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            int lottoCount = getPurchaseAmount(); // 구매한 로또 수

            printGeneratedLottos(lottoCount);

            Lotto inputLottoNum = getWinningNumbers(); // inputLottoNum 객체에 당첨번호 입력
            getBonusNumber(inputLottoNum); // inputLottoNum 객체에 보너스번호 입력
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        String inputPurchase = Console.readLine();

        PurchaseCalculator pCalc = new PurchaseCalculator(inputPurchase);

        int lottoCount = pCalc.calculateLottoCount();
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    private static void printGeneratedLottos(int lottoCount) {
        List<Lotto> generatedLottos = Lotto.makeLotto(lottoCount);
        for (Lotto lotto : generatedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static Lotto getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String inputNumber = Console.readLine();

        List<Integer> numbers = parseInputToList(inputNumber);
        return new Lotto(numbers);
    }

    private static void getBonusNumber(Lotto inputLottoNum) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String inputBonusNum = Console.readLine();

        int bonus = parseBonusToInt(inputBonusNum);
        inputLottoNum.setBonusNum(bonus);
    }

    private static List<Integer> parseInputToList(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력하세요.");
        }
    }

    private static int parseBonusToInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력하세요.");
        }
    }
}
