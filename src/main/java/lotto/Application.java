package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = repeatUntilValidInput(Application::readPurchaseAmount);
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> lottoList = buyLottos(lottoCount);
        WinningLotto winningLotto = repeatUntilValidInput(Application::readWinningNumbers);
    }

    private static <R> R repeatUntilValidInput(Supplier<R> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.printf("%s\n\n", e.getMessage());
            return repeatUntilValidInput(function);
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
        return lottoList;
    }

    private static WinningLotto readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersString = Console.readLine();
        String[] winningNumberStringArray = winningNumbersString.replaceAll(" ", "").split(",");
        List<Integer> winningNumbers = Stream.of(winningNumberStringArray)
                .map(number -> parseIntWithIllegalArgumentException(number, "[ERROR] 당첨 번호는 숫자여야 합니다."))
                .toList();
        return new WinningLotto(winningNumbers);
    }
}
