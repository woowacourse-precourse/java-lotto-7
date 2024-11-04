package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputLottoNumber {
    public List<Integer> inputLottoNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
        String lottoString = Console.readLine();

        String[] strArr = lottoString.split(",");

        List<Integer> lottoNumbers = new ArrayList<>();
        try{
            for (String str : strArr) {
                int number = Integer.parseInt(str.trim());
                lottoNumbers.add(number);
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 입력 가능합니다.");
        } if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        return lottoNumbers;
    }
}