package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void lotto() {
        String inputAmount = InputView.getPurchaseAmount();
        int purchaseAmount = validateAndParsePurchaseAmount(inputAmount);
        int count = getCount(purchaseAmount);

        List<Lotto> lottoNumbers = createLottoNumbers(count);
        OutputView.printLottoCount(count);
        OutputView.printLottoNumbers(lottoNumbers);

        String inputWinningNumbers = InputView.getWinningNumbers();
        List<Integer> winningNumbers = convertWinningNumbers(inputWinningNumbers);

        Integer bonus = convertBonusNumber(InputView.getBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);

        List<Integer> result = countWinnings(lottoNumbers, winningLotto);
        OutputView.printWinningStats(result);

        double totalEarnings = calculateTotalEarnings(result);
        double profitRate = calculateProfitRate(totalEarnings, purchaseAmount);
        OutputView.printProfitRate(profitRate);
    }

    private static Integer convertBonusNumber(String inputBonusNumber) {
        try {
            Integer bonus = Integer.parseInt(inputBonusNumber);
            if (bonus < 1 || bonus > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다.");
            }
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static List<Integer> convertWinningNumbers(String inputWinningNumbers) {
        String[] inputNumbers = inputWinningNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : inputNumbers) {
            int parsedNumber = parseWinningNumber(number.trim());
            winningNumbers.add(parsedNumber);
        }

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        return winningNumbers;
    }

    private static int parseWinningNumber(String number) {
        try {
            int winningNumber = Integer.parseInt(number);
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자만 가능합니다.");
            }
            return winningNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    private static List<Lotto> createLottoNumbers(int count) {

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> createdLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            createdLotto.sort(Integer::compareTo);
            Lotto lotto = new Lotto(createdLotto);
            lottos.add(lotto);
        }
        return lottos;
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
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    private static int getCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private static List<Integer> countWinnings(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 0));

        for (Lotto lotto : lottos) {
            int matchCounts = countMatches(lotto.getNumbers(), winningLotto.getNumbers());
            if (matchCounts == LottoRank.FIRST.getMatchingCount()) {
                result.set(0, result.get(0) + 1);
            } else if (matchCounts == LottoRank.SECOND.getMatchingCount() && bonusMatches(lotto.getNumbers(),
                    winningLotto.getBonusNumber())) {
                result.set(1, result.get(1) + 1);

            } else if (matchCounts == LottoRank.THIRD.getMatchingCount()) {
                result.set(2, result.get(2) + 1);

            } else if (matchCounts == LottoRank.FOURTH.getMatchingCount()) {
                result.set(3, result.get(3) + 1);

            } else if (matchCounts == LottoRank.FIFTH.getMatchingCount()) {
                result.set(4, result.get(4) + 1);
            }
        }
        return result;
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

    private static double calculateTotalEarnings(List<Integer> result) {
        double totalEarnings = 0;
        for (int i = 0; i < result.size(); i++) {
            totalEarnings += result.get(result.size() - 1 - i) * LottoRank.values()[i].getPrizeAmount();
        }
        return totalEarnings;
    }

    private static double calculateProfitRate(double totalEarnings, int purchaseAmount) {
        return (totalEarnings / purchaseAmount) * 100;
    }
}