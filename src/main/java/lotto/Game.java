package lotto;

import static lotto.view.input.Input.addtionBonusNumber;
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


        outputGetLottoNumbers(purchase.getPurchaseAccount());


        List<Integer> getInputWinNumbers = getInputWinNumbers();

        int bonusNumber = getBonusNumber();


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

    private void outputGetLottoNumbers(int getPurchaseAccount){
        System.out.println("");
        output.getLottoNumbers(getPurchaseAccount);
    }

    private List<Integer> getInputWinNumbers(){
        System.out.println("");
        System.out.println(getWinNumbers);
        while(true){
            try{
                List<Integer> getWinNumbers = input.getWinNumbers();
                Lotto lotto = new Lotto(getWinNumbers);
                return lotto.getWinningLottoNumbers();
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private int getBonusNumber(){
        System.out.println("");
        System.out.println(addtionBonusNumber);
        while (true){
            try{
                return input.getBonusNumber();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }
}
