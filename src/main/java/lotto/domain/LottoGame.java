package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.UtilConstants.LOTTO_NUMBER_COUNT;
import static lotto.constant.UtilConstants.MINIMUM_PRICE;
import static lotto.constant.UtilConstants.SEPARATOR;

public class LottoGame {
    private final LottoRepository lottoRepository;
    private Lotto winningLotto;
    private int bonusNumber;
    private int lottoCount;

    public LottoGame(LottoRepository lottoRepository){
        this.lottoRepository = lottoRepository;
    }

    public void setDetails(Lotto winningLotto, int bonusNumber){
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void setLottoCount(int purchaseAmount){
        this.lottoCount = purchaseAmount/MINIMUM_PRICE;
    }

    public void generateLotto(){
        for(int i = 0; i < lottoCount; i++){
            lottoRepository.saveLotto(generateSingleLotto());
        }
    }

    public void createWinningLotto(String input){
        List<Integer> winningNumbers = parseInput(input);
        winningLotto = new Lotto(winningNumbers);
    }

    private List<Integer> parseInput(String input){
        return Arrays.stream(input.split(SEPARATOR))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private static Lotto generateSingleLotto(){
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(1,45, LOTTO_NUMBER_COUNT);
        Collections.sort(generatedNumbers);
        return new Lotto(generatedNumbers);
    }
}
