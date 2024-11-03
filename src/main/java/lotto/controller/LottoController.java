package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoArchive;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LottoController {
    private final LottoService lottoService;
    static int budget;
    static int lottoNumber;
    private LottoArchive lottoArchive;
    private WinningLotto winningLotto;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void lotto(){
        readUserBudget();
        printLottoNumber();
        generateLottos();
        printLottos();
        generateWinningNumbersAndBonusNumber();
    }

    public void readUserBudget(){
        OutputView.printBudgetInputDescription();
        budget = InputView.inputBudget();
        lottoNumber = budget/1000;
    }

    public void printLottoNumber(){
        OutputView.printLottoNumber(budget/1000);
    }

    public void generateLottos(){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoNumber; i++) {
            lottos.add(lottoService.createLotto());
        }
        lottoArchive = new LottoArchive(lottos);
    }

    public void printLottos(){
        List<Lotto> lottos = lottoArchive.getLottos();

        for (Lotto lotto : lottos ) {
            List<Integer> set = lotto.getNumbers();
            List<Integer> sortedSet = new ArrayList<>(set);
            Collections.sort(sortedSet);
            OutputView.printLotto(sortedSet);
        }
    }

    public Lotto readWinningNumber(){
        OutputView.printWinningNumberInputDescription();
        return new Lotto(InputView.inputWinningNumber());
    }

    public int readBonusNumber(){
        OutputView.printBonusNumberInputDescription();
        return InputView.inputBonusNumber();
    }

    public void generateWinningNumbersAndBonusNumber(){
        winningLotto = new WinningLotto(readWinningNumber(), readBonusNumber());
    }

}
