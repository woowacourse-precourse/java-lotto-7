package lotto;

import static lotto.view.input.Input.getWinNumbers;
import static lotto.view.input.Input.purchaseAmountConsole;

import java.util.List;
import lotto.service.Lotto;
import lotto.service.Purchase;
import lotto.view.input.Input;
import lotto.view.output.Output;

public class Game {
    private final Input input = new Input();
    private final Output output = new Output();


    public void gameStart(){
        Purchase purchase = getPurchase();
        System.out.println("");

        outputGetLottoNumbers(purchase.getPurchaseAccount());
        System.out.println("");

        List<Integer> getInputWinNumbers = getInputWinNumbers();


    }

    private Purchase getPurchase(){
        System.out.println(purchaseAmountConsole);
        while(true){
            String purchaseAccount = input.purchaseAmount();

            try{
                Purchase purchase = new Purchase(purchaseAccount);
                return purchase;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getInputWinNumbers(){
        System.out.println(getWinNumbers);
        while(true){
            try{
                List<Integer> getWinNumbers = input.getWinNumbers();
                Lotto lotto = new Lotto(getWinNumbers);
                return lotto.getWinningLottoNumbers();
            }catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }


    private void outputGetLottoNumbers(int getPurchaseAccount){
        output.getLottoNumbers(getPurchaseAccount);
    }
}
