package lotto.view;

import lotto.domain.MoneyDTO;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {

    public void printMoneyInput(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printTicketNumber(MoneyDTO moneyDTO){
        System.out.println(moneyDTO.getTicketNumber()+"개를 구매했습니다.");
    }

    public MoneyDTO getMoneyInput(){

        //제대로 된 값이 입력받을 때까지 반복
        while(true) {
            String input = readLine();
            try {
                int money = parseAndValidateInput(input);
                return new MoneyDTO(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public int parseAndValidateInput(String input) {

        // 입력값이 빈 문자열이거나 null인지 검증
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 금액을 입력해 주세요.");
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.", e);
        }
    }

}

