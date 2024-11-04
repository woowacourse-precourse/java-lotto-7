package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoConstant;
import lotto.model.lotto.LottoWinningNumbers;
import lotto.model.lottoBuyer.InMemoryLottoRepository;
import lotto.model.lottoBuyer.LottoBuyer;
import lotto.util.*;
import lotto.view.InputProvider;
import lotto.view.lottoPurchaseView.LottoPurchaseInputView;
import lotto.view.lottoPurchaseView.LottoPurchaseOutputView;
import lotto.view.lottoWinningView.LottoProfitOutputView;
import lotto.view.lottoWinningView.LottoWinningOutputViewFactory;
import lotto.view.lottoWinningView.WinningLottoInputView;
import lotto.view.lottoWinningView.WinningLottoOutputView;

import java.util.List;
import java.util.Set;

public class LottoController {

    private final InputProvider inputProvider;

    private final NumberConverter numberConverter = new NumberConverter();
    private final LottoPurchaseOutputView lottoPurchaseOutputView = new LottoPurchaseOutputView();

    private final WinningLottoOutputView winningLottoOutputView;
    private final LottoProfitOutputView lottoProfitOutputView;


    public LottoController(InputProvider inputProvider, LottoWinningOutputViewFactory outputViewFactory){
        this.inputProvider = inputProvider;
        this.winningLottoOutputView = outputViewFactory.createWinningLottoOutputView();
        this.lottoProfitOutputView = outputViewFactory.createLottoProfitOutputView();
    }

    public void startLotto(){
        int lottoPurchasePrice = getLottoPurchasePrice();

        LottoBuyer lottoBuyer = new LottoBuyer(lottoPurchasePrice, new InMemoryLottoRepository());

        int lottoCount = calculateLottoCount(lottoPurchasePrice);
        printLottoPurchaseCount(lottoCount);
        issueLottos(lottoBuyer, lottoCount);

        LottoWinningNumbers lottoWinningNumbers = getWinningLottoNumbers();
        printLottoResult(lottoBuyer, lottoWinningNumbers);
    }

    private void printLottoPurchaseCount(int lottoCount){
        lottoPurchaseOutputView.showLottoPurchaseCount(lottoCount);
    }

    private int getLottoPurchasePrice(){
        LottoPurchaseInputView inputView = new LottoPurchaseInputView(inputProvider, numberConverter);
        return inputView.getPurchasePrice();
    }

    private void issueLottos(LottoBuyer lottoBuyer, int lottoCount){
        for (int i=0; i<lottoCount; i++){
            List<Integer> issuedLotto = issueOneLotto();
            lottoBuyer.addLotto(new Lotto(issuedLotto));
            lottoPurchaseOutputView.showIssuedLottoNumbers(issuedLotto);
        }
    }

    private List<Integer> issueOneLotto(){
        return LottoNumberGenerator.generateLottoNumbers(LottoConstant.NUMBER_START_INCLUSIVE,
                LottoConstant.NUMBER_END_INCLUSIVE,
                LottoConstant.NUMBER_COUNT);
    }

    private LottoWinningNumbers getWinningLottoNumbers() {
        WinningLottoInputView inputView = new WinningLottoInputView(inputProvider, numberConverter);
        Set<Integer> winningLottoNumbers = inputView.inputWinningLottoNumbers();
        int bonusNumber = inputView.inputBonusNumbers(winningLottoNumbers);
        return new LottoWinningNumbers(winningLottoNumbers, bonusNumber);
    }

    private int calculateLottoCount(int lottoPurchasePrice){
        return lottoPurchasePrice/LottoConstant.PRICE;
    }

    private void printLottoResult(LottoBuyer lottoBuyer, LottoWinningNumbers lottoWinningNumbers){
        winningLottoOutputView.showLottoResult(lottoBuyer.calculateLottoResult(lottoWinningNumbers));
        lottoProfitOutputView.showLottoProfitRate(lottoBuyer.calculateProfitRate());
    }


}
