package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String inputPrice;
        while (true){
            System.out.println("구입금액을 입력해 주세요.");
            inputPrice = Console.readLine();
            try{
                Validation.validatePrice(inputPrice);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        int quantity = Integer.parseInt(inputPrice) / 1000;

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.createLotto(quantity);
    }
}
