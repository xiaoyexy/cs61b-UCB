/**
 * ArrayBasics
 *
 * @author Josh Hug
 */
package LectureCode.lists3;

public class ArrayBasics2 {
    /** ArrayBasics
     */

    public static void main(String[] args) {
        int[][] pascalsTriangle;  //2D array：第一层array里面是reference，第二层才是int
        pascalsTriangle = new int[4][];
        int[] rowZero = pascalsTriangle[0];

        pascalsTriangle[0] = new int[]{1};
        pascalsTriangle[1] = new int[]{1, 1};
        pascalsTriangle[2] = new int[]{1, 2, 1};
        pascalsTriangle[3] = new int[]{1, 3, 3, 1};
        int[] rowTwo = pascalsTriangle[2];
        rowTwo[1] = -5;

        int[][] matrix;
        matrix = new int[4][];  //2D array：第一层是reference,因为没有初始化，所以地址值为null，共创建1个array
        matrix = new int[4][4]; //2D array：第一层写入4个地址值，第二层没有初始化，均为0，共创建5个array

        int[][] pascalAgain = new int[][]{{1}, {1, 1},
                {1, 2, 1}, {1, 3, 3, 1}};
    }
} 