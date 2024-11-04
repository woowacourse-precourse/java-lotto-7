package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputLottoNum {
    public List<Integer> inputLottoWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String inputs = Console.readLine();
        String[] splitInputs = inputs.split(",");   // 쉼표를 구분자로 문자열을 나눔

        List<String> trimmedList = new ArrayList<>();     // 문자열 리스트
        for (String s : splitInputs) {
            trimmedList.add(s.trim());                    // 앞뒤 공백 제거 후 리스트에 추가
        }

        List<Integer> lottoNum = new ArrayList<>();      // 정수 리스트
        changeType(trimmedList, lottoNum);

        return lottoNum;
    }

    // 문자열을 정수로 변환
    public List<Integer> changeType(List<String> trimmedList, List<Integer> lottoNum) {
        try {
            for (String s : trimmedList) {
                lottoNum.add(Integer.parseInt(s));           // 문자열을 정수로 변환하여 추가
            }
            return lottoNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨번호에 실수, 기호, 문자가 들어갈 수 없습니다.\n정수만 입력해 주세요.");
        }
    }
}
