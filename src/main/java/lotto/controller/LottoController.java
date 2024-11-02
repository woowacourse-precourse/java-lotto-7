package lotto.controller;

import lotto.constant.Rank;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.PurchaseQuantity;
import lotto.util.ParserNums;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final ParserNums parser;

    private final LottoManager lottoManager;

    private List<Lotto> lottos;

    public LottoController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.parser = new ParserNums();
        this.lottoManager = new LottoManager();
    }

    public LottoController(InputView inputView, OutputView outputView, ParserNums parser, LottoManager lottoManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
        this.lottoManager = lottoManager;
    }

    public void getPurchasePrice(){ //구매 금액 입력
        boolean check = false;
        while(!check){
            outputView.printPurchasePriceMessage();
            String price = inputView.inputValue();
            try {
                lottoManager.setPurchaseQuantity(new PurchaseQuantity(price));
                outputView.printPurchaseLottoQuantity(lottoManager.getPurchaseQuantity().getPurchaseQuantity());
                check = true;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public void getWinningNumbers(){ //당첨 번호 입력
        boolean check = false;
        while(!check){
            outputView.printWinningNumbersMessage();
            String winnigNumbers = inputView.inputValue();
            try{
                List<Integer> winningNums = parser.parsingWinningNums(winnigNumbers);
                lottoManager.setWinningLotto(new Lotto(winningNums));
                check = true;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public void getBonusNumber(){ //보너스 번호 입력
        boolean check = false;
        while(!check){
            outputView.printBonusNumberMessage();
            String bonus = inputView.inputValue();
            try{
                lottoManager.setBonusNumber(new BonusNumber(bonus));
                check = true;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public void purchaseLotto(){ //로또 구매(발행)
        this.lottos = lottoManager.publishLotto();
        outputView.printLotto(lottos);
    }

    public void printResult(){ //결과 출력
        HashMap<Rank, Integer> result = matchingLotto();
        outputView.printResult(result);
    }

    public HashMap<Rank, Integer> matchingLotto(){ //로또 맞추기
        return lottoManager.matchingLotto();
    }

    public void printProfitRate(){ //수익률 출력
        double profitRate = lottoManager.calculateFinalResult();
        outputView.printProfitRate(profitRate);
    }
}
