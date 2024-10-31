package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.round;

public class Application {
    public static final String LOTTO_WINNING_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String LOTTO_BONUS_INPUT = "보너스 번호를 입력해 주세요.";
    public static final String WIN_STATICS = "당첨 통계\n---";
    public static final String COMMA = ",";
    public static final String BLANK = "";

    public static void main(String[] args) {
        View view = new View();
        Integer purchasePrice = view.getPurchaseAmount();
        Integer lottoCount = view.getLottoCount();
        List<Lotto> lottoList = new ArrayList<>();
        lottoList = Lotto.sortLottoList(lottoCount, lottoList);

        System.out.println(LOTTO_WINNING_INPUT);
        String rawWinningInput = Console.readLine();
        Lotto answer = new Lotto(checkWinNumber(rawWinningInput));
        System.out.println(LOTTO_BONUS_INPUT);
        String rawBonus  = Console.readLine();
        Integer bonus = parseInt(rawBonus);
        checkLottoRange(bonus);
        List<MyResult> resultList = new ArrayList<>();
        //로또 결과 저장하기
        for(int i = 0; i < lottoCount; i++){
            MyResult gradedLotto = Lotto.gradeLotto(answer, lottoList.get(i), bonus);
            resultList.add(gradedLotto);
        }
        GradeSaver gradeSaver = new GradeSaver();
        gradeSaver = gradeSaver.sumUpGrades(resultList);
        MyResult.printResults(gradeSaver);
        Integer revenue = MyResult.getRevenue(gradeSaver);
        System.out.println("총 수익률은 " + getReturn(purchasePrice, revenue) + "%입니다.");
    }

    public static Integer parseInt(String input) {
        int result = 0;
        try{
            result = Integer.parseInt(input);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 기입해주세요.");
        }
        return result;
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

    public static double getReturn(Integer purchasePrice, Integer revenue){
        double myReturn = (double)revenue / (double)purchasePrice * 100;
        return Math.round(myReturn * 100)/100.0;
    }
}
