package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.errors.BonusNumberErrors;
import lotto.errors.PurchaseAmountErrors;
import lotto.errors.WinningNumbersErrors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoInput {

    public Integer getLottoPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmount = readPurchaseAmount();
                validatePurchaseAmount(purchaseAmount);
                Integer lottoAmount = Integer.parseInt(purchaseAmount) / 1000;

                System.out.println();
                System.out.println(lottoAmount + "개를 구매했습니다.");
                return lottoAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // [ERROR]로 시작하는 메시지 출력
            }
        }
    }

    private String readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        PurchaseAmountErrors errorHandler = new PurchaseAmountErrors();
        errorHandler.errorCheck(purchaseAmount);
    }

    public List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                String winningNumbersInput = readWinningNumbers();
                validateWinningNumbersFormat(winningNumbersInput);
                return makeWinningNumberListAndValidate(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // [ERROR]로 시작하는 메시지 출력
            }
        }
    }

    private String readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private void validateWinningNumbersFormat(String winningNumbersInput) {
        if (!winningNumbersInput.matches("^(\\d+\\s*,\\s*)*\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자와 쉼표만 입력해 주세요.");
        }
    }

    public List<Integer> makeWinningNumberListAndValidate(String winningNumbersInput) {
        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        WinningNumbersErrors errorHandler = new WinningNumbersErrors();
        errorHandler.errorCheck(winningNumbers);

        Collections.sort(winningNumbers);
        return winningNumbers;
    }

    public Integer inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusNumber = Console.readLine();

                BonusNumberErrors errorHandler = new BonusNumberErrors();
                errorHandler.errorCheck(bonusNumber, winningNumbers);

                return Integer.parseInt(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // [ERROR]로 시작하는 메시지 출력
            }
        }
    }
}
