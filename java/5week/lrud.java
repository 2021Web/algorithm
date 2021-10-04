import java.util.*;

/**
 * lrud
 */
public class lrud {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextLine().charAt(0) - '0';
    String input = sc.nextLine();
    String[] arr = input.split(" ");

    int x = 1, y = 1;
    // L, R, U, D에 따른 이동 방향
    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };
    char[] moveTypes = { 'L', 'R', 'U', 'D' };

    // 이동 계획을 하나씩 확인하기
    for (int i = 0; i < arr.length; i++) {
      // 이동 후 좌표 구하기
      int nx = -1, ny = -1;
      for (int j = 0; j < moveTypes.length; j++) {
        // arr[i]는 string 형이므로 char[] 로 변환하여 비교
        if (arr[i].toCharArray()[0] == moveTypes[j]) {
          nx = x + dx[j];
          ny = y + dy[j];
        }
      }

      // 공간을 벗어나는 경우 무시
      if (nx < 1 || ny < 1 || nx > n || ny > n) continue;

      // 이동 수행
      x = nx;
      y = ny;
    }

    System.out.println(x + " " + y);
  }
}
