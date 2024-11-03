package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private static final String split = ",";

    public int purchaseLotto(){
       return Integer.parseInt(Console.readLine());
    }

    public List<Integer> lottoNumber(String[] lottoInput){
        Integer[] lottoNumber = new Integer[lottoInput.length];

        for(int i = 0; i < lottoInput.length; i++){
            lottoNumber[i] = Integer.parseInt(lottoInput[i]);
        }

        return List.of(lottoNumber);
    }

    public String[] lottoInput(){
        String lottoInput = Console.readLine();
        return lottoInput.split(split);
    }

}
