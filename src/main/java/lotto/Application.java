package lotto;

import InputOutput.InputView;
import InputOutput.OutputView;
import Rank.Rank;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<List<Integer>> lottoTickets;
        List<Integer> winNumber;
        int bonusNumber;
        int ticket;
        OutputView.firstMessage();
        int price = 0;
        while (true) {
            try {
                price = Integer.parseInt(InputView.insert());
                ticket = OutputView.calculateNumberOfSheetsFromAmount(price);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        lottoTickets = Lotto.createLottoTickets(ticket);
        OutputView.printLottoTickets(lottoTickets);

        OutputView.promptWinningNumbers();
        while (true) {
            try {
                winNumber = InputView.winNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        OutputView.bonusNumberMessage();
        while (true) {
            try {
                bonusNumber = Integer.parseInt(InputView.insert());
                Lotto.validateBonusNumber(bonusNumber, winNumber);
                break; // 유효한 보너스 번호가 입력되면 반복 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Map<Rank, Integer> rankCount;
        rankCount = Lotto.calculateWinningResults(lottoTickets,winNumber,bonusNumber);

        int totalPrize = OutputView.printWinningStatistics(rankCount);

        OutputView.outputReturnRate(totalPrize, price);
    }
}

