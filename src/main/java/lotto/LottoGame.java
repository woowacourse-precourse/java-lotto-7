package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {
    private static final int MIN_LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_PRICE = 100000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int THIRD_AND_SECOND_PLACE_WINNING_NUMBER_MATCH_COUNT = 5;

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

            LottoIssuance(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseAmountInput();
        }
    }

    // 두 번째 입력(로또 번호(당첨 번호))
    private void lottoWinningNumberInput() {
        try {
            System.out.println("\n당첨 번호를 입력해 주세요.");

            List<String> winningNumber = List.of(Console.readLine().split(","));
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
            checkBonusNumberRedundancy(bonusNumber);
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

        totalLottoPrizeMoney += Long.parseLong(lottoPrize.getPrizeMoney().replace(",", "")) * matchCount;

        return matchCount;
    }

    // 금액에 맞게 로또를 발급하는 메서드
    public void LottoIssuance(int purchaseAmount) {
        int numberOfLottoPurchases = purchaseAmount / MIN_LOTTO_PRICE;
        System.out.println("\n" + numberOfLottoPurchases + "개를 구매했습니다.");

        for (int i = 0; i < numberOfLottoPurchases; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lottoNumbers.add(randomNumbers);
        }

        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    // 보너스 번호가 로또 번호와 중복되는 숫자가 있는지 검증하는 메서드
    public void checkBonusNumberRedundancy(int number) {
        for (Integer lottoNumber : lotto.getNumbers()) {
            if (lottoNumber == number) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.");
            }
        }
    }

    // 보너스 번호가 로또 번호의 최솟값과 최댓값을 벗어났는지 검증하는 메서드
    public void checkBonusNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");
        }
    }

    // 100,000원을 초과했는지 확인하는 메서드
    public void checkPurchasedAmountExceeded(int purchaseAmount) {
        if (purchaseAmount > MAX_LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1인당 100,000원을 넘길 수 없습니다.");
        }
    }

    // 1,000원 단위인지 확인하는 메서드
    public void checkUnitOfPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % MIN_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 양수인지 확인하는 메서드
    public String checkPositiveNumber(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 입력한 값은 숫자(양수)여야 합니다.");
        }
        return input;
    }
}
