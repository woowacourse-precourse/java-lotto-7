package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.util.ParserNums;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final ParserNums parser;

    private LottoManager lottoManager;

    public LottoController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.parser = new ParserNums();
    }

    public void getPurchasePrice(){ //구매 금액 입력
        boolean check = false;
        while(!check){
            outputView.printPurchasePriceMessage();
            String price = inputView.inputPurchasePrice();
            try {
                this.lottoManager = new LottoManager(price);
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
            outputView.printWinnigNumbersMessage();
            String winnigNumbers = inputView.inputWinnigNumbers();
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
}
