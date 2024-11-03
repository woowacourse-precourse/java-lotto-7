package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void lotto() {
        int purchaseAmount = getPurchaseAmount();
        int count = getCount(purchaseAmount);

        Lottos lottoNumbers = generateAndDisplayLottoNumbers(count);
        WinningLotto winningLotto = getWinningLotto();

        List<Integer> result = countWinnings(lottoNumbers, winningLotto);
        displayResults(result, purchaseAmount);
    }

    private static Lottos generateAndDisplayLottoNumbers(int count) {
        Lottos lottoNumbers = createLottoNumbers(count);
        OutputView.printLottoCount(count);
        OutputView.printLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    private static void displayResults(List<Integer> result, int purchaseAmount) {
        OutputView.printWinningStats(result);
        double totalEarnings = calculateTotalEarnings(result);
        double profitRate = calculateProfitRate(totalEarnings, purchaseAmount);
        OutputView.printProfitRate(profitRate);
    }

    private static int getPurchaseAmount() {
        while (true) {
            try {
                String inputAmount = InputView.getPurchaseAmount();
                return validateAndParsePurchaseAmount(inputAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = getValidWinningNumbers();
        Integer bonus = getValidBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonus);
    }

    private static List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = InputView.getWinningNumbers();
                return convertWinningNumbers(inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static Integer getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String inputBonusNumber = InputView.getBonusNumber();
                Integer bonus = convertBonusNumber(inputBonusNumber);
                if (winningNumbers.contains(bonus)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함되지 않아야 합니다.");
                }
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static Integer convertBonusNumber(String inputBonusNumber) {
        try {
            int bonus = Integer.parseInt(inputBonusNumber);
            if (bonus < 1 || bonus > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다.");
            }
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    static List<Integer> convertWinningNumbers(String inputWinningNumbers) {
        String[] inputNumbers = inputWinningNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : inputNumbers) {
            int parsedNumber = parseNumber(number);
            validateNumber(parsedNumber, winningNumbers);
            winningNumbers.add(parsedNumber);
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        return winningNumbers;
    }

    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static void validateNumber(int number, List<Integer> winningNumbers) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자만 가능합니다.");
        }
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }


    private static Lottos createLottoNumbers(int count) {

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> createdLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            createdLotto.sort(Integer::compareTo);
            Lotto lotto = new Lotto(createdLotto);
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    private static int validateAndParsePurchaseAmount(String purchaseAmount) {
        int parsedPurchaseAmount = parsePurchaseAmount(purchaseAmount);
        validatePurchaseAmount(parsedPurchaseAmount);
        return parsedPurchaseAmount;
    }

    private static int parsePurchaseAmount(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.\n");
        }
    }

    static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.\n");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.\n");
        }
    }

    private static int getCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    static List<Integer> countWinnings(Lottos lottos, WinningLotto winningLotto) {
        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 0));

        for (Lotto lotto : lottos.getLottos()) {
            int matchCounts = countMatches(lotto.getNumbers(), winningLotto.getNumbers());
            updateWinningCounts(result, matchCounts, lotto.getNumbers(), winningLotto.getBonusNumber());
        }
        return result;
    }

    private static void updateWinningCounts(List<Integer> result, int matchCounts, List<Integer> lottoNumbers,
                                            Integer bonus) {
        if (matchCounts == LottoRank.FIRST.getMatchingCount()) {
            result.set(0, result.get(0) + 1);
        } else if (matchCounts == LottoRank.SECOND.getMatchingCount() && bonusMatches(lottoNumbers, bonus)) {
            result.set(1, result.get(1) + 1);
        } else if (matchCounts == LottoRank.THIRD.getMatchingCount()) {
            result.set(2, result.get(2) + 1);
        } else if (matchCounts == LottoRank.FOURTH.getMatchingCount()) {
            result.set(3, result.get(3) + 1);
        } else if (matchCounts == LottoRank.FIFTH.getMatchingCount()) {
            result.set(4, result.get(4) + 1);
        }
    }

    private static int countMatches(List<Integer> numbers, List<Integer> winningLotto) {
        int count = 0;
        for (Integer number : numbers) {
            if (winningLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static boolean bonusMatches(List<Integer> numbers, Integer bonus) {
        return numbers.contains(bonus);
    }

    static double calculateTotalEarnings(List<Integer> result) {
        double totalEarnings = 0;
        for (int i = 0; i < result.size(); i++) {
            totalEarnings += result.get(result.size() - 1 - i) * LottoRank.values()[i].getPrizeAmount();
        }
        return totalEarnings;
    }

    static double calculateProfitRate(double totalEarnings, int purchaseAmount) {
        return (totalEarnings / purchaseAmount) * 100;
    }
}