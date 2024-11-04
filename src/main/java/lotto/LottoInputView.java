package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoInputView
{
    public static int lottoPurchaseAmount() {
        try {
            System.out.println("구입 금액을 입력해 주세요.");
            int amount = Integer.parseInt(Console.readLine());
            validatePurchaseLotto(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            // 다시 입력 받는다.
            return lottoPurchaseAmount();
        }
    }

    public static List<Integer> lottoWinningNumbers() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String numbers = Console.readLine().trim();
            List<Integer> finalwinningNumbers = tempWinningNumbers(numbers);
            validateWinningLotto(finalwinningNumbers);
            return finalwinningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return lottoWinningNumbers();
        }

    }

    public static int lottoBonusNumber(List<Integer> winningNumbers) {
        try{
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Integer.parseInt(Console.readLine());
            validateBonusNumbers(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return lottoBonusNumber(winningNumbers);
        }

    }

    public static List<Integer> tempWinningNumbers(String numbers) {
        String[] splitNumbers = splitWinningNumbers(numbers);
        List<String> trimNumbers = trimWinningNumbers(splitNumbers);
        List<Integer> finalNums = convertIntegerList(trimNumbers);

        return finalNums;
    }

    public static String[] splitWinningNumbers(String numbers) {
        return numbers.split(",");
    }

    public static List<String> trimWinningNumbers(String[] input) {
        return Arrays.stream(input)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<Integer> convertIntegerList(List<String> trimNumbers){
        return trimNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validatePurchaseLotto(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해주세요.");
        }
    }

    private static void validateWinningLotto(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호를 6개 입력해야 합니다.");
        }
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);

        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("당첨 번호에는 중복된 값이 없어야 합니다.");
        }
        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateBonusNumbers(int bonusNumber,List<Integer> winningNumbers){
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        Set<Integer> uniqueBonusNumbers = new HashSet<>(winningNumbers);
        uniqueBonusNumbers.add(bonusNumber);

        if (uniqueBonusNumbers.size() != (winningNumbers.size() + 1)) {
            throw new IllegalArgumentException("보너스 번호와 당첨 번호는 중복되어서는 안됩니다.");
        }
    }
}
