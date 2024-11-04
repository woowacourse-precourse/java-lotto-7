package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoConstants;
import lotto.model.lotto.LottoWinningNumbers;
import lotto.model.lottoPurchaser.LottoPurchaser;
import lotto.util.*;
import lotto.view.InputProvider;
import lotto.view.LottoInputViewFactory;
import lotto.view.lottoPurchaseView.LottoPurchaseInputView;
import lotto.view.lottoPurchaseView.LottoPurchaseOutputView;
import lotto.view.winningLottoView.*;

import java.util.List;
import java.util.Set;

public class LottoController {

    private final LottoPurchaseOutputView lottoPurchaseOutputView = new LottoPurchaseOutputView();
    private final WinningLottoOutputView winningLottoOutputView;
    private final LottoProfitOutputView lottoProfitOutputView;
    private final LottoPurchaseInputView lottoPurchaseInputView;
    private final WinningLottoInputView winningLottoInputView;


    public LottoController(InputProvider inputProvider, LottoInputViewFactory lottoInputViewFactory,
                           WinningLottoOutputViewFactory outputViewFactory)
    {
        NumberConverter numberConverter = new NumberConverter();
        this.lottoPurchaseInputView = lottoInputViewFactory.createLottoPurchaseInputView(inputProvider, numberConverter);
        this.winningLottoInputView = lottoInputViewFactory.createWinningLottoInputView(inputProvider, numberConverter);
        this.winningLottoOutputView = outputViewFactory.createWinningLottoOutputView();
        this.lottoProfitOutputView = outputViewFactory.createLottoProfitOutputView();
    }

    public void startLotto(){
        int lottoPurchasePrice = getLottoPurchasePrice(lottoPurchaseInputView);
        int lottoPurchaseCount = calculateLottoCount(lottoPurchasePrice);

        LottoPurchaser lottoPurchaser = new LottoPurchaser(lottoPurchasePrice);

        showLottoPurchaseCount(lottoPurchaseCount);
        issueLottos(lottoPurchaser, lottoPurchaseCount);
        showLottoResult(lottoPurchaser, getWinningLottoNumbers());
    }

    private int getLottoPurchasePrice(LottoPurchaseInputView inputView){
        return inputView.getPurchasePrice();
    }

    private int calculateLottoCount(int lottoPurchasePrice){
        return lottoPurchasePrice/ LottoConstants.PRICE;
    }

    private void showLottoPurchaseCount(int lottoCount){
        lottoPurchaseOutputView.showLottoPurchaseCount(lottoCount);
    }

    private void issueLottos(LottoPurchaser lottoPurchaser, int lottoCount){
        for (int i=0; i<lottoCount; i++){
            List<Integer> issuedLotto = issueOneLotto();
            lottoPurchaser.addLotto(new Lotto(issuedLotto));
            showIssuedLotto(issuedLotto);
        }
    }

    private List<Integer> issueOneLotto(){
        return LottoNumberGenerator.generateRandomNumbers();
    }

    private void showIssuedLotto(List<Integer> issuedLotto){
        lottoPurchaseOutputView.showIssuedLottoNumbers(issuedLotto);
    }

    private LottoWinningNumbers getWinningLottoNumbers() {
        Set<Integer> winningLottoNumbers = winningLottoInputView.inputWinningLottoNumbers();
        int bonusNumber = winningLottoInputView.inputBonusNumbers(winningLottoNumbers);
        return new LottoWinningNumbers(winningLottoNumbers, bonusNumber);
    }

    private void showLottoResult(LottoPurchaser lottoPurchaser, LottoWinningNumbers winningNumbers){
        winningLottoOutputView.showLottoResult(lottoPurchaser.calculateLottoResult(winningNumbers));
        lottoProfitOutputView.showLottoProfitRate(lottoPurchaser.calculateProfitRate());
    }
}
