# java-lotto-precourse

## Static final 값 정하기
&ensp; - Lotto number의 min(1), max(45)  
&ensp; - unit of purchasing prices(1000)  

## 구매 금액 input 받기
&ensp; - 1000원 단위로 받기  
&ensp; - Number가 아닌 경우 / Positive가 아닌 경우 / 1000원으로 나누어 떨어지지 않는 경우 -> Exception  
&ensp; - Price가 blank를 포함할 경우 -> Exception  
&ensp; - Input의 최댓값은 20억으로 설정, readLine()으로 받으면서 parsing 전에 자릿수가 11자리 이상일 경우 미리 Exception

## 당첨 번호 input 받기
&ensp; - 쉼표로 구분된 6개의 숫자 받기  
&ensp; - Number가 아닌 경우 / 숫자가 6개가 아닐 시 / positive가 아닌 경우 / 중복된 경우 / 1과 45 사이가 아닐 시-> Exception  
&ensp; - Bonus Number에 대해서도 같은 Logic + 기존 당첨 번호와 not be duplicated  

## 로또 발행
&ensp; - 구매 금액/Unit of purchasing price = 발행할 로또 개수  
&ensp; - 범위 내의 랜덤한 숫자 6개 발행, 오름차순으로 정렬 후 전체 출력  

## 로또 번호 매칭
&ensp; - (1, 2등 제외) 보너스 번호 포함 matched 된 number 개수 구하기  
&ensp; - 1, 2등의 경우 6개 matched 된 경우에서 bonus_flag로 판별  

### 주의 사항
&ensp; - enum 사용, else 사용 금지, method의 길이가 15 line 넘지 않도록, 구현 기능에 대한 단위 테스트 작성