/**
 * atm
 */
import java.util.*;

public class atm {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // N 입력 받기
    int n = sc.nextInt();
    // 걸리는 시간 담을 배열
    ArrayList<Integer> timeList = new ArrayList<Integer>();
    int result = 0;

    // 걸리는 시간 입력 받기
    for (int i = 0; i < n; i++) {
      timeList.add(sc.nextInt());
    }

    // 오름차순으로 정렬
    Collections.sort(timeList);

    // 걸리는 시간의 합 계산
    for (int i = 0; i < timeList.size(); i++) {
      result += timeList.get(i) * (timeList.size() - i);
    }

    System.out.println(result);
  }
}
