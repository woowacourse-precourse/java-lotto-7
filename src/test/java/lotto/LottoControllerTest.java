package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoControllerTest {
    @Test
    public void createLottoNumbers(){
        List<Lotto> lottoNumbers = new LinkedList<>();
        // 로또 번호 생성 및 리스트에 추가
        for(int i = 0; i < 1; i++){
            try {
                lottoNumbers.add(new Lotto(List.of(1,2,3,4,5,6,7)));
            }catch (IllegalArgumentException e){
                // 로또 번호 개수가 6개가 아니거나 중복된 숫자가 포함 돼 있을 경우 예외 발생
                // i-- 후 로또 번호 재생성
                i--;

                // for문이 한 번 반복되고 나면 +1 되므로 지금 i는 -1이 돼야 함
                assertEquals(i, -1);
                break;
            }
        }
    }
    void testSetWinningNumberNumberFormatException(){
        String includeAphabet = "1,2,3,e";
        List<Integer> winningNumbers = new LinkedList<>();

        String message = "";
        for(String n:includeAphabet.split(",")){
            message = Assertions.assertThrows(NumberFormatException.class, () -> {
                winningNumbers.add(Integer.parseInt(n));
            }).getMessage();
        }
        assertEquals(message, "[ERROR] 당첨번호는 숫자와 콤마(,)로만 이루어져야합니다.");
    }
    @Test
    void testSetWinningNumberCheckLength(){
        String checkLength = "1,2,3";
        List<Integer> winningNumbers = new LinkedList<>();

        for(String n:checkLength.split(",")){
            winningNumbers.add(Integer.parseInt(n));
        }
        assertThatThrownBy(() -> new Lotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");

    }
    @Test
    void testSetWinningNumberDuplicated(){
        String duplicated = "1,2,3,4,5,5";
        List<Integer> winningNumbers = new LinkedList<>();

        for(String n:duplicated.split(",")){
            winningNumbers.add(Integer.parseInt(n));
        }
        assertThatThrownBy(() -> new Lotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 로또 번호는 중복될 수 없습니다.");

    }
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
