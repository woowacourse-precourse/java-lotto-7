package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    static LottoMachine machine = new LottoMachine();

    public static int parseInt(String s){
        try{
            return Integer.parseInt(s);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static List<Lotto> inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        while(true){
            try{
                return machine.buyLottos(parseInt(Console.readLine()));
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] "+e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        List<Lotto> lottos = inputPrice();


    }
}
