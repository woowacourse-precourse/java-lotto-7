package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultCheckerTest {
    LottoResultChecker lottoResultChecker;

    @BeforeEach
    void setup(){
        lottoResultChecker = new LottoResultChecker();
    }

    @Test
    @DisplayName("문자열로 받은 입력값을 정수로 변환하고, 1 이상 45 이하의 범위에 속하는지 확인한다.")
    void validateNumberTest1(){
        Assertions.assertThat(lottoResultChecker.validateNumber("1")).isEqualTo(1);
        Assertions.assertThat(lottoResultChecker.validateNumber("10")).isEqualTo(10);
        Assertions.assertThat(lottoResultChecker.validateNumber("45")).isEqualTo(45);
    }

    @Test
    @DisplayName("문자열로 받은 입력값이 정수 형태가 아니거나, 1 이상 45 이하의 범위에 속하지 않는 경우 입력 실패한다.")
    void validateNumberTest2() {
        Assertions.assertThatThrownBy(() -> lottoResultChecker.validateNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값의 범위는 1~45입니다.");
        Assertions.assertThatThrownBy(() -> lottoResultChecker.validateNumber("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값의 범위는 1~45입니다.");
        Assertions.assertThatThrownBy(() -> lottoResultChecker.validateNumber("46.9"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 정수가 아니거나 없습니다. 1~45 사이의 정수를 입력해주세요.");
        Assertions.assertThatThrownBy(() -> lottoResultChecker.validateNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 정수가 아니거나 없습니다. 1~45 사이의 정수를 입력해주세요.");
        Assertions.assertThatThrownBy(() -> lottoResultChecker.validateNumber(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 정수가 아니거나 없습니다. 1~45 사이의 정수를 입력해주세요.");
        Assertions.assertThatThrownBy(() -> lottoResultChecker.validateNumber(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 정수가 아니거나 없습니다. 1~45 사이의 정수를 입력해주세요.");
        Assertions.assertThatThrownBy(() -> lottoResultChecker.validateNumber("숫자가 아닌 경우"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 정수가 아니거나 없습니다. 1~45 사이의 정수를 입력해주세요.");
    }

    @Test
    @DisplayName("사용자에게 입력받은 당첨 숫자 모두에 대하여 유효한 숫자인지 확인한다.")
    void setWinningNumbersTest1(){
//        String input1 = "1,2,35,4,6,7";
        String input2 = "1000,2,3,4,5,6";
        String input3 = ",2,3,4,5,6";
        String input4 = "2,2,3,4,5,6";

        Assertions.assertThatThrownBy(()->lottoResultChecker.setWinningNumbers(input2))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(()->lottoResultChecker.setWinningNumbers(input3))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(()->lottoResultChecker.setWinningNumbers(input4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자에게 입력받은 당첨 숫자 중 하나라도 유효하지 않으면 당첨 번호를 받아들이는데 실패한다.")
    void setWinningNumbersTest2(){
        String input1 = "1,2,35,4,6,7";

        lottoResultChecker.setWinningNumbers(input1);

        Assertions.assertThat(lottoResultChecker.getWinningNumbers().size()).isEqualTo(6);
    }


    @Test
    @DisplayName("사용자에게 입력받은 보너스 숫자가 유효하지 않거나 당첨 숫자와 중복되는 경우 보너스 번호를 받아들이는데 실패한다.")
    void setBonusNumberTest1() {
        String input1 ="2";
        String input2 = "0";
        String input3 = "\\";
        String input4 = " ";
        lottoResultChecker.setWinningNumbers("1,2,3,4,5,6");

        Assertions.assertThatThrownBy(() -> lottoResultChecker.setBonusNumber(input2))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> lottoResultChecker.setBonusNumber(input3))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> lottoResultChecker.setBonusNumber(input4))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> lottoResultChecker.setBonusNumber(input1))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("사용자에게 입력받은 보너스 숫자가 유효하며, 당첨 숫자와 중복되지 않으면 보너스 번호로 저장된다.")
    void setBonusNumberTest2() {
        String input1 = "10";
        lottoResultChecker.setWinningNumbers("1,2,3,4,5,6");

        lottoResultChecker.setBonusNumber(input1);

        Assertions.assertThat(lottoResultChecker.getBonusNumber()).isEqualTo(10);

    }

    @Test
    @DisplayName("로또 번호를 당첨 번호 및 보너스 번호와 비교해서 일치 개수를 구한다.")
    void compareNumberTest(){
        lottoResultChecker.setWinningNumbers("1,2,3,4,5,6");
        lottoResultChecker.setBonusNumber("35");

        Integer[] lottoNumbers = new Integer[]{ 1, 5, 7, 19, 35, 40 };
        List<Integer> lottoNumbersList = Arrays.asList(lottoNumbers);

        lottoResultChecker.compareWinningNumber(lottoNumbersList);
        lottoResultChecker.compareBonusNumber(lottoNumbersList);

        Assertions.assertThat(lottoResultChecker.matchingWithWinning).isEqualTo(2);
        Assertions.assertThat(lottoResultChecker.matchingWithBonus).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 한 장에 대하여 등수를 구한다.-1등")
    void getLottoPrizeTest1(){
        Integer[] lottoNumbers = new Integer[]{ 1, 5, 2, 4, 3, 6 };
        List<Integer> lottoNumbersList = Arrays.asList(lottoNumbers);
        Lotto lotto = new Lotto(lottoNumbersList);

        lottoResultChecker.setWinningNumbers("1,2,3,4,5,6");
        lottoResultChecker.setBonusNumber("35");

        Assertions.assertThat(lottoResultChecker.getLottoPrize(lotto)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 한 장에 대하여 등수를 구한다.-2등")
    void getLottoPrizeTest2(){
        Integer[] lottoNumbers = new Integer[]{ 1, 5, 2, 4, 35, 6 };
        List<Integer> lottoNumbersList = Arrays.asList(lottoNumbers);
        Lotto lotto = new Lotto(lottoNumbersList);

        lottoResultChecker.setWinningNumbers("1,2,3,4,5,6");
        lottoResultChecker.setBonusNumber("35");

        Assertions.assertThat(lottoResultChecker.getLottoPrize(lotto)).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 한 장에 대하여 등수를 구한다.-3등")
    void getLottoPrizeTest3(){
        Integer[] lottoNumbers = new Integer[]{ 1, 5, 2, 4, 40, 6 };
        List<Integer> lottoNumbersList = Arrays.asList(lottoNumbers);
        Lotto lotto = new Lotto(lottoNumbersList);

        lottoResultChecker.setWinningNumbers("1,2,3,4,5,6");
        lottoResultChecker.setBonusNumber("35");

        Assertions.assertThat(lottoResultChecker.getLottoPrize(lotto)).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 한 장에 대하여 등수를 구한다.-4등")
    void getLottoPrizeTest4(){
        Integer[] lottoNumbers = new Integer[]{ 1, 5, 2, 11, 40, 6 };
        List<Integer> lottoNumbersList = Arrays.asList(lottoNumbers);
        Lotto lotto = new Lotto(lottoNumbersList);

        lottoResultChecker.setWinningNumbers("1,2,3,4,5,6");
        lottoResultChecker.setBonusNumber("35");

        Assertions.assertThat(lottoResultChecker.getLottoPrize(lotto)).isEqualTo(4);
    }

    @Test
    @DisplayName("로또 한 장에 대하여 등수를 구한다.-5등")
    void getLottoPrizeTest5(){
        Integer[] lottoNumbers = new Integer[]{ 1, 5, 2, 44, 25, 16 };
        List<Integer> lottoNumbersList = Arrays.asList(lottoNumbers);
        Lotto lotto = new Lotto(lottoNumbersList);

        lottoResultChecker.setWinningNumbers("1,2,3,4,5,6");
        lottoResultChecker.setBonusNumber("35");

        Assertions.assertThat(lottoResultChecker.getLottoPrize(lotto)).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 한 장에 대하여 등수를 구한다.-5등")
    void getLottoPrizeTest6(){
        Integer[] lottoNumbers = new Integer[]{ 1, 5, 2, 11, 35, 16 };
        List<Integer> lottoNumbersList = Arrays.asList(lottoNumbers);
        Lotto lotto = new Lotto(lottoNumbersList);

        lottoResultChecker.setWinningNumbers("1,2,3,4,5,6");
        lottoResultChecker.setBonusNumber("35");

        Assertions.assertThat(lottoResultChecker.getLottoPrize(lotto)).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 객체 배열을 받아 모든 객체에 대한 당첨 결과를 구한다.")
    void getLottoResultTest(){
        Integer[] lottoNumbers1 = new Integer[]{ 1, 5, 2, 11, 35, 16 };
        Integer[] lottoNumbers2 = new Integer[]{ 8, 5, 2, 10, 45, 19 };
        List<Integer> lottoNumbersList1 = Arrays.asList(lottoNumbers1);
        List<Integer> lottoNumbersList2 = Arrays.asList(lottoNumbers2);

        Lotto lotto1 = new Lotto(lottoNumbersList1);
        Lotto lotto2 = new Lotto(lottoNumbersList2);

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto1);
        lottoList.add(lotto2);

        lottoResultChecker.setWinningNumbers("1,2,3,4,5,6");
        lottoResultChecker.setBonusNumber("35");

        Integer[] result = new Integer[lottoList.size()];
        result = lottoResultChecker.getLottoResult(lottoList);

        Assertions.assertThat(result[0]).isEqualTo(5);
        Assertions.assertThat(result[1]).isEqualTo(0);
    }

}
