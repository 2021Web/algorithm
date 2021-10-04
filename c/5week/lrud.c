#include <stdio.h>
// strtok
#include <string.h>
// atoi
#include <stdlib.h>

char input[20];
char plan[100];

int x = 1, y = 1;
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};
char moveTypes[4] = {'L', 'R', 'U', 'D'};
char *token;
char *ptr = moveTypes;

int main(void)
{
    fgets(input, sizeof(input), stdin);
    fgets(plan, sizeof(plan), stdin);
    // 문자를 숫자로 변환
    int n = atoi(input);

    // 공백을 기준으로 문자 분리
    token = strtok(plan, " ");

    // 이동 계획을 하나씩 확인하기
    while (token != NULL)
    {
      // 이동 후 좌표 구하기
        int nx = -1, ny = -1;
        for (int i = 0; i < 4; i++)
        {
            if (*token == ptr[i])
            {
                nx = x + dx[i];
                ny = y + dy[i];
            }
        }
        // 이전에 기억한 곳부터 다시 분리
        token = strtok(NULL, " ");

        // 공간을 벗어나는 경우 무시
        if (nx < 1 || ny < 1 || nx > n || ny > n)
            continue;

        // 이동 수행
        x = nx;
        y = ny;
    }

    printf("%d %d", x, y);
    return 0;
}