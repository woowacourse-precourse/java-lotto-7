package lotto.controller;

import java.util.List;
import lotto.model.User;
import lotto.service.LottoService;
import lotto.util.InputParser;
import lotto.validator.AmountValidator;
import lotto.view.View;

public class LottoController {
    View view;
    LottoService lottoService;

    public LottoController(View view, LottoService lottoService) {
        this.view = view;
        this.lottoService = lottoService;
    }


    public void run(User user) {
        int amount = AmountValidator.isNumber(view.getUserInput());
        AmountValidator.checkAmount(amount);
        int numberOfTickets = amount / 1000;
        view.printPurchaseMessage(numberOfTickets);
        lottoService.provideLottoTickets(user, numberOfTickets);
        view.printLottoNumbers(user.getLottoTickets());
        String[] numbers = InputParser.splitNumbers(view.getWinningNumbers());
        List<Integer> winningNumbers = AmountValidator.isNumber(numbers);
        int bonusNumber = AmountValidator.isNumber(view.getBonusNumbers());
        lottoService.setAdditionalNumbers(winningNumbers, bonusNumber);
        //Map<Lotto, Integer> matchCounts = lottoService.countMatchingNumbersForAllTickets(winningNumbers);
        //System.out.println(matchCounts);
    }
}
