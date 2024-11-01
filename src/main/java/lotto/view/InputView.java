package lotto.view;

import lotto.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final Validator validator;

    public InputView(Validator validator){
        this.validator = validator;
    }

    public int getLottoPrice(){
        while(true){
            try{
                String input = readLine();
                validator.isValidPrice(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }


}
