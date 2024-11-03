package view;

import camp.nextstep.edu.missionutils.Console;
import domain.LottoNumber;
import domain.WinningLotto;
import purchase.PurchaseAmount;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static PurchaseAmount readPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int amount = Integer.parseInt(input);
            return new PurchaseAmount(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    public static WinningLotto readWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<LottoNumber> winningNumbers;
        try {
            winningNumbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();
        LottoNumber bonusNumber;
        try {
            bonusNumber = new LottoNumber(Integer.parseInt(bonusInput.trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }

        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
