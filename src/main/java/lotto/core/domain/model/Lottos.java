package lotto.core.domain.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.system.Config.SystemConfig;

public class Lottos {
    public List<Lotto> lottos;

    public Lottos() {

    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> buyLottoByTicketAmount(Integer ticketAmount) {
        List<Lotto> arr = new ArrayList<>();
        IntStream.range(0, ticketAmount)
                .forEach(i -> arr.add(Lotto.newInstance(Randoms.pickUniqueNumbersInRange(1, 45, 6))));
        this.lottos = List.copyOf(arr);
        return this.lottos;
    }

    public List<PrizeOption> matchUp(Lotto answerLotto, int bonusNumber) {
        ThreadPoolExecutor threadPool = SystemConfig.getInstance().getThreadPool();
        try {
            return CompletableFuture.supplyAsync(() ->
                            lottos.stream()
                                    .map(userLotto -> getResult(userLotto, answerLotto, bonusNumber))
                                    .filter(PrizeOption::isNotUnderThree)
                                    .collect(Collectors.toList()),threadPool).get();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    /**
     * 테스트 목적으로만 사용합니다.
     * 사용자의 로또 번호를 정답 로또 번호와 비교합니다.
     *
     * @param answerLotto  비교할 정답 로또 번호.
     * @param bonusNumber  비교할 보너스 번호.
     * @param threadPool   매칭 로직을 실행하는 데 사용할 사용자 지정 ThreadPoolExecutor.
     * @return 매칭 결과를 나타내는 PrizeOption의 리스트.
     */
    public List<PrizeOption> matchUp(Lotto answerLotto, int bonusNumber, ThreadPoolExecutor threadPool) {
        try {
            return CompletableFuture.supplyAsync(() ->
                            lottos.stream()
                                    .peek(lotto -> System.out.println("사용 중 스레드 이름 : " + Thread.currentThread().getName()))
                                    .map(userLotto -> getResult(userLotto, answerLotto, bonusNumber))
                                    .filter(PrizeOption::isNotUnderThree)
                                    .collect(Collectors.toList()),
                    threadPool).get();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }


    private PrizeOption getResult(Lotto userLotto, Lotto answerLotto, Integer bonusNumber) {
        int numberOfMatch = userLotto.matchUp(answerLotto);
        return PrizeOption.matchUp(numberOfMatch, userLotto, bonusNumber);
    }
    public List<Lotto> getLottosForMessage() {
        return lottos;
    }

}
