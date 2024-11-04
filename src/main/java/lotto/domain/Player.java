package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.InputValidator;

public class Player {
    private int money;
    private List<Lotto> lottoTickets;

    public Player(String money) {
        InputValidator.validateNonEmptyAmount(money);
        InputValidator.validateNumericAmount(money);
        this.money = Integer.parseInt(money);
        this.lottoTickets = new ArrayList<>();
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getMoney() {
        return money;
    }

    public void addLottoTickets(List<Lotto> newTickets) {
        this.lottoTickets.addAll(newTickets);
    }

    public double calculateProfitRate(int prize) {
        return ProfitCalculator.calculateProfitRate(prize, money);
    }
}
