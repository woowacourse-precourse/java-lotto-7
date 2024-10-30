package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.PurchaseQuantity;
import lotto.util.ParserNums;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final ParserNums parser;

    private final LottoManager lottoManager;

    public LottoController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.parser = new ParserNums();
        this.lottoManager = new LottoManager();
    }

    public void getPurchasePrice(){ //구매 금액 입력
        boolean check = false;
        while(!check){
            outputView.printPurchasePriceMessage();
            String price = inputView.inputValue();
            try {
                lottoManager.setPurchaseQuantity(new PurchaseQuantity(price));
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
}
