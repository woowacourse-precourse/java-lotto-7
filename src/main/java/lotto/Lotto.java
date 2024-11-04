package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

enum Rank {
    FAIL("0",0), FIFTH("5,000", 3) , FOURTH("50,000", 4), THIRD("1,500,000", 5),
    SECOND("30,000,000", 5, true), FIRST("2,000,000,000", 6);

    private final String price;
    private final int match;
    private final boolean bonusMatch;
    private Rank(String price, int match) {
        this.price = price;
        this.match = match;
        this.bonusMatch = false;
    }
    private Rank(String price, int match, boolean bonusMatch) {
        this.price = price;
        this.match = match;
        this.bonusMatch = bonusMatch;
    }

    public final String getPrice() {
        return price;
    }
    public final int getMatch() {
        return match;
    }
    public final boolean isBonusMatch() {
        return bonusMatch;
    }
}

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
        winningNums = inputWinnNums();
        seperateParagraph();

        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNum = Integer.parseInt(Console.readLine());
        winningNums.add(bonusNum);
        seperateParagraph();

        System.out.println("당첨 통계");
        System.out.println("---");
        printResult(lottos, winningNums);
        seperateParagraph();

        //출력
    }

    private static void printResult(
            final List<Lotto> lottos,
            final List<Integer> winningNums
    ) {

        final List<Rank> winResult = cntWinningLottos(lottos, winningNums);
        for(Rank rk : Rank.values()){
            if(rk.equals(Rank.FAIL)) continue;
            String price = rk.getPrice();
            int match = rk.getMatch();
            int matchedCnt = cntMatched(winResult, rk);
            //보너스볼 일치
            if(rk.equals(Rank.SECOND)){
                System.out.println(match + "개 일치, 보너스 볼 일치 (" + price + "원) - " + matchedCnt + "개");
            } else {
                System.out.println(match + "개 일치 (" + price + "원) - " + matchedCnt + "개");
            }
        }
        //수익률
        int sumReturnPrize = accumulateProfit(winResult);
        float totalLottoPrice = lottos.size() * 1000;
        float rateReturn = sumReturnPrize / totalLottoPrice;
        System.out.printf("총 수익률은 %.1f%%입니다.", rateReturn * 100);

    }

    private static int accumulateProfit(final List<Rank> winResult) {
        int sum = 0;
        for(Rank rk : Rank.values()){
            for(Rank result : winResult){
                if(result.equals(rk)){
                    sum += parsingPrice(rk.getPrice());
                }
            }
        }
        return sum;
    }

    private static int parsingPrice(String price) {
        return Integer.parseInt(price.replace(",",""));
    }

    private static int cntMatched(List<Rank> winResult, Rank rk) {
        return Collections.frequency(winResult, rk);
    }

    public static List<Rank> cntWinningLottos(
            final List<Lotto> lottos,
            final List<Integer> winningNums
    ) {
        List<Rank> winningResults = new ArrayList<>();
        boolean bonusMatch = false;

        for(Lotto lotto : lottos) {
            int matchedNum = compareBasicNum(lotto,winningNums);
            if(isBonusMatched(lotto, winningNums)){
                matchedNum++;
                bonusMatch = true;
            }

            //Rank match와 matchCnt 비교해서 enum 뽑아오는 코드
            winningResults.add(announceResult(matchedNum,bonusMatch));

            bonusMatch = false;
        }

        return winningResults;
    }

    private static Rank announceResult(int matchedNum, boolean bonusMatch) {
        for(Rank rk : Rank.values()) {
            if (rk.getMatch() == matchedNum) {
                if (rk.getMatch() == 5 && bonusMatch) {
                    return Rank.SECOND;
                }
                return rk;
            }
        }
        return Rank.FAIL;
    }

    public static boolean isBonusMatched(Lotto lotto, List<Integer> winningNums) {
        for(int num : lotto.numbers){
            if(num == winningNums.getLast()){
                return true;
            }
        }
        return false;
    }

    public static int compareBasicNum(
            final Lotto lotto,
            final List<Integer> winningNums
    ) {
        int matchCnt = 0;
        for(int i=0;i < winningNums.size() -1;i++) {
            int num = winningNums.get(i);
            if(lotto.numbers.contains(num)) {
                matchCnt++;
            }
        }
        return matchCnt;
    }




    private static List<Integer> inputWinnNums() {
        String nums = Console.readLine();
        return parseNum(nums);
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
