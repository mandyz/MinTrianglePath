/**
 *  Main class.
 *
 * @author Mandy Zammit {@literal <zammit.mandy@gmail.com>}
 */
public class Main {

    public static void main(String[] args) {
       System.out.println("Minimal path is: " + minPath(generateTestTree()));
    }

    private static int minPath(Tree<Integer> tree){
        int minPath = 0;

        // Base Case
        if(tree.getLeftChildNode() == null && tree.getRightChildNode() == null){
            minPath = tree.getRootNode();
        } else { // Inductive Case
            minPath = Math.min(minPath(tree.getLeftChildNode()),minPath(tree.getRightChildNode())) + tree.getRootNode();
        }

        return minPath;
    }

    private static Tree<Integer> generateTestTree(){

        // 4th Level Trees
        Tree<Integer> t1 = new Tree<>(11);
        Tree<Integer> t2 = new Tree<>(2);
        Tree<Integer> t3 = new Tree<>(10);
        Tree<Integer> t4 = new Tree<>(9);

        // 3rd Level Trees
        Tree<Integer> t5 = new Tree<>(3);
        t5.setLeftChildNode(t1);
        t5.setRightChildNode(t2);

        Tree<Integer> t6 = new Tree<>(8);
        t6.setLeftChildNode(t2);
        t6.setRightChildNode(t3);

        Tree<Integer> t7 = new Tree<>(5);
        t7.setLeftChildNode(t3);
        t7.setRightChildNode(t4);

        // 2nd Level Trees
        Tree<Integer> t8 = new Tree<>(6);
        t8.setLeftChildNode(t5);
        t8.setRightChildNode(t6);

        Tree<Integer> t9 = new Tree<>(3);
        t9.setLeftChildNode(t6);
        t9.setRightChildNode(t7);

        // 1st Level Tree
        Tree<Integer> root = new Tree<>(7);
        root.setLeftChildNode(t8);
        root.setRightChildNode(t9);

        return root;
    }
}
