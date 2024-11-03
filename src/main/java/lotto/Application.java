package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {
    static List<List<Integer>> userLottoNumbers = new ArrayList<>();
    static Map<Rank, Integer> lottoPrizeCount = new LinkedHashMap<>() {{
       put(Rank.FIRST, 0);
       put(Rank.SECOND, 0);
       put(Rank.THIRD, 0);
       put(Rank.FOURTH, 0);
       put(Rank.FIFTH, 0);
    }};

    public static void generateLottoNumbers(int lottoAmount) {
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> userLottoNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            userLottoNumber.sort(Comparator.naturalOrder());
            userLottoNumbers.add(userLottoNumber);
        }
    }

    public static void checkLottoMatch(List<Integer> lottoWinningNumber, int lottoBonusNumber) {
        for (List<Integer> userLottoNumber : userLottoNumbers) {
            boolean isBonusNumberMatched = false;
            int winningNumberCount = compareLottoNumbers(userLottoNumber, lottoWinningNumber);
            if (winningNumberCount == 5) {
                isBonusNumberMatched = compareBonusNumber(userLottoNumber, lottoBonusNumber);
            }
            countLottoRank(winningNumberCount, isBonusNumberMatched);
        }
    }

    public static void countLottoRank(int winningNumberCount, boolean isBonusNumberMatched) {
        Rank value = Rank.valueOf(winningNumberCount, isBonusNumberMatched);
        if (value != null) {
            lottoPrizeCount.put(value, lottoPrizeCount.get(value) + 1);
        }
    }

    public static int compareLottoNumbers(List<Integer> userLottoNumber, List<Integer> lottoWinningNumber) {
        int winningNumberCount = 0;
        for (int number : lottoWinningNumber) {
            if (userLottoNumber.contains(number)) {
                winningNumberCount += 1;
            }
        }
        return winningNumberCount;
    }

    public static boolean compareBonusNumber(List<Integer> userLottoNumber, int lottoBonusNumber) {
        return userLottoNumber.contains(lottoBonusNumber);
    }

    public static double calculateLottoProfit(int lottoPurchasePrice) {
        int lottoTotalPrice = 0;
        for (Rank rank : lottoPrizeCount.keySet()) {
            if (lottoPrizeCount.get(rank) != 0) {
                lottoTotalPrice += rank.getPrizeMoney() * lottoPrizeCount.get(rank);
            }
        }
        return (double) lottoTotalPrice / lottoPurchasePrice * 100;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        // 로또 구입 금액 입력받기
        outputView.printLottoAmountPrompt();
        int lottoPurchasePrice = inputView.readLottoPurchasePrice();
        int lottoAmount = lottoPurchasePrice / 1000;
        // 발행한 로또 수량 및 번호 출력하기
        outputView.printLottoAmount(lottoAmount);
        generateLottoNumbers(lottoAmount);
        outputView.printUserLottoNumber(userLottoNumbers);
        // 당첨 번호와 보너스 번호 입력받기
        outputView.printLottoWinningNumberPrompt();
        List<Integer> lottoWinningNumber = inputView.readLottoWinningNumber();
        outputView.printLottoBonusNumberPrompt();
        int lottoBonusNumber = inputView.readLottoBonusNumber();
        // 발행한 로또 번호와 당첨 번호, 보너스 번호를 비교하여 당첨 내역 출력하기
        checkLottoMatch(lottoWinningNumber, lottoBonusNumber);
        outputView.printLottoResult(lottoPrizeCount);
        // 수익률 계산하여 출력하기
        double lottoProfit = calculateLottoProfit(lottoPurchasePrice);
        outputView.printLottoProfit(lottoProfit);
    }
}
