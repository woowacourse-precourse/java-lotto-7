package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    LottoService lottoService = new LottoService();

    public int numberOfTickets() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchase = Console.readLine();

            try{
                return lottoService.getNumberOfTickets(purchase);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

}
