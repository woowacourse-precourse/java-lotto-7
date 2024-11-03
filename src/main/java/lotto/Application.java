package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = repeatUntilValid(Application::readPurchaseAmount);
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> lottoList = buyLottos(lottoCount);
        WinningLotto tempWinningLotto = repeatUntilValid(Application::readWinningNumbers);
        WinningLotto winningLotto = repeatUntilValid(() -> readBonusNumber(tempWinningLotto));
        System.out.println(winningLotto);
        List<LottoResult> lottoResults = getLottoResults(winningLotto, lottoList);
        printLottoResult(purchaseAmount, lottoResults);
    }

    private static <R> R repeatUntilValid(Supplier<R> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.printf("%s\n\n", e.getMessage());
            return repeatUntilValid(function);
        }
    }

    private static int parseIntWithIllegalArgumentException(String value, String message) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }

    private static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmountString = Console.readLine();
        System.out.println();
        int purchaseAmount = parseIntWithIllegalArgumentException(purchaseAmountString, "[ERROR] 구입 금액은 숫자여야 합니다.");
        if (purchaseAmount % 1000 != 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        return purchaseAmount;
    }

    private static List<Lotto> buyLottos(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
        List<Lotto> lottoList = IntStream.range(0, lottoCount)
                .mapToObj(i -> Lotto.create())
                .toList();
        lottoList.forEach(System.out::println);
        System.out.println();
        return lottoList;
    }

    private static WinningLotto readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersString = Console.readLine();
        System.out.println();
        String[] winningNumberStringArray = winningNumbersString.replaceAll(" ", "").split(",");
        List<Integer> winningNumbers = Stream.of(winningNumberStringArray)
                .map(number -> parseIntWithIllegalArgumentException(number, "[ERROR] 당첨 번호는 숫자여야 합니다."))
                .toList();
        return new WinningLotto(winningNumbers);
    }

    private static WinningLotto readBonusNumber(WinningLotto winningLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberString = Console.readLine();
        System.out.println();
        int bonusNumber = parseIntWithIllegalArgumentException(bonusNumberString, "[ERROR] 보너스 번호는 숫자여야 합니다.");
        winningLotto.setBonusNumber(bonusNumber);
        return winningLotto;
    }

    private static List<LottoResult> getLottoResults(WinningLotto winningLotto, List<Lotto> lottoList) {
        return lottoList.stream()
                .map(winningLotto::match)
                .toList();
    }

    private static Map<LottoResult, Integer> getLottoResultCounts(List<LottoResult> lottoResults) {
        return lottoResults.stream()
                .collect(Collectors.groupingBy(result -> result))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
    }

    private static void printLottoResult(int purchaseAmount, List<LottoResult> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<LottoResult> printSequence = LottoResult.values.stream()
                .filter(result -> result != LottoResult.NONE)
                .toList();
        Map<LottoResult, Integer> lottoResultCount = getLottoResultCounts(lottoResults);
        int totalPrize = printSequence.stream()
                .mapToInt(result -> {
                    int count = lottoResultCount.getOrDefault(result, 0);
                    System.out.printf("%s - %d개\n", result.getDescription(), count);
                    return result.getPrize() * count;
                }).sum();
        System.out.printf("총 수익률은 %.1f%%입니다.\n", (double) totalPrize / purchaseAmount * 100);
    }
}
