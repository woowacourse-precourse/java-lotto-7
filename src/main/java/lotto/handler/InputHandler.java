package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.PurchaseAmount;
import lotto.SpecialNumber;
import lotto.WinningNumber;

public class InputHandler {

    public PurchaseAmount inputPurChaseAmount(){

        System.out.println("구입금액을 입력해 주세요.");

        while(true){
            try{
                PurchaseAmount purchaseAmount = new PurchaseAmount(Console.readLine());
                return purchaseAmount;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumber inputWinningLottoNumber(){

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningRegularLotto = getWinningRegularLotto();
        System.out.println("보너스 번호를 입력해 주세요.");
        return getWinningNumber(winningRegularLotto);
    }

    private  WinningNumber getWinningNumber(final Lotto winningRegularLotto) {
        while(true){
            try{
                SpecialNumber specialNumber = new SpecialNumber(Console.readLine());
                WinningNumber winningNumber = new WinningNumber(winningRegularLotto,specialNumber);
                return winningNumber;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private  Lotto getWinningRegularLotto() {
        while(true){
            try{
                Lotto winningRegularLotto = Lotto.createWinningRegularLotto(Console.readLine());
                return winningRegularLotto;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }






}
