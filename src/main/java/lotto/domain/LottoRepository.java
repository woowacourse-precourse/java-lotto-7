package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.UtilConstants.SEPARATOR;

public class LottoRepository {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private List<Integer> lottoPlaceCount;
    private Lotto winningLotto;
    private int bonusNumber;

    public LottoRepository(){
        lottoPlaceCount = new ArrayList<>(Collections.nCopies(5,0));
    }

    public void saveLotto(Lotto lotto){
        lottoTickets.add(lotto);
    }

    public List<Lotto> getLottos(){
        return Collections.unmodifiableList(lottoTickets);
    }

    public void increaseCount(int place){
        int currentCount = lottoPlaceCount.get(place);
        lottoPlaceCount.set(place, currentCount+1);
    }

    public List<Integer> getLottoPlaceCount(){
        return Collections.unmodifiableList(lottoPlaceCount);
    }

    public List<Integer> getWinningLotto(){
        return Collections.unmodifiableList(winningLotto.getNumbers());
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    public void createWinningLotto(String input){
        List<Integer> winningNumbers = parseInput(input);
        winningLotto = new Lotto(winningNumbers);
    }

    public void setBonusNumber(String bonusNumber){
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private List<Integer> parseInput(String input){
        return Arrays.stream(input.split(SEPARATOR))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
