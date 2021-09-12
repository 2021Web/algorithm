import java.util.*;

public class coin {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int k = input.nextInt();
    ArrayList<Integer> coinList = new ArrayList<Integer>();
    int cnt = 0;

    for (int i = 0; i < n; i++) {
      coinList.add(input.nextInt());
    }

    for (int i = coinList.size() - 1; i > 0; i--) {
      cnt += k / coinList.get(i);
      k %= coinList.get(i);
    }

    System.out.println(cnt);
  }
}
