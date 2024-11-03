package lotto.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.LottoGenerate;
import lotto.model.LottoTickets;

public class LottoController {
    LottoTickets lottoTickets;
    Set<Integer> winningNumbers = new HashSet<>();
    int purchaseAmount;
    int bonusNumber;

    public LottoController() {
        set();
    }

    private void set() {
        purchaseAmount = IOController.setPurchaseAmount();
        lottoTickets = new LottoTickets(makeTickets(purchaseAmount));
        IOController.outputLottoTickets(purchaseAmount, lottoTickets);
        winningNumbers = IOController.setWinningNumber();
        bonusNumber = IOController.setBonusNumber(winningNumbers);
    }

    private List<List<Integer>> makeTickets(int amount) {
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            tickets.add(new ArrayList<>(makeLotto()));
        }

        return tickets;
    }

    private List<Integer> makeLotto() {
        LottoGenerate lottoGenerate = new LottoGenerate();
        List<Integer> lotto;
        lotto = lottoGenerate.generate();

        return lotto;
    }
}
