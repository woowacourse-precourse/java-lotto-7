package lotto;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoControllerTest {
    @Test
    void testMatchNumbers(){
        List<Lotto> lottoNumbers = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 3개 일치
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 3개 일치
                new Lotto(List.of(1, 2, 3, 5, 6, 12)), // 4개 일치
                new Lotto(List.of(1, 2, 3, 4, 12, 13)), // 5개 일치 + 보너스 번호 X
                new Lotto(List.of(1, 2, 3, 12, 13, 45)), // 5개 일치 + 보너스 번호 O
                new Lotto(List.of(1, 2, 3, 12, 13, 14))  // 6개 일치
                );

        List<Integer> winningNumbers = List.of(1, 2, 3, 12, 13, 14);
        int bonusNumber = 45;

        List<Integer> countMatched = new LinkedList<>();
        int countHasBonusNumber = 0;

        Iterator<Lotto> iterator = lottoNumbers.listIterator();
        while(iterator.hasNext()){
            Lotto currentNumeberList = iterator.next();
            int count = currentNumeberList.getMatchedSize(winningNumbers);

            // 숫자가 5개 일치 + 보너스 번호 O
            if(count == 5 && currentNumeberList.hasBonusNumber(bonusNumber)){
                countHasBonusNumber++;
                continue;
            }
            countMatched.add(count);
        }

        assertThat(countMatched).containsExactly(3, 3, 4, 5, 6);
        assertEquals(1, countHasBonusNumber);
    }
}
