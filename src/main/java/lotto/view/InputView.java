package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import lotto.controller.LottoController;
import java.util.List;
public class InputView {
    private LottoController controller;

    public void inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        controller.createLottoNumber(price);
    }

    public void inputNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String s;
        s = Console.readLine();
    }


    public InputView(){
        controller = new LottoController();
    }
}




