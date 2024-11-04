package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int getLottoBuyMoney(){
        String msg = Console.readLine();
        InputValidator.validateInput(msg);
        try{
            return Integer.parseInt(msg);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자 형식에 맞지 않습니다.");
        }
    }

    public List<Integer> getWinningLottoNum(){
        String msg = Console.readLine();
        InputValidator.validateInput(msg);
        try{
            return Arrays.stream(msg.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 숫자 형식에 맞지 않습니다.");
        }

    }

    public Integer getBonnusLottoNum(){
        String msg = Console.readLine();
        InputValidator.validateInput(msg);
        try{
            return Integer.parseInt(msg);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자 형식에 맞지 않습니다.");
        }
    }
}
