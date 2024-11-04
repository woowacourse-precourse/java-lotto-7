package lotto;

import static lotto.view.exception.ErrorMessage.validateLottoNumberDuplicate;
import static lotto.view.input.Input.addtionBonusNumber;
import static lotto.view.input.Input.getWinNumbers;
import static lotto.view.input.Input.purchaseAmountConsole;

import java.util.HashMap;
import java.util.List;
import lotto.service.Lotto;
import lotto.service.Purchase;
import lotto.service.Winner;
import lotto.view.input.Input;
import lotto.view.output.Output;

public class Game {
    private final Input input = new Input();
    private final Output output = new Output();


    public void gameStart(){
        Purchase purchase = getPurchase();
        //사용자가 뽑은 로또 갯수의 번호
        HashMap<Integer, List<Integer>> getLottoNumbers = outputGetLottoNumbers(purchase.getPurchaseAccount());

        //로또 6개 번호
        List<Integer> getInputWinNumbers = getInputWinNumbers();

        //보너스 번호
        int bonusNumber = getBonusNumber(getInputWinNumbers);

        Winner winner = new Winner(getInputWinNumbers, bonusNumber, getLottoNumbers);

        output.printStatistics(winner.getWinningsStats());
        output.printCalculateWinningsRate(winner.getCalculateReturnRate());



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

    private HashMap<Integer, List<Integer>> outputGetLottoNumbers(int getPurchaseAccount){
        System.out.println("");
        return output.getLottoNumbers(getPurchaseAccount);
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


    private int getBonusNumber(List<Integer> getInputWinNumbers){
        System.out.println("");
        System.out.println(addtionBonusNumber);
        while (true){
            try{
                int bonusNumber = input.getBonusNumber();
                containsBonusNumber(getInputWinNumbers, bonusNumber);
                return bonusNumber;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }

    private static void containsBonusNumber(List<Integer> getInputWinNumbers, int bonusNumber) {
        if(getInputWinNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(validateLottoNumberDuplicate);
        }
    }
}
