package lotto.model;

import java.util.List;
import lotto.view.Input;

public class Machine {
    protected Tickets createTickets() {
        Input input = new Input();
        do {
            try {
                int amount = input.requestAmount();
                Tickets tickets = new Tickets(amount);
                return tickets;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    protected Lotto createLottoNumbers() {
        Input input = new Input();
        do {
            try {
                List<Integer> winningNumbers = input.requestWinningNumbers();
                Lotto lottoNumbers = new Lotto(winningNumbers);
                return lottoNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    protected Jackpot createJackpotNumbers(Lotto lottoNumbers) {
        Input input = new Input();
        do {
            try {
                int bonusNumber = input.requestBonusNumber();
                Jackpot jackpot = new Jackpot(lottoNumbers, bonusNumber);
                return jackpot;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}