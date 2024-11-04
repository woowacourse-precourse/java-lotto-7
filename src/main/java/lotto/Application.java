package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int lottoPurchasePrice = getValidPurchasePrice();
        int lottoPurchaseQuantity = calculateLottoQuantity(lottoPurchasePrice);

        printPurchaseInfo(lottoPurchaseQuantity);

        List<Lotto> lottos = createLottos(lottoPurchaseQuantity);
        printLottos(lottos);

        List<Integer> lottoWinningNumbers = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber(lottoWinningNumbers);

        WinningLotto winningLotto = new WinningLotto(lottoWinningNumbers, bonusNumber);
        LottoResult result = matchLottos(lottos, winningLotto);

        printResult(result, lottoPurchasePrice);
    }

    private static int getValidPurchasePrice() {
        return promptWithValidation("구입금액을 입력해 주세요.", Application::validatePurchasePrice);
    }

    private static List<Integer> getValidWinningNumbers() {
        return promptWithValidation("당첨 번호를 입력해 주세요.", Application::validateWinningNumbers);
    }

    private static int getValidBonusNumber(List<Integer> winningNumbers) {
        return promptWithValidation("보너스 번호를 입력해 주세요.", input -> validateBonusNumber(input, winningNumbers));
    }

    private static <T> T promptWithValidation(String message, Validator<T> validator) {
        while (true) {
            try {
                System.out.println(message);
                String input = Console.readLine();
                return validator.validate(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int validatePurchasePrice(String input) {
        checkNonEmptyNumeric(input);
        int price = Integer.parseInt(input);
        if (price % 1000 != 0 || price < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이며, 1000원 단위로 나누어 떨어져야 합니다.");
        }
        return price;
    }

    private static void checkNonEmptyNumeric(String input) {
        if (input == null || input.isEmpty() || !input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    private static List<Integer> validateWinningNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (numbers.size() != 6 || numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않은 6개의 숫자여야 합니다.");
        }
        numbers.forEach(Application::validateLottoNumberRange);
        return numbers;
    }

    private static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        checkNonEmptyNumeric(input);
        int number = Integer.parseInt(input);
        validateLottoNumberRange(number);
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return number;
    }

    private static void validateLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void printPurchaseInfo(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    private static List<Lotto> createLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(createLottoNumbers()));
        }
        return lottos;
    }

    private static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().collect(Collectors.toList());
    }

    private static void printLottos(List<Lotto> lottos) {
        lottos.forEach(Lotto::printNumbers);
    }

    private static LottoResult matchLottos(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        lottos.forEach(lotto -> result.addResult(winningLotto.match(lotto)));
        return result;
    }

    private static void printResult(LottoResult result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.printf("%s - %d개\n", rank.getDescription(), result.getCount(rank));
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.calculateProfitRate(purchaseAmount));
    }

    public static int calculateLottoQuantity(int purchasePrice) {
        return purchasePrice / 1000;
    }

    @FunctionalInterface
    private interface Validator<T> {
        T validate(String input) throws IllegalArgumentException;
    }
}
