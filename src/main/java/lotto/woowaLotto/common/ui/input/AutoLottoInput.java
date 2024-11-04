package lotto.woowaLotto.common.ui.input;

import camp.nextstep.edu.missionutils.Console;

public class AutoLottoInput implements Input{


    @Override
    public String inputLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String price =  Console.readLine();
        System.out.println();
        return price;
    }

    @Override
    public String inputPickedNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String pickedNum = Console.readLine();
        System.out.println();
        return pickedNum;
    }

    @Override
    public String inputBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        System.out.println();
        return bonusNum;
    }
}
