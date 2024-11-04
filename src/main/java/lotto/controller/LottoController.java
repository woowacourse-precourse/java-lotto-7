package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;
import service.LottoResultService;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoResultService lottoResultService;

    public LottoController(InputView inputView, OutputView outputView, LottoResultService lottoResultService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoResultService = lottoResultService;
    }

    public void run() {
        List<Lotto> lottos = getMoneyAndBuyLotto();

        printPublicedLottos(lottos);

        Lotto winningLotto = getWinningLotto();

        Integer bonusNumber = getBonusLottoNumber(winningLotto);

        Map<LottoRank, Integer> lottoResult = lottoResultService.getLottoResult(lottos, winningLotto, bonusNumber);

        printLottoResult(lottoResult, lottos.size());

    }

    public List<Lotto> getMoneyAndBuyLotto() {
        try {
            outputView.showHowMuchMoneyToBuyLotto();
            int moneyForLotto = inputView.getLottoBuyMoney();
            LottoGenerator lottoGenerator = LottoGenerator.of(moneyForLotto);
            return lottoGenerator.publicLottos(); // 입력이 올바르면 로또 리스트 반환
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getMoneyAndBuyLotto();
        }
    }


    private void printPublicedLottos(List<Lotto> lottos) {
        outputView.showPublicedLottos(lottos);
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                outputView.enterWinningNumberForLotto();
                List<Integer> lottoNum = inputView.getWinningLottoNum();
                return new Lotto(lottoNum);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer getBonusLottoNumber(Lotto winningLotto) {
        while (true) {
            try {
                outputView.enterBonusNumberForLotto();
                Integer bonusNum = inputView.getBonnusLottoNum();
                winningLotto.validateBonusNumber(bonusNum);
                return bonusNum;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLottoResult(Map<LottoRank, Integer> lottoResult, int lottoNumber) {
        outputView.showLottoResults(lottoResult);
        double profitRate = lottoResultService.getProfitRate(lottoResult, lottoNumber);
        outputView.showProfitRate(profitRate);
    }
}
