// @see https://leetcode-cn.com/problems/dungeon-game/

//time exceed
public class Solve174 {
    public static void main(String[] args) {
        int [] intA[] ={{-2,-3, 3},{-5,-10,1},{10,30,-5}};

        int [] b[] = {{0,},};
        System.out.println(calculateMimiumHP(intA));
    }

    static private int calculateMimiumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int [][] dp = new int[row][col];

        for (int i = row - 1; i >= 0; i--)  {
            for (int j = col - 1; j >= 0; j--)  {
                if (i == row -1 && j == col - 1) {
                    dp[i][j] = Math.max(1, 1-dungeon[i][j]);
                } else if ( i == row - 1) {
                    dp[i][j] = Math.max(1, dp[i][j+1] - dungeon[i][j]);
                } else if (j == col - 1) {
                    dp[i][j] = Math.max(1, dp[i+1][j] - dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
