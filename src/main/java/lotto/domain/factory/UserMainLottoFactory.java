package lotto.domain.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.domain.lottos.Lotto;

/**
 * parse
 * Lotto 객체 반환
 *  - ,콤마 이외에 다른 특수문자가 존재하는가?
 *   - 숫자인가?
 *
 *   1,2,,3,4,5,6 -> ?????
 */
public class UserMainLottoFactory {

    public Lotto make(String input){
        String[] separatedInputValues = input.split(",");

        List<Integer> lottoNumber = convertToNumbers(separatedInputValues);
        validateSize(lottoNumber);
        return new Lotto(lottoNumber);
    }

    private List<Integer> convertToNumbers(String[] strArray) {
        List<Integer> lottoNumber = new ArrayList<>();

        for (String str : strArray) {
            validateContainSpecialCharacters(str);

            int num;
            try{
                num = Integer.parseInt(str.trim());
            }
            catch(NumberFormatException e){
                throw new IllegalArgumentException("로또 번호를 숫자로 입력해 주세요");
            }

            lottoNumber.add(num);
        }
        return lottoNumber;

    }


    private void validateContainSpecialCharacters(String value){
        Matcher matcher = Pattern.compile("[!@#$%^&*().?\":{}|<>]").matcher(value);
        if (matcher.find()) {
            throw new IllegalArgumentException("잘못된 구분자를 입력했습니다.");
        }
    }

    private void validateSize(List<Integer> lottoNumber){
        if(lottoNumber.size() != 6){
            throw new IllegalArgumentException("6개의 로또를 입력해주세요.");
        }
    }


}
