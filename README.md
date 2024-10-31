# 과제3 - 로또
## 구현 기능 목록
<hr>

### 입력

1. 로또 구입 금액 입력
    - 1,000원 단위가 아닐 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
2. 당첨 번호 입력
    - 쉼표(,) 기준으로 구분
      - IllegalArgumentException을 발생시킨 후 애플리케이션은 종료 경우
        - 구분 시 빈 문자열이 있을 경우  
        - 1~45 범위 정수가 아닐 경우 
3. 보너스 번호 입력 
    - 1~45 범위 정수가 아닐 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
<hr>

### 로또 게임
1. 구입한 로또만큼 랜덤 번호(6개) 뽑기
   - 1~45 사이의 중복되지 않는 정수로 뽑기
   - 오름차순으로 정렬 후 저장
2. 랜덤 번호들과 당첨 번호, 보너스 번호 매칭하여 일치한 번호 개수 계산
    - 각 랜덤 번호와 당첨 번호 매칭
      - 5개 일치 시 랜덤 번호에 보너스 번호 존재하는지 파악
3. 계산한 번호 개수로 당첨 등수 매칭
4. 당첨 금액으로 수익률 계산
   - 소수점 둘째 자리에서 반올림

<hr>

### 출력
 - 구입한 로또만큼 랜덤 번호 출력
 - 구입한 로또 번호들과 당첨 번호,보너스 번호 매칭을 통해 당첨 통계 출력


### 예외
  - 예외상황 시 에러문구 출력
    - 에러문구는 [ERROR]로 시작