package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        List<Lotto> lottos = getMoneyAndBuyLotto();

        printPublicedLottos(lottos);

        Lotto winningLotto = getWinningLotto();


    }

    public List<Lotto> getMoneyAndBuyLotto(){
        while (true) {
            try {
                outputView.showHowMuchMoneyToBuyLotto();
                int moneyForLotto = inputView.getLottoBuyMoney();
                LottoGenerator lottoGenerator = LottoGenerator.of(moneyForLotto);
                return lottoGenerator.publicLottos(); // 입력이 올바르면 로또 리스트 반환
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printPublicedLottos(List<Lotto> lottos){
        outputView.showPublicedLottos(lottos);
    }

    private Lotto getWinningLotto(){
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

    private Integer getBonusLottoNumber(Lotto winningLotto){
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
}
