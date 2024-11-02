package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.implementation.bytecode.assign.primitive.VoidAwareAssigner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    private static int amountToPurchase;
    private static int numOfLotto;
    private static List<Lotto> lottos;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;
    public static void main(String[] args) {
        readUserInput();
    }

    public static void readUserInput(){
        System.out.println("구입금액을 입력해 주세요.");
        amountToPurchase = readAmountToPurchase();

        numOfLotto = calcNumOfLottos();
        System.out.println(numOfLotto + "개를 구매했습니다.");

        lottos = createLottos();
        lottos.forEach(System.out::println);

        boolean isValidInput = false;

        while(!isValidInput){
            try {
                System.out.println("당첨 번호를 입력해 주새요.");
                winningNumbers = readWinningNumbers();
                isValidInput = true;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        isValidInput = false;

        while(!isValidInput){
            try{
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = readBonusNumber();
                isValidInput = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static int readAmountToPurchase(){
        String input = Console.readLine();
        return (Integer.parseInt(input) / 1000) * 1000;
    }

    private static int calcNumOfLottos(){
        return numOfLotto = amountToPurchase / 1000;
    }

    private static List<Lotto> createLottos(){
        lottos = new ArrayList<>();

        for (int i = 0; i < numOfLotto; i++) {
            List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(uniqueNumbers);
            lottos.add(new Lotto(uniqueNumbers));
        }

        return lottos;
    }

    private static List<Integer> readWinningNumbers(){
        String input = Console.readLine();

        List<Integer> result = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();

        result.forEach(Application::validateLottoNumber);


        return result;
    }

    private static int readBonusNumber(){
        int bonusNum = Integer.parseInt(Console.readLine());

        validateLottoNumber(bonusNum);

        return bonusNum;
    }

    private static void validateLottoNumber(int num){
        if (num < 1 || num > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
