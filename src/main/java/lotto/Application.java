package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private final int lottoPrice = 1000;
    private int purchaseAmount;
    private List<Lotto> lottos = new ArrayList<>();
    public static void main(String[] args) {
        Application app = new Application();
        app.getPurchaseAmount();
        app.generateLottos();
        app.printLotto();
    }

    private void validate(String input){
        try {
            int amount = Integer.parseInt(input);
            if (amount < 1000) {
                throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
            }
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("구입 금액은 정수여야 합니다.");
       }
    }
    public void getPurchaseAmount(){
       String input = Console.readLine();
       validate(input);
       this.purchaseAmount = Integer.parseInt(input);

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


    // 로또 생성하는 함수

    //로또 번호 출력함수

    //당첨 번호 입력받는 함수

    //보너스번호 입력받는 함수

    //당첨 통계 계산하는 함수

    //수익률 계산하는 함수

    //당첨 통계와 수익률 출력하는 함수



}
