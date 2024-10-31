package lotto.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SequencedMap;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.utils.Converter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private Lotto lotto;

    public void run() {
        String inputMoney = InputView.promptPurchaseAmount();
        int lottoCount = Integer.parseInt(inputMoney) / 1000;
        OutputView.printPurchaseCount(lottoCount);
        LottoTickets lottoTickets = LottoTickets.generateLottoTickets(lottoCount);

        List<List<Integer>> lottoNumbers = lottoTickets.getLottoTickets();
        OutputView.printLottoTickets(lottoNumbers);

        String inputWinningNumbers = InputView.promptPurchaseWinningNumber();
        String[] inputsWinningNumbers = inputWinningNumbers.split(",");

        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < inputsWinningNumbers.length; i++) {
            winningNumbers.add(Converter.stringToInt(inputsWinningNumbers[i]));
        }

        String inputBonus = InputView.promptPurchaseBonusNumber();
        int bonusNumber = Converter.stringToInt(inputBonus);

        OutputView.printWinningStatistics();

        SequencedMap<Rank, Integer> results = new LinkedHashMap<>();

        for (Rank value : Rank.values()) {
            results.put(value, 0);
        }

        for (List<Integer> lottoNumber : lottoNumbers) {
            int matchCount = 0;
            boolean matchBonus = false;

            for (Integer number : lottoNumber) {
                if (winningNumbers.contains(number)) {
                    matchCount++;
                }
                if (number == bonusNumber) {
                    matchBonus = true;
                }
            }

            Rank rank = Rank.matchLotto(matchCount, matchBonus);
            results.put(rank, results.get(rank) + 1);
        }

        System.out.println(results);


    }
}

