package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private final int lottoPrice = 1000;
    private int purchaseAmount;
    private List<Lotto> lottos = new ArrayList<>();
    private int bonusNumber;
    private double earnRate;
    private Lotto winningLotto;
    private Map<WinningStatistics,Integer> winningCountMap = new HashMap<>();

    public static void main(String[] args) {
        Application app = new Application();
        app.getPurchaseAmount();
        app.generateLottos();
        app.printLotto();
        app.getWinningLottoNum();
        app.getWinningBonusNum();
        app.checkWinningStatus();
        app.calculateEarnRate();
        app.printWinningResult();
    }

    private void validatePurchaseAmount(String input){
        try {
            int amount = Integer.parseInt(input);
            if (amount < lottoPrice) {
                throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
            }
            if (amount % lottoPrice != 0) {
                throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
            }
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("구입 금액은 정수여야 합니다.");
       }
    }

    private List<Integer> validateWinningLotto(String input){

        if(!input.matches("\\d[,\\d]*$")){
            throw new IllegalArgumentException("구분자는 콤마(,)이고 사이 공백이 없어야 합니다.");
        }
        String[] inputSplit  = input.split(",");
        List<Integer> validatedLottos = new ArrayList<>();

        for(String s :inputSplit ){
            validatedLottos.add(Integer.parseInt(s));
        }
        return validatedLottos;
    }

    private int validateBonusNum(String input){
/*        if(input.split("").length>1){
            throw new IllegalArgumentException("보너스 넘버는 1개여야 합니다.");
        }*/
        try{
            int bonusNum = Integer.parseInt(input);
            return bonusNum;
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("보너스 넘버는 정수여야 합니다.");
        }
    }
    public void getPurchaseAmount(){
       String input = Console.readLine();
        validatePurchaseAmount(input);
       this.purchaseAmount = Integer.parseInt(input);

    }

    public void getWinningLottoNum(){
        String input = Console.readLine();
        List<Integer> winningLottoNum = validateWinningLotto(input);
        this.winningLotto = new Lotto(winningLottoNum);

    }

    public void getWinningBonusNum(){
        String input = Console.readLine();
        this.bonusNumber = validateBonusNum(input);
    }


    public void generateLottos(){
        int lottoCount = this.calculateLottoCount(this.purchaseAmount);
        for(int i=0;i<lottoCount;i++){
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
    }

    public int calculateLottoCount(int purchaseAmount){
        return purchaseAmount / this.lottoPrice;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return numbers;
    }

    public void printLotto(){
        for (Lotto lotto:lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    //당첨 통계 계산하는 함수
    public void checkWinningStatus(){
        for (Lotto lotto:lottos){
           List<Integer> copyLottoNumbers = lotto.getNumbers();

           copyLottoNumbers.retainAll(this.winningLotto.getNumbers());
           int matchingCount = copyLottoNumbers.size();
           boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

           WinningStatistics matchEnum = getWinningStatistics(matchingCount,hasBonus);

           if(matchEnum!=null) {
               winningCountMap.put(matchEnum, winningCountMap.getOrDefault(matchEnum, 0) + 1);
           }
        }

    }

    private WinningStatistics getWinningStatistics(int matchingCount, boolean hasBonus){

        if(matchingCount==WinningStatistics.SIX_MATCH.getMatchCount()){
            return WinningStatistics.SIX_MATCH;
        }
        if((matchingCount==WinningStatistics.FIVE_MATCH_BONUS.getMatchCount())&&(hasBonus)){
            return WinningStatistics.FIVE_MATCH_BONUS;
        }
        if(matchingCount==WinningStatistics.FIVE_MATCH.getMatchCount()){
            return WinningStatistics.FIVE_MATCH;
        }
        if(matchingCount==WinningStatistics.FOUR_MATCH.getMatchCount()){
            return WinningStatistics.FOUR_MATCH;
        }
        if(matchingCount==WinningStatistics.THREE_MATCH.getMatchCount()){
            return WinningStatistics.THREE_MATCH;
        }

        return null; //해당없음
    }

    public void calculateEarnRate () {
        this.earnRate=  (this.winningCountMap.entrySet().stream().mapToDouble(entry->entry.getKey().getPrize()).sum())/this.purchaseAmount *100;

    }

   public void printWinningResult() {
       System.out.println("당첨 통계");
       System.out.println("---");
       for (WinningStatistics winningStatistics : WinningStatistics.values()) {
           int count = winningCountMap.getOrDefault(winningStatistics, 0);
           System.out.printf("%d개 일치 (%,d원) - %d개%n",
                   winningStatistics.getMatchCount(),
                   winningStatistics.getPrize(),
                   count);
       }

       System.out.printf("총 수익률은 %.1f%%입니다.%n", this.earnRate);
   }



}
