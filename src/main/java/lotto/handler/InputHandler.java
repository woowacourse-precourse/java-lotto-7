package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.PurchaseAmount;
import lotto.SpecialNumber;

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

    public Lotto inputWinningLottoNumber(){

        System.out.println("당첨 번호를 입력해 주세요.");

        while(true){
            try{
                Lotto winningLotto = Lotto.createWinningLotto(Console.readLine());
                return winningLotto;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }

    public SpecialNumber inputSpecialNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");

        return new SpecialNumber(Console.readLine());

    }





}
