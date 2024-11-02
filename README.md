# java-lotto-precourse

## 기능
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받기

- 로또 구입 금액을 1000원 단위로 입력받기
  - IllegalArgumentException 발생
    - 숫자가 아닌 값을 입력받을 경우
    - 1000원으로 나누어 떨어지지 않을 경우

- (로또 구입 금액 / 1000)개의 로또 발행
  - Lotto[] lottos = new Lotto[로또 구입 금액 / 1000] 배열 생성
  - 1에서 45 사이의 중복되지 않는 6개 세트 뽑기
    - Randoms.pickUniqueNumbersInRance(1, 45, 로또 구입 금액 / 1000) 메서드 사용

- 1에서 45 사이의 중복되지 않는 숫자 6개의 당첨 번호 입력받기 (번호는 쉼표(,)를 기준으로 구분)
  - IllegalArgumentException 발생
    - 쉼표(,)로 구분할 수 없을 경우
    - 쉼표로 구분한 요소가 6개가 아닐 경우
    - 쉼표로 구분한 후, 하나라도 숫자가 아닌 값이 포함되어 있을 경우
    - 중복되는 숫자가 존재할 경우

- 보너스 번호 입력 받기
  - IllegalArgumentException 발생
    - 숫자가 아닌 값을 입력받을 경우
    - 숫자가 1 미만이거나 45 초과일 경우
    - 당첨 번호와 중복되는 숫자일 경우
   
- 당첨 Enum 클래스: Prize
  - 당첨 개수: count
  - 보너스 볼 당첨 여부: hasBonus
  - 당첨 금액: amount 
  - Prize(int count, boolean hasBonus, int amount) 
    - FIFTH(3, false, 5_000),
    - FOURTH(4, false, 50_000),
    - THIRD(5, false, 1_500_000),
    - SECOND(5, true, 30_000,000),
    - FIRST(6, false, 2_000_000_000)
  - toString()
    - DecimalFormat formatter = new DecimalFormat("###,###")   
    - return count + "개 일치 (" + formatter.format(amount) + ") - "
   
- 사용자가 구매한 로또 번호와 당첨 번호를 비교
  - Map<Prize, Integer> prizeCounts = new TreeMap<>((o1, o2) -> o1.getAmount() - o2.getAmount())
    - 당첨 금액 기준으로 오름차순 정렬
    - Map에 key에 Prize 요소들을 모두 삽입, value(개수)는 0으로 초기화
      - for (Prize prize : Prize.values())
        - prizeCounts.put(prize, 0)
  - Lotto 배열의 모든 요소들을 탐색
    - 당첨 개수: count = 0
    - 보너스 볼 당첨: hasBonus = false
      - 당첨 번호와 같은 값이 있다면 count++
      - 보너스 번호와 같은 값이 있다면 bonus = true
    - Prize에 해당하는 개수 증가
      - for (Prize prize : Prize.values())
          - if (prize.getCount() == count && prize.hasBonus() == hasBonus)
            - prizeCount.put(prize, prizeCount.get(prize) + 1)

- 당첨 내역 및 수익률 출력
  - 당첨 내역 출력
    - 총 당첨 금액: long sum = 0
    - prizeCounts 맵의 모든 요소들을 탐색
      - for (Prize prize : Prize.values())   
        - System.out.println(prize.toString() + prizeCounts.get(prize) + "개")
        - sum += prize.getAmount() * prizeCounts.get(prize)
  - 수익률 출력
    - double avg = (double) 당첨 금액 / 구입 금액 * 100
    - 소숫점 둘째 자리에서 반올림
      - System.out.println(Math.round(avg, 100) / 100.0)
