package lotto.view;

import lotto.domain.MoneyDTO;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {

    //print로 일관되게 사용하는게 좋아보인다.
    public void printMoneyInput(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    //문자가 들어오는지 숫자가 들어오는지 parseint로 예외처리
    //그러고 try-catch로 예외를 잡아서 다시 입력을 받을 수 있도록 해야함.
    //어디서 유효성 검사를 하고 어디까지를 나눠야할까 아 여기서 유효처리하자 그러고 다시 입력받기
    //빈 칸이나 null에 대한 것의 예외처리도 진행해야한다.
    public MoneyDTO getMoneyInput(){

        //제대로 된 값이 입력받을 때까지 반복
        while(true) {
            String input = readLine();
            try {
                int money = parseAndValidateInput(input);
                return new MoneyDTO(money);
            } catch (IllegalArgumentException e) {

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

