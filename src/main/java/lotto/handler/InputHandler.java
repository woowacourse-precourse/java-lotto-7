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

        return new PurchaseAmount(Console.readLine());
    }

    public Lotto  inputWinningLottoNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");

        return Lotto.createWinningLotto(Console.readLine());
    }

    public SpecialNumber inputSpecialNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");

        return new SpecialNumber(Console.readLine());

    }





}
