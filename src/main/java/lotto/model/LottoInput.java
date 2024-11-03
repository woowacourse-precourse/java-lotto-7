package lotto.model;

import lotto.errors.BonusNumberErrors;
import lotto.errors.PurchaseAmountErrors;
import lotto.errors.WinningNumbersErrors;

import java.util.*;
import java.util.stream.Collectors;

public class LottoInput {

    private static final Scanner scanner = new Scanner(System.in);

    public Integer getLottoPurchaseAmount() {
        // 로또 구입 금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = scanner.nextLine();

        PurchaseAmountErrors errorHandler = new PurchaseAmountErrors();
        errorHandler.errorCheck(purchaseAmount);

        Integer lottoAmount = Integer.parseInt(purchaseAmount) / 1000;
        System.out.println(lottoAmount+"개를 구매했습니다.");

        return lottoAmount;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        String winningNumbersInput = scanner.nextLine();

        // 숫자 이외의 값을 입력했을 경우
        if (!winningNumbersInput.matches("^(\\d+\\s*,\\s*)*\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자와 쉼표만 입력해 주세요.");
        }

        return makeWinningNumberListAndValidate(winningNumbersInput);
    }

    public List<Integer> makeWinningNumberListAndValidate(String winningNumbersInput) {
        List<Integer> winningNumbers = new ArrayList<>();

        winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        WinningNumbersErrors errorHandler = new WinningNumbersErrors();
        errorHandler.errorCheck(winningNumbers);

        Collections.sort(winningNumbers);

        return winningNumbers;
    }

    public Integer inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = scanner.nextLine();

        BonusNumberErrors errorHandler = new BonusNumberErrors();
        errorHandler.errorCheck(bonusNumber, winningNumbers);

        return Integer.parseInt(bonusNumber);
    }

}
