package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoPrize;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void run() {
        LottoMachine lottoMachine = inputPrice();
        OutputView.lottoList(lottoMachine);

        Lotto winnerLotto = inputWinnerLotto();
        int bonus = inputBonus(winnerLotto);

        User user = new User(lottoMachine.getLottoTickets(), winnerLotto);
        long prizeMoney = calculatePrizeMoeny(user);
        double totalReturn = totalReturn(user, prizeMoney);
        OutputView.winningStatistics(totalReturn);

    }

    private static double totalReturn(User user, long prize) {
        int purchaseMoney = user.getLottoTickets().size() * 10;

        return Math.round(prize * 100.0 / purchaseMoney) / 100.0;
    }

    private static long calculatePrizeMoeny(User user) {
        long prizeMoney = 0;

        for (Lotto lotto : user.getLottoTickets()) {
            int matchCount = getMatchingNumbers(user.getWinnerLotto(), lotto);
            prizeMoney += prizeMoney(matchCount);
        }

        return prizeMoney;
    }

    private static int getMatchingNumbers(Lotto winnerLotto, Lotto lotto) {
        int matchCount = 0;

        for (int number : lotto.getNumbers()) {
            if (winnerLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private static long prizeMoney(int matchCount) {
        return LottoPrize.getPrizeByRank(matchCount);
    }

    private static LottoMachine inputPrice() {
        try {
            int price = InputView.inputPrice();
            return new LottoMachine(price);
        } catch (IllegalArgumentException e) {
            InputView.errorPrint(e.getMessage());
            return inputPrice();
        }
    }

    private static Lotto inputWinnerLotto() {
        while (true) {
            try {
                return new Lotto(numberParse());
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

    private static int inputBonus(Lotto winnerLotto) {
        while (true) {
            try {
                int bonus = InputView.inputBonus();
                return checkContains(winnerLotto, bonus);
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

    private static int checkContains(Lotto winnerLotto, int bonus) {
        if (winnerLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("당첨 번호에 포함된 숫자입니다.");
        }
        return bonus;
    }

    private static List<Integer> numberParse() {
        List<Integer> winnerNumbers = new ArrayList<>();
        while (true) {
            try {
                List<String> inputNumbers = InputView.inputNumbers();

                for (String lotto : inputNumbers) {
                    winnerNumbers.add(Integer.parseInt(lotto));
                }
                return winnerNumbers;
            } catch (NumberFormatException e) {
                InputView.errorPrint("당첨 번호는 숫자로만 작성해 주세요.");
            }
        }
    }
}
