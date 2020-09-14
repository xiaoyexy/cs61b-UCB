package LectureCode.lists1;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /**
     * Return the size of the list using... recursion!
     */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /**
     * Return the size of the list using no recursion!
     */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /**
     * Returns the ith item of this IntList.
     */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    public void addAdjacent() {
        /**
         * two numbers in a row are the same, add them together for one large node.
         * For example: 1 → 1 → 2 → 3 becomes 2 → 2 → 3 which becomes 4 → 3
         */
        IntList p = this;
        while (p.rest != null) {
            if (p.first == p.rest.first) {
                p.first = 2 * p.first;
                p.rest = p.rest.rest;
            } else {
                p = p.rest;
            }

        }
    }

    public void insertSquare(int x) {
        /**
         * “square” the IntList when insert.
         * For example, upon the insertion of 5, the below IntList would transform from:
         * 1 => 2 to 1 => 1 => 2 => 4 => 5
         * and if 7 was added to the latter IntList, it would become
         * 1 => 1 => 1 => 1 => 2 => 4 => 4 => 16 => 5 => 25 => 7
         * Constraint: Only access the size() function one time during the entire process of adding a node.
         */
        IntList p = this;
        while (p != null) {
            p.rest = new IntList(p.first * p.first, p.rest);
            if (p.rest.rest == null) {
                p.rest.rest = new IntList(x, null);
                break;
            }
            p = p.rest.rest;
        }
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.println(L.get(2));


        IntList Q = new IntList(3, null);
        Q = new IntList(2, Q);
        Q = new IntList(1, Q);
        Q = new IntList(1, Q);
        System.out.println(Q.size());
        Q.addAdjacent();
        System.out.println(Q.size());


        IntList M = new IntList(2, null);
        M = new IntList(1, M);
        M.insertSquare(5);
        M.insertSquare(7);


    }
} 