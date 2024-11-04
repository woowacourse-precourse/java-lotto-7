package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        LottoOutput output = new LottoOutput();

        // 로또 구입
        output.displayPurchaseAmountPrompt();
        LottoPurchase lottoPurchase = getLottoPurchase();

        // 로또 번호 발행
        output.displayPurchasedLottoCount(lottoPurchase.getPurchasedLottoCount());
        LottoGenerator lottoGenerator = new LottoGenerator(lottoPurchase.getPurchasedLottoCount());
        List<Lotto> tickets = lottoGenerator.getTickets();
        output.displayLottoNumbers(tickets);

        // 당첨 번호 설정
        output.displayWinningNumbersPrompt();
        WinningNumbers winningNumbers = getWinningNumbers();
        List<Integer> winning = winningNumbers.getWinningNumbers();

        // 보너스 번호 설정
        output.displayBonusNumberPrompt();
        BonusNumber bonusNumber = getBonusNumber(winning);

        // 당첨 조회
        LottoWinningChecker checker = new LottoWinningChecker(tickets, winning, bonusNumber.getBonusNumber());
        output.displayPlaceResult(checker.getPlaceCount());

        // 수익률 계산
        EarningsRateCalculator earningsRateCalculator = new EarningsRateCalculator(checker.getPlaceCount(), lottoPurchase.getPurchaseAmount());
        output.displayEarningsRate(earningsRateCalculator.getEarningsRate());
    }

    private static LottoPurchase getLottoPurchase() {
        while (true) {
            try {
                return new LottoPurchase(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                return new WinningNumbers(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static BonusNumber getBonusNumber(List<Integer> winning) {
        while (true) {
            try {
                return new BonusNumber(readLine(), winning);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
