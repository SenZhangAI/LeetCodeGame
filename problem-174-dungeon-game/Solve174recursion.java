// @see https://leetcode-cn.com/problems/dungeon-game/

//time exceed
public class Solve174 {
    public static void main(String[] args) {
        int [] intA[] ={{-2,-3, 3},{-5,-10,1},{10,30,-5}};

        int [] b[] = {{0,},};
        System.out.println(calculateMimiumHP(b));
    }

    static private int calculateMimiumHP(int[][] dungeon) {
        int result = nextStepHpEval(100, 0, dungeon, 0, 0);
        if (result >= 0) {
            return 1;
        }
        return  1 - result;
    }

    /**
     * @return last hp loss
     */
    static private int nextStepHpEval(int lastMinHpLoss, int totalHpLoss, int[][] dungeon, int i, int j) {
        totalHpLoss = totalHpLoss + dungeon[i][j];
        //if -10 < -5, so we
        if (totalHpLoss < lastMinHpLoss) {
            lastMinHpLoss = totalHpLoss;
        }

        if (i == dungeon.length -1 && j == dungeon[i].length -1) {
            return lastMinHpLoss;
        }

        if (i == dungeon.length - 1) {
            return nextStepHpEval(lastMinHpLoss, totalHpLoss, dungeon, i, j + 1);
        }

        if (j == dungeon[i].length - 1) {
            return nextStepHpEval(lastMinHpLoss, totalHpLoss, dungeon, i + 1 , j);
        }

        int eastHpLoss = nextStepHpEval(lastMinHpLoss, totalHpLoss, dungeon, i, j + 1);
        int southHpLoss = nextStepHpEval(lastMinHpLoss, totalHpLoss, dungeon, i + 1, j);

        return eastHpLoss > southHpLoss ? eastHpLoss : southHpLoss;
    }
}
