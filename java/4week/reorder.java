/**
 * reorder
 */
import java.util.*;

public class reorder {

  public static void main(String[] args) {
    System.out.print("배열 입력: ");
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    // 숫자가 아닐 시 제거하고 배열 형태로 저장
    String[] strArr = input.replaceAll("[^\\d]", "").split("");
    // 숫자 배열 생성
    int[] arr = new int[strArr.length];
    // 문자를 숫자로 변경하여 재할당
    for (int i = 0; i < strArr.length; i++) {
      arr[i] = Integer.parseInt(strArr[i]);
    }

    int j = 0;
    for (int item : arr) {
      if (item != 0) {
        arr[j] = item;
        j++;
      }
    }
    for (int i = j; i < arr.length; i++) {
      arr[i] = 0;
    }
    System.out.println("정렬 후 배열: " + Arrays.toString(arr));
  }
}
