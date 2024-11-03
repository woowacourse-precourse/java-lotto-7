package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private static final String split = ",";

    public int purchaseLotto(){
        System.out.println("구입금액을 입력해 주세요.");
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
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoInput = Console.readLine();
        return lottoInput.split(split);
    }

    public int lottoBonus(){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

}
