package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        chkSize(numbers);
        chkDuplicate(numbers);
    }

    private static void seperateParagraph(){
        System.out.println();
    }
    // TODO: 추가 기능 구현
    public static void run() throws IllegalArgumentException {

        System.out.println( "구입금액을 입력해 주세요." );
        int numLotto = divPriceBy1000(inputPrice());
        seperateParagraph();

        System.out.println( numLotto + "개를 구매했습니다." );
        List<Lotto> lottos = new ArrayList<>();
        setRandomLottos(lottos, numLotto);
        outputRandomLottos(lottos);
        seperateParagraph();

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNums = new ArrayList<>();
        setWinningNums(winningNums);
        seperateParagraph();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = Integer.parseInt(Console.readLine());
        seperateParagraph();

        System.out.println("당첨 통계");
        System.out.println("---");

        //출력
    }


    public static void setWinningNums(List<Integer> winningNums) {
        String nums = Console.readLine();
        winningNums = parseNum(nums);
        Console.close();
    }

    private static List<Integer> parseNum(String nums) {
        List<String> strNum = new ArrayList<>();
        strNum = List.of(nums.split(","));

        List<Integer> winningNums = new ArrayList<>();
        for(String num : strNum) {
            winningNums.add(Integer.parseInt(num));
        }

        return winningNums;
    }

    private static void outputRandomLottos(final List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            printNums(lotto);
        }
    }

    private static void printNums(final Lotto lotto) {
        int lastNum = lotto.numbers.getLast();

        System.out.print("[");
        for(int num : lotto.numbers){
            System.out.print(num);
            if(num != lastNum){
                System.out.print(", ");
            }
        }
        System.out.print("]\n");

    }

    private static void setRandomLottos(
            List<Lotto> lottos,
            final int numLotto
    ) {
        for(int i = 0; i < numLotto; i++){
            List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1,45,6);
            lottos.add(new Lotto(lottoNums));
        }
    }

    private static int inputPrice(){
        final int price = Integer.parseInt(Console.readLine());
        try{
            if (price%1000 != 0){
                throw new IllegalArgumentException("1,000원 단위로 입력해야 합니다.");
            }
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
            inputPrice();
        } finally{
            Console.close();
        }
        return price;
    }

    private static int divPriceBy1000(final int price){
        return price/1000;
    }

    private static void chkDuplicate(final List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()){
            throw new IllegalArgumentException("숫자가 중복되지 않아야 합니다.");
        }
    }

    private static void chkSize(final List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

}
