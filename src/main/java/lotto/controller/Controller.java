package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Seller;
import lotto.model.WinningNumber;
import lotto.view.Input;
import lotto.view.Output;

public class Controller {
    private final Input input;
    private final Output output;
    private final Seller seller;
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;
    private Buyer buyer;

    public Controller(Input input, Output output, Seller seller, WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.input = input;
        this.output = output;
        this.seller = seller;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public void run() {
        orderLotto();
        setWinningNumber();
        setBonusNumber();
        matchLotto();
        resultLotto();
    }

    private void orderLotto() {
        while (true) {
            try {
                String money = input.pay();
                seller.validate(money);
                List<Lotto> lottos = seller.createLottoTickets(Integer.parseInt(money));
                output.printPayResult(lottos);
                buyer = new Buyer(lottos);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setWinningNumber() {
        while (true) {
            try {
                String winningNumberStr = input.winningNumber();
                winningNumber.validate(winningNumberStr);
                winningNumber.setNumbers(winningNumberStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setBonusNumber() {
        while (true) {
            try {
                String bonusNumberStr = input.bonusNumber();
                bonusNumber.validate(bonusNumberStr);
                bonusNumber.setNumber(Integer.parseInt(bonusNumberStr));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void matchLotto() {
        buyer.matchLottos(winningNumber.getNumbers(), bonusNumber.getNumber());
    }

    private void resultLotto() {
        output.lottoResultTitle();

        output.lottoResultWinning(Rank.FIFTH, buyer.getResultLotto().get(Rank.FIFTH));
        output.lottoResultWinning(Rank.FOURTH, buyer.getResultLotto().get(Rank.FOURTH));
        output.lottoResultWinning(Rank.THIRD, buyer.getResultLotto().get(Rank.THIRD));
        output.lottoResultWinning(Rank.SECOND, buyer.getResultLotto().get(Rank.SECOND));
        output.lottoResultWinning(Rank.FIRST, buyer.getResultLotto().get(Rank.FIRST));

        output.lottoResultTotalRevenue(buyer.getTotalRevenue());
    }
}
