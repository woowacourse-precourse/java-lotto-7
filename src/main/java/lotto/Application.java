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
    private Lotto winningLotto = null;
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

    //입력 검증 메소드
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
        try{
            int bonusNum = Integer.parseInt(input);
            return bonusNum;
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("보너스 넘버는 정수 1개여야 합니다.");
        }
    }

    //사용자 입력받는 메소드
    public void getPurchaseAmount(){
        while(true){
            System.out.println("구입금액을 입력해 주세요."); // 사용자에게 안내 메시지 출력
            String input = Console.readLine();
            try{
                validatePurchaseAmount(input);
                this.purchaseAmount = Integer.parseInt(input);
                break;
            }
            catch(IllegalArgumentException e){
                System.out.println("[ERROR] "+ e.getMessage());
            }
        }
    }

    public void getWinningLottoNum(){
        if(this.winningLotto!=null){
            throw new IllegalStateException("이미 당첨번호를 입력 받았습니다.");
        }
        while(true){
            System.out.println("\n당첨 번호를 입력해주세요.");
            try{
                List<Integer> winningLottoNum = validateWinningLotto(Console.readLine());
                this.winningLotto = new Lotto(winningLottoNum);
                break;
            }
            catch(IllegalArgumentException e){
                System.out.println("[ERROR] "+ e.getMessage());
            }
        }

    }

    public void getWinningBonusNum(){
        while(true){
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try {
                int bonusNum = validateBonusNum(Console.readLine());
                if (this.winningLotto.getNumbers().contains(bonusNum)) {
                    throw new IllegalArgumentException("보너스 번호는 로또 번호와 동일할 수 없습니다.");
                }
                this.bonusNumber = bonusNum;
                break;
            }
            catch(IllegalArgumentException e){
                System.out.println("[ERROR] "+e.getMessage());
            }
        }
    }


    //로또 생성 메소드
    public void generateLottos(){
        int lottoCount = this.calculateLottoCount(this.purchaseAmount);
        for(int i=0;i<lottoCount;i++){
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        System.out.printf("%d개를 구매했습니다.%n",lottoCount);
    }

    //로또 매수 계산 메소드
    public int calculateLottoCount(int purchaseAmount){
        return purchaseAmount / this.lottoPrice;
    }


    //로또 무작위 번호 생성 메소드
    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return numbers;
    }

    //로또 번호 출력 메소드
    public void printLotto(){
        for (Lotto lotto:lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    //당첨 통계 계산하는 메소드
    public void checkWinningStatus(){
        for (Lotto lotto:lottos){
           List<Integer> copyLottoNumbers = lotto.getNumbers();

           copyLottoNumbers.retainAll(this.winningLotto.getNumbers());
           int matchingCount = copyLottoNumbers.size();
           boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

           WinningStatistics matchEnum = findWinningStatistics(matchingCount,hasBonus);

           if(matchEnum!=null) {
               winningCountMap.put(matchEnum, winningCountMap.getOrDefault(matchEnum, 0) + 1);
           }
        }

    }

    //당첨 상수 찾는 메소드
    private WinningStatistics findWinningStatistics(int matchingCount, boolean hasBonus) {
        for (WinningStatistics stats : WinningStatistics.values()) {
            if (stats.getMatchCount() == matchingCount) {
                if (stats == WinningStatistics.FIVE_MATCH_BONUS && hasBonus) {
                    return WinningStatistics.FIVE_MATCH_BONUS;
                }
                if (stats != WinningStatistics.FIVE_MATCH_BONUS) {
                    return stats;
                }
            }
        }
        return null; // 해당 없음
    }

    //수익률 계산 메소드
    public void calculateEarnRate() {

        double totalPrize = this.winningCountMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue()) // 상금 * 개수
                .sum();


        this.earnRate = totalPrize/ this.purchaseAmount * 100;
    }

    //당첨 내역 출력 메소드
   public void printWinningResult() {
       System.out.println();
       System.out.println("당첨 통계");
       System.out.println("---");
       for (WinningStatistics winningStatistics : WinningStatistics.values()) {
           int count = winningCountMap.getOrDefault(winningStatistics, 0);
           System.out.printf("%s (%,d원) - %d개%n",
                   winningStatistics.getDescribe(),
                   winningStatistics.getPrize(),
                   count);
       }

       System.out.printf("총 수익률은 %.1f%%입니다.%n", this.earnRate);
   }



}
