package lotto.view;

import lotto.Validator;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static final String ERROR_PREFIX = "[ERROR] ";

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
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }

    public String getWinningNumbers(){
        while(true){
            try{
                String input = readLine();
                validator.isValidLottoNumbers(input);
                return input;
            } catch (IllegalArgumentException e){
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }


}
