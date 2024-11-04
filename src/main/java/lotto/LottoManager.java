package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {
    private List<Lotto> lottos;
    private List<Integer> winningLotto;
    private int BonusNumber;
    private int count;
    private OutputView outputView=new OutputView();
    private InputView inputView=new InputView();

    private final Map<Rank,Integer> hit;


    public LottoManager() {
        this.lottos=new ArrayList<>();
        this.hit=new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            hit.put(rank, 0);
        }
    }

    public void run(){
        executeWithRetry(()->buyLottos(inputView.readMoney()));
        executeWithRetry(()->setWinningLotto(inputView.readWiningNumbers()));
        executeWithRetry(()->setBonus(inputView.readBonusNumbers()));
    }
    public void executeWithRetry(Runnable task) {
        while (true) {
            try {
                task.run();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    void setWinningLotto(List<Integer> winningLotto) {
        if(winningLotto.isEmpty()) throw new IllegalArgumentException("[ERROR] 올바른 값이 입력되지 않았습니다.숫자를 입력해주세요");
        if(winningLotto.size()!=6) throw new IllegalArgumentException("[ERROR] 6개를 입력해주세요.");
        winningLotto.forEach(num->{
            if(num<1 || num>45) throw new IllegalArgumentException("[ERROR] 1~45사이의 값만 입력 가능합니다.");
        });
        System.out.println(winningLotto);
        this.winningLotto=winningLotto;
    }

    public void setBonus(int num) {
        this.BonusNumber=num;
    }

    public void buyLottos(int money){
        this.count=calculateCount(money);
        for (int i = 0; i < count; i++) {
            List<Integer> nums=Randoms.pickUniqueNumbersInRange(1,45,6);
            lottos.add(new Lotto(nums));
        }
        outputView.printLottos(lottos);
    }

    public void makeLotto(List<Integer> lottoNums) {
        lottos.add(new Lotto(lottoNums));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int calculateCount(int money) {
        if(money%1000==0){
            return money/1000;
        }
        throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위만 가능합니다.");
    }

    public void calculateStatistics(){
        writeHitByMatchCount();
        printPrize();
        final int totalPrize = getTotalPrize();
        outputView.printStatistics((double) totalPrize / (count * 1000) * 100);
    }

    private int getTotalPrize() {
        final int totalPrize=hit.entrySet().stream()
                .mapToInt(entry->entry.getKey().getPrize()*entry.getValue())
                .sum();
        return totalPrize;
    }

    private void printPrize() {
        System.out.println("당첨 통계");
        System.out.println("---");
        hit.forEach((rank, count) -> {
            if(rank==Rank.NONE) return;
            int prize = rank.getPrize() * count;
            System.out.println(rank.getMessage()+" - "+count+"개");
        });
    }

    private void writeHitByMatchCount() {
        lottos.forEach(lotto -> {
            Rank rank=lotto.checkWining(winningLotto, BonusNumber);
            hit.put(rank, hit.get(rank)+1);
        });
    }
}
