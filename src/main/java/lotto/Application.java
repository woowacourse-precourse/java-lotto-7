package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.round;

public class Application {
    public static final String LOTTO_AMOUNT_PHRASE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_COUNT_PHRASE = "개를 구매했습니다.";
    public static final String LOTTO_WINNING_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String LOTTO_BONUS_INPUT = "보너스 번호를 입력해 주세요.";
    public static final String WIN_STATICS = "당첨 통계\n---";
    public static final String COMMA = ",";
    public static final String BLANK = "";

    public static void main(String[] args) {
        System.out.println(LOTTO_AMOUNT_PHRASE);
        String rawPurchasePrice = Console.readLine();
        Integer purchasePrice = parseInt(rawPurchasePrice);
        Integer lottoCount = countLotto(purchasePrice);
        System.out.println(lottoCount + LOTTO_COUNT_PHRASE);
        List<Lotto> lottoList = new ArrayList<>();
        //로또들 출력...
        for(int i = 0; i < lottoCount; i++){
            Lotto newLotto = Lotto.sortLotto(Lotto.getLotto());
            lottoList.add(newLotto);
            Lotto.printLotto(newLotto);
        }
        System.out.println(LOTTO_WINNING_INPUT);
        String rawWinningInput = Console.readLine();
        Lotto answer = new Lotto(checkWinNumber(rawWinningInput));
        System.out.println(LOTTO_BONUS_INPUT);
        String rawBonus  = Console.readLine();
        Integer bonus = parseInt(rawBonus);
        List<MyResult> resultList = new ArrayList<>();
        //로또 결과 저장하기
        for(int i = 0; i < lottoCount; i++){
            MyResult gradedLotto = Lotto.gradeLotto(answer, lottoList.get(i), bonus);
            resultList.add(gradedLotto);
        }

        checkLottoRange(bonus);
        System.out.println(WIN_STATICS);
    }

    public static Integer parseInt(String input) {
        return Integer.parseInt(input);
    }

    public static Integer countLotto(Integer input){
        if(input % 1000 != 0){
            throw new IllegalArgumentException("1000원으로 나누어 떨어지는 금액을 입력해주세요.");
        }
        return input/1000;
    }

    public static boolean checkLottoRange(Integer input){
        if(input >= 1 && input <= 45) return true;
        throw new IllegalArgumentException("로또 정답은 1이상 45이하의 숫자여야합니다.");
    }

    public static List<Integer> checkWinNumber(String input){
        List<Integer>lottoNum = Arrays.asList(input.split(COMMA)).stream()
                .map(Application::parseInt)
                .collect(Collectors.toList());
        lottoNum.stream()
                .forEach(number -> checkLottoRange(number));
        return lottoNum;
    }

    public static double getReturn(Integer purchasePrice, Integer winnings){
        return Math.round((double)(winnings - purchasePrice)/100);
    }
}
