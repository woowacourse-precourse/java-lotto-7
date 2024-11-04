package lotto;

import lotto.model.Consumer;
import lotto.model.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsumerTest {
    @DisplayName("Consumer를 생성하면 LottoTicket이 발급된다.")
    @Test
    void lottoTicket() {
        //given
        int case1 = 1;
        int case2 = 2;
        int result1 = 1;
        int result2 = 2;

        //when
        Consumer test1 = new Consumer(case1);
        Consumer test2 = new Consumer(case2);

        //then
        assertThat(test1.getLottoTicket().size()).isEqualTo(result1);
        assertThat(test2.getLottoTicket().size()).isEqualTo(result2);
    }

    @DisplayName("배열 lottoResult의 크기는 7이다.")
    @Test
    void lottoResult() {
        //given
        int result1 = 7;
        WinningNumber winningNumber = new WinningNumber(List.of(1,2,3,4,5,6), 7);
        Consumer consumer = new Consumer(1);

        //when
        consumer.setLottoResult(winningNumber);

        //then
        assertThat(consumer.getLottoResult().length).isEqualTo(result1);
    }

    @DisplayName("당첨 번호와 일치하는 숫자의 개수를 lottoResult의 index 값으로 취급하여 요소에 1을 더한다.")
    @Test
    void lottoResultIndex() {
        //given
        int result1 = 1;
        Consumer consumer = new Consumer(1);
        List<Integer> lottoNumbers = new ArrayList<>(consumer.getLottoTicket().getFirst().getNumbers());
        int bonusNumber = 1;
        for(int i = 1; i < 8; i++){
            if (!lottoNumbers.contains(i)) {
                bonusNumber = i;
                break;
            }
        }
        WinningNumber winningNumber = new WinningNumber(lottoNumbers, 7);

        //when
        consumer.setLottoResult(winningNumber);

        //then
        assertThat(consumer.getLottoResult()[6]).isEqualTo(result1);
    }

    @DisplayName("당첨 번호와 일치하는 숫자의 개수가 5이면서 보너스 번호가 일치하면 secondPlace++.")
    @Test
    void lottoResultSecondPlace() {
        //given
        int resultSecondPlace = 1;
        int resultLottoResultIdx = 5;
        int resultLottoResult = 1;
        Consumer consumer = new Consumer(1);
        List<Integer> lottoNumbers = new ArrayList<>(consumer.getLottoTicket().getFirst().getNumbers());
        int bonusNumber = lottoNumbers.getFirst();
        for(int i = 1; i < 8; i++){
            if (!lottoNumbers.contains(i)) {
                lottoNumbers.set(0,i);
                break;
            }
        }
        WinningNumber winningNumber = new WinningNumber(lottoNumbers, bonusNumber);

        //when
        consumer.setLottoResult(winningNumber);

        //then
        assertThat(consumer.getSecondPlace()).isEqualTo(resultSecondPlace);
        assertThat(consumer.getLottoResult()[resultLottoResultIdx]).isEqualTo(resultLottoResult);
    }

    @DisplayName("당첨 번호와 일치하는 숫자의 개수가 5이면서 보너스 번호가 일치하지 않으면 secondPlace 변동 없음.")
    @Test
    void lottoResultThirdPlace() {
        //given
        int resultSecondPlace = 0;
        int resultLottoResultIdx = 5;
        int resultLottoResult = 1;
        Consumer consumer = new Consumer(1);
        List<Integer> lottoNumbers = new ArrayList<>(consumer.getLottoTicket().getFirst().getNumbers());
        for(int i = 1; i < 8; i++){
            if (!lottoNumbers.contains(i)) {
                lottoNumbers.set(0,i);
                break;
            }
        }
        int bonusNumber = 1;
        for(int i = 2; i < 8; i++){
            if (!lottoNumbers.contains(i)) {
                bonusNumber = i;
                break;
            }
        }
        WinningNumber winningNumber = new WinningNumber(lottoNumbers, bonusNumber);

        //when
        consumer.setLottoResult(winningNumber);

        //then
        assertThat(consumer.getSecondPlace()).isEqualTo(resultSecondPlace);
        assertThat(consumer.getLottoResult()[resultLottoResultIdx]).isEqualTo(resultLottoResult);
    }
}
