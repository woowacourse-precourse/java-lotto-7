package lotto;

import static constant.Constant.*;
import static validation.Validate.*;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {
    private int purchaseAmount;
    private int bonusNumber;
    private final List<List<Integer>> lottoNumbers = new ArrayList<>();
    private Lotto lotto;
    private long totalLottoPrizeMoney;

    public void start() {
        purchaseAmountInput();
        lottoWinningNumberInput();
        lottoBonusNumberInput();
        printWinningStats();
    }

    // 첫 번째 입력(구입 금액)
    private void purchaseAmountInput() {
        try {
            System.out.println("구입금액을 입력해 주세요.");

            purchaseAmount = Integer.parseInt(checkPositiveNumber(Console.readLine()));
            checkUnitOfPurchaseAmount(purchaseAmount);
            checkPurchasedAmountExceeded(purchaseAmount);

            int numberOfLottoPurchases = lottoIssuesCount(purchaseAmount);
            printLottoIssuesCount(numberOfLottoPurchases);
            lottoIssuance(numberOfLottoPurchases);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseAmountInput();
        }
    }

    // 두 번째 입력(로또 번호(당첨 번호))
    private void lottoWinningNumberInput() {
        try {
            System.out.println("\n당첨 번호를 입력해 주세요.");

            List<String> winningNumber = List.of(Console.readLine().replace(" ", "").split(","));
            List<Integer> winningNumbers = new ArrayList<>();

            for (String number : winningNumber) {
                winningNumbers.add(Integer.parseInt(checkPositiveNumber(number)));
            }

            Collections.sort(winningNumbers);
            lotto = new Lotto(winningNumbers);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoWinningNumberInput();
        }
    }

    // 세 번째 입력(보너스 번호)
    private void lottoBonusNumberInput() {
        try {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            bonusNumber = Integer.parseInt(checkPositiveNumber(Console.readLine()));
            checkBonusNumberRange(bonusNumber);
            checkBonusNumberRedundancy(bonusNumber, lotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoBonusNumberInput();
        }
    }

    // 로또 당첨 통계
    public void printWinningStats() {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoPrize lottoPrize : LottoPrize.values()) {
            System.out.println(lottoPrize.getDescription() + " ("
                    + lottoPrize.getPrizeMoney() + "원) - " + lottoNumberMatchCount(lottoPrize) + "개");
        }

        System.out.println("총 수익률은 " + totalLottoPrizeMoneyCalc() + "%입니다.");
    }

    // 총수익률을 계산하는 메서드
    public double totalLottoPrizeMoneyCalc() {
        return ((double) totalLottoPrizeMoney / purchaseAmount) * 100.0;
    }

    // 구입한 로또가 몇 등, 몇 번 당첨됐는지 확인하는 메서드
    public int lottoNumberMatchCount(LottoPrize lottoPrize) {
        int matchCount = 0;

        for (List<Integer> numbers : lottoNumbers) {
            Set<Integer> duplicateValues = new HashSet<>(numbers);
            duplicateValues.retainAll(lotto.getNumbers());

            if (duplicateValues.size() != lottoPrize.getWinningNumberMatchCount()) {
                continue;
            }

            boolean isSecondPlace =
                    lottoPrize.getWinningNumberMatchCount() == THIRD_AND_SECOND_PLACE_WINNING_NUMBER_MATCH_COUNT
                            && numbers.contains(bonusNumber)
                            && lottoPrize == LottoPrize.SECOND_PLACE;

            boolean isThirdPlace =
                    lottoPrize.getWinningNumberMatchCount() == THIRD_AND_SECOND_PLACE_WINNING_NUMBER_MATCH_COUNT
                            && !numbers.contains(bonusNumber)
                            && lottoPrize == LottoPrize.THIRD_PLACE;

            if (isSecondPlace || isThirdPlace
                    || lottoPrize.getWinningNumberMatchCount() != THIRD_AND_SECOND_PLACE_WINNING_NUMBER_MATCH_COUNT) {
                matchCount++;
            }
        }
        addTotalLottoPrizeMoney(lottoPrize, matchCount);

        return matchCount;
    }

    // 당첨된 상금을 더하는 메서드
    public void addTotalLottoPrizeMoney(LottoPrize lottoPrize, int matchCount) {
        totalLottoPrizeMoney += lottoPrize.getRealPrizeMoney() * matchCount;
    }

    // 금액에 맞게 로또를 발급하는 메서드
    public void lottoIssuance(int numberOfLottoPurchases) {
        for (int i = 0; i < numberOfLottoPurchases; i++) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(randomNumbers);
            lottoNumbers.add(randomNumbers);
        }

        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    // 구입 금액에 맞는 로또 발급 건수를 계산하는 메서드
    public int lottoIssuesCount(int purchaseAmount) {
        return purchaseAmount / MIN_LOTTO_PRICE;
    }

    // 로또 발급 건수를 출력하는 메서드
    public void printLottoIssuesCount(int numberOfLottoPurchases) {
        System.out.println(numberOfLottoPurchases + "개를 구매했습니다.");
    }
}
