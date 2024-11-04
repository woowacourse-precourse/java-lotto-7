package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.exception.LottoException;

public class InputView {

    public static PurchaseAmount readPurchaseAmount() {
        return retry(() -> {
            System.out.println("구입금액을 입력해 주세요.");
            int amount = parseNumber(Console.readLine());
            System.out.println();
            return PurchaseAmount.from(amount);
        });
    }

    public static WinningNumbers readWinningNumbers() {
        Lotto winningLotto = readWinningLotto();
        return retry(()-> {
            LottoNumber bonusNumber = readBonusNumber();
            return WinningNumbers.of(winningLotto, bonusNumber);
        });
    }

    private static Lotto readWinningLotto() {
        return retry(() -> {
            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> numbers = parseNumbers(Console.readLine());
            System.out.println();
            return Lotto.from(numbers);
        });
    }

    private static LottoNumber readBonusNumber() {
        return retry(() -> {
            System.out.println("보너스 번호를 입력해 주세요.");
            int number = parseNumber(Console.readLine());
            System.out.println();
            return LottoNumber.from(number);
        });
    }

    private static List<Integer> parseNumbers(final String input) {
        return Arrays.stream(input.split(",", -1))
                .map(InputView::parseNumber)
                .toList();
    }

    private static int parseNumber(final String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new LottoException("숫자만 입력 가능합니다.");
        }
    }

    private static <T> T retry(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
