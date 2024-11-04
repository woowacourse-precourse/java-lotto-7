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
        inputPurchaseAmount();
        inputLottoWinningNumber();
        inputLottoBonusNumber();
        printWinningStats();
    }

    // 첫 번째 입력(구입 금액)
    private void inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");

                purchaseAmount = Integer.parseInt(checkPositiveNumber(Console.readLine()));
                checkUnitOfPurchaseAmount(purchaseAmount);
                checkPurchasedAmountExceeded(purchaseAmount);

                int numberOfLottoPurchases = lottoIssuesCount(purchaseAmount);
                printLottoIssuesCount(numberOfLottoPurchases);
                lottoIssuance(numberOfLottoPurchases);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 두 번째 입력(로또 번호(당첨 번호))
    private void inputLottoWinningNumber() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");

                List<String> winningNumber = List.of(Console.readLine().replace(" ", "").split(","));
                List<Integer> winningNumbers = new ArrayList<>();

                addWinningNumbers(winningNumber, winningNumbers);
                Collections.sort(winningNumbers);
                lotto = new Lotto(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 세 번째 입력(보너스 번호)
    private void inputLottoBonusNumber() {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                bonusNumber = Integer.parseInt(checkPositiveNumber(Console.readLine()));
                checkBonusNumberRange(bonusNumber);
                checkBonusNumberRedundancy(bonusNumber, lotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 로또 당첨 통계
    public void printWinningStats() {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoPrize lottoPrize : LottoPrize.values()) {
            int matchCount = calculateAndAddTotalPrizeMoney(lottoPrize);

            System.out.println(lottoPrize.getDescription() + " ("
                    + lottoPrize.getPrizeMoney() + "원) - " + matchCount + "개");
        }

        System.out.println("총 수익률은 " + totalLottoPrizeMoneyCalc() + "%입니다.");
    }

    // 총수익률을 계산하는 메서드
    public double totalLottoPrizeMoneyCalc() {
        return ((double) totalLottoPrizeMoney / purchaseAmount) * 100.0;
    }

    // 주어진 로또 번호가 2등 또는 3등에 해당하는지 확인하는 메서드
    private boolean isSecondOrThirdPlace(List<Integer> numbers, LottoPrize lottoPrize) {
        boolean containsBonusNumber = numbers.contains(bonusNumber);

        return (lottoPrize == LottoPrize.SECOND_PLACE && containsBonusNumber)
                || (lottoPrize == LottoPrize.THIRD_PLACE && !containsBonusNumber);
    }

    // 로또 번호와 당첨 번호 사이의 일치하는 숫자를 저장하고 그 컬렉션의 크기를 반환하는 메서드
    private int countMatchNumbers(List<Integer> numbers) {
        Set<Integer> duplicateValues = new HashSet<>(numbers);
        duplicateValues.retainAll(lotto.getNumbers());

        return duplicateValues.size();
    }

    // 로또 번호가 당첨된 등수에 해당하는지 확인하는 메서드
    private boolean isMatchPrize(LottoPrize lottoPrize, List<Integer> numbers) {
        int matchNumberCount = countMatchNumbers(numbers);

        if (matchNumberCount != lottoPrize.getWinningNumberMatchCount()) {
            return false;
        }

        if (lottoPrize.getWinningNumberMatchCount() == THIRD_AND_SECOND_PLACE_WINNING_NUMBER_MATCH_COUNT) {
            return isSecondOrThirdPlace(numbers, lottoPrize);
        }

        return true;
    }

    // 당첨된 등수의 로또 건수를 계산하는 메서드
    public int lottoNumberMatchCount(LottoPrize lottoPrize) {
        int matchCount = 0;

        for (List<Integer> numbers : lottoNumbers) {
            if (isMatchPrize(lottoPrize, numbers)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    // 당첨된 등수의 당첨 건수를 계산하고 총당첨금액을 계산하는 메서드를 호출하는 메서드
    public int calculateAndAddTotalPrizeMoney(LottoPrize lottoPrize) {
        int matchCount = lottoNumberMatchCount(lottoPrize);
        addTotalLottoPrizeMoney(lottoPrize, matchCount);

        return matchCount;
    }

    // 당첨된 상금을 더하는 메서드
    public void addTotalLottoPrizeMoney(LottoPrize lottoPrize, int matchCount) {
        totalLottoPrizeMoney += lottoPrize.getRealPrizeMoney() * matchCount;
    }

    // 금액에 맞는 로또를 발급하는 메서드
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

    // 로또 번호를 리스트에 추가하는 메서드
    private void addWinningNumbers(List<String> winningNumber, List<Integer> winningNumbers) {
        for (String number : winningNumber) {
            winningNumbers.add(Integer.parseInt(checkPositiveNumber(number)));
        }
    }
}
