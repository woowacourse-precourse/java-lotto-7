package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputUtils {
    public static PurchasedLotto inputCost(LotteryRoundManager lotteryManager) {
        return InputUtils.repeatProcess(() -> {
            int cost = readInteger("구입금액을 입력해 주세요.");
            return lotteryManager.purchaseLotto(cost);
        });
    }

    public static void inputWinningNumber(LotteryRoundManager lotteryManager) {
        InputUtils.repeatProcess(() -> {
            List<Integer> winningNumber = readIntegerList("당첨 번호를 입력해주세요.");
            int bonusNumber = readInteger("보너스 번호를 입력해주세요.");
            lotteryManager.setWinningNumber(winningNumber, bonusNumber);
            return null;
        });
    }

    public static <T> T repeatProcess(Supplier<T> func) {
        while (true) {
            try {
                return func.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int readInteger(String announcement) {
        try {
            System.out.println(announcement);
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요", e);
        }
    }

    public static List<Integer> readIntegerList(String announcement) {
        try {
            System.out.println(announcement);
            String input = readLine();
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요", e);
        }
    }
}
