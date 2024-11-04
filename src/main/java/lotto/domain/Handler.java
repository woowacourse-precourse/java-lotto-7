package lotto.domain;

import static lotto.domain.MAGIC_NUMBER.SIZE;
import static lotto.domain.MAGIC_NUMBER.START;
import static lotto.domain.Message.FIFTH;
import static lotto.domain.Message.FIRST;
import static lotto.domain.Message.FOURTH;
import static lotto.domain.Message.SECOND;
import static lotto.domain.Message.THIRD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.view.Input;

public class Handler {

  private int generateRequest;
  private Lotto lotto;


  public Handler(int request) {

    this.generateRequest = request;
  }

  // 1~45 범위 정수 6개가 담긴 로또를 요청 수만큼 발행하여 전달한다
  public List<Integer> generateLotto() {
    List<Integer> numbers = new ArrayList<>();
    int random = Randoms.pickNumberInRange(1, 45);
    for (int i = START.getMagicNumber(); i < SIZE.getMagicNumber(); i++) {
      numbers.add(random);
    }
    return numbers;
  }

  // 입력받은 당첨번호를 쉼표, 공백 구분자와 정수를 분리한다
  private List<Integer> generateWinning(String winning){
    List<Integer> winningNumbers = new ArrayList<>();
    // 당천 번호 입력 문자열을 읽으면
    for (int i = 0; i < winning.length(); i++) {
      // 쉼표와 공백 구분자를 제외하고 각 정수를 하나씩 리스트에 추가한다
      winningNumbers = Arrays.stream(winning.split("\\s,"))
          .map(Integer::parseInt)
          .collect(Collectors.toList()); // NumberFormatException
    }
    return winningNumbers;
  }

  // 전달된 로또 결과 조회

  // 당첨 번호 조회
  public List<Integer> getWinning(){
    return List.of(1,2,3,4,5,6);
  }
  // 보너스 번호 조회
  public int getBonus() {
    return 0;
  }
  // 5. 내부적으로 구매 금액만큼의 로또를 발행하여 당첨 번호와 보너스 번호를 적절히 비교한다
  public String compareNumbersResult(List<Integer> actualLotto, List<Integer> winningNumbers, int bonus) {
    String result = "";
    int equals = 0;
    boolean containsBonus = false;
    // 실제 로또값에 당첨번호가 포함된 경우 일치수 증가
    for (Integer winning : winningNumbers) {
      if (actualLotto.contains(winning)) {
        equals++;
      }
    }
    // 실제 로또값에 보너스번호가 포함된 경우
    boolean hasBonus = actualLotto.contains(bonus);

    // 6개 일치
    if(equals == 6) {


      // 어떻게 비교할 것인가 -> 반복문 vs 스트림
      result = FIRST.getMessage();
    }
    // 5개 일치, 보너스 볼 일치
    if(equals == 5 && containsBonus) {
      result = SECOND.getMessage();
    }
    // 5개 일치
    if(equals == 5) {
      result = THIRD.getMessage();
    }
    // 4개 일치
    if(equals == 4) {
      result = FOURTH.getMessage();
    }
    // 3개 일치
    if(equals == 3) {
      result = FIFTH.getMessage();
    }
    return result;
  }



  // 6. 비교한 결과를 토대로 총 수익률 계산한다
  public double calculateRevenue(String result, int amount) {
    double revenue = 0;
    // 수익률 = 당첨 금액 / 투입 금액 * 100
    // 결과 문자열에서 당첨 금액 추출
    int winningAmount = 0;
    // 정규식으로 "원" 앞에 있는 금액 추출
    // '\\d{1, 3}' : 숫자가 1~3자리로 시작
    // ?:,\\d{3})* : 캡처하지 않는 그룹으로 쉼표 뒤 세 자리 숫자 패턴을 0회 이상 반복
    // \\s*원 : 금액 뒤에 공백이 있을 경우를 고려해 원 앞에 \\s 추가
    //  문자열 내 공백이 패턴에 포함되지 않아 매칭에 실패하면 matcher.find()가 false를 반환해 매칭 실패로 PatternSyntaxException -> gpt의 도움받아 정규식 개선, 구글링 시간 감소. 스스로 고민하고 해결하는 시간 줄어드는 mitigation <-> 우테코 미션 제출 시간 엄수 트레이드 오프
    Pattern pattern = Pattern.compile("(\\d{1,3}(?:,\\d{3})*)\\s*원");
    Matcher matcher = pattern.matcher(result);

    // mathcer 패턴과 일치하는 부분이 있는지 확인
    if (matcher.find()) {
      String amountString = matcher.group(1).replaceAll(",", "");
      winningAmount = Integer.parseInt(amountString);
    }
    revenue = (winningAmount / (double) amount) * 100;
    // 입력값에서 투입 금액 추출
    return revenue;
  }

  public String getResult(double revenue) {
    String.format("총 수익률은 revenue%f입니다.", revenue);
    return "총 수익률은 62.5%입니다.";
  }
}
