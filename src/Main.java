import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *  Main class.
 *
 * @author Mandy Zammit {@literal <zammit.mandy@gmail.com>}
 */
public class Main {

    public static void main(String[] args) {
        // 1. Read input.
        Scanner sc = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while (sc.hasNext()){
            lines.add(sc.nextLine());
        }

        // 2. Generate tree of trees.
        Tree<Integer> tree = parseInput(lines);

        // 3. Calculate minimal path.
        System.out.println("Minimal path is: " + minPath(tree));
    }

    private static int minPath(Tree<Integer> tree){
        int minPath = 0;

        // Base Case
        if(tree.getLeftChildNode() == null && tree.getRightChildNode() == null){
            minPath = tree.getRootNode();
        } else { // Inductive Case
            Integer leftChildNodeMin = tree.getLeftChildNode().getMin();
            Integer rightChildNodeMin = tree.getRightChildNode().getMin();

            minPath = Math.min(
                    (leftChildNodeMin != null ? leftChildNodeMin :  minPath(tree.getLeftChildNode())),
                    (rightChildNodeMin != null ? rightChildNodeMin : minPath(tree.getRightChildNode()))
            ) + tree.getRootNode();

        }

        // Store the minimum path obtained from this tree downwards (in the tree itself).
        tree.setMin(minPath);
        return minPath;
    }

    /**
     * Parses input lines, to generate a tree.
     *
     * @param lines
     * @return resulting tree.
     */
    private static Tree<Integer> parseInput(List<String> lines){
        Tree<Integer> root = null;
        List<Tree> previousTrees = null;

        for(int i= 0; i < lines.size(); i++){
            if (i != 0){
                List<Tree> newTrees = new LinkedList<>();

                String[] nodes = lines.get(i).split(" ");
                for(int j = 0; j < nodes.length; j++){
                    Tree<Integer> tree = new Tree<>(Integer.parseInt(nodes[j]));;

                    if(j == 0){
                        // Add tree to the left node of the first tree in the previous level.
                        previousTrees.get(j).setLeftChildNode(tree);
                    } else if(j == nodes.length -1){
                        // Add tree to the right node of the last tree in the previous level.
                        previousTrees.get(j-1).setRightChildNode(tree);
                    } else {
                        // Add tree to the right node of the tree with id = current_id -1 in the previous level.
                        previousTrees.get(j-1).setRightChildNode(tree);
                        // Add tree to the left node of the tree with id = current_id in the previous level.
                        previousTrees.get(j).setLeftChildNode(tree);
                    }

                    newTrees.add(tree);

                }

                previousTrees = newTrees;
            } else { // Base Case
                root = new Tree<>(Integer.valueOf(lines.get(i)));
                previousTrees = new LinkedList<>();
                previousTrees.add(root);
            }
        }

        System.out.println("Finished parsing.");
        return root;
    }
}
