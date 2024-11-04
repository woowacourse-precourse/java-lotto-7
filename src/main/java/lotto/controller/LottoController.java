package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoConstants;
import lotto.model.lotto.LottoWinningNumbers;
import lotto.model.lottoPurchaser.LottoPurchaser;
import lotto.util.*;
import lotto.view.InputProvider;
import lotto.view.lottoPurchaseView.LottoPurchaseInputView;
import lotto.view.lottoPurchaseView.LottoPurchaseOutputView;
import lotto.view.winningLottoView.LottoProfitOutputView;
import lotto.view.winningLottoView.WinningLottoOutputViewFactory;
import lotto.view.winningLottoView.WinningLottoInputView;
import lotto.view.winningLottoView.WinningLottoOutputView;

import java.util.List;
import java.util.Set;

public class LottoController {

    private final InputProvider inputProvider;
    private final NumberConverter numberConverter = new NumberConverter();
    private final LottoPurchaseOutputView lottoPurchaseOutputView = new LottoPurchaseOutputView();
    private final WinningLottoOutputView winningLottoOutputView;
    private final LottoProfitOutputView lottoProfitOutputView;


    public LottoController(InputProvider inputProvider, WinningLottoOutputViewFactory outputViewFactory){
        this.inputProvider = inputProvider;
        this.winningLottoOutputView = outputViewFactory.createWinningLottoOutputView();
        this.lottoProfitOutputView = outputViewFactory.createLottoProfitOutputView();
    }

    public void startLotto(){
        LottoPurchaseInputView inputView = new LottoPurchaseInputView(inputProvider, numberConverter);
        int lottoPurchasePrice = getLottoPurchasePrice(inputView);
        int lottoPurchaseCount = calculateLottoCount(lottoPurchasePrice);

        LottoPurchaser lottoPurchaser = new LottoPurchaser(lottoPurchasePrice);

        printLottoPurchaseCount(lottoPurchaseCount);
        issueLottos(lottoPurchaser, lottoPurchaseCount);
        showLottoResult(lottoPurchaser, getWinningLottoNumbers());
    }

    private int getLottoPurchasePrice(LottoPurchaseInputView inputView){
        return inputView.getPurchasePrice();
    }

    private int calculateLottoCount(int lottoPurchasePrice){
        return lottoPurchasePrice/ LottoConstants.PRICE;
    }

    private void printLottoPurchaseCount(int lottoCount){
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
        WinningLottoInputView inputView = new WinningLottoInputView(inputProvider, numberConverter);
        Set<Integer> winningLottoNumbers = inputView.inputWinningLottoNumbers();
        int bonusNumber = inputView.inputBonusNumbers(winningLottoNumbers);
        return new LottoWinningNumbers(winningLottoNumbers, bonusNumber);
    }

    private void showLottoResult(LottoPurchaser lottoPurchaser, LottoWinningNumbers winningNumbers){
        winningLottoOutputView.showLottoResult(lottoPurchaser.calculateLottoResult(winningNumbers));
        lottoProfitOutputView.showLottoProfitRate(lottoPurchaser.calculateProfitRate());
    }


}
