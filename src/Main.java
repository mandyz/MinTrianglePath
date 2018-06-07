import java.util.*;

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
        Path minimumPath = minPath(tree);
        System.out.println("Minimal path is: " + minimumPath.getPath() + " = " + minimumPath.getPathValue());
    }

    /**
     * Computes the summation of the minimum path in a triangle of numbers (represented as a tree of trees).
     *
     * @param tree
     * @return
     */
    private static Path minPath(Tree<Integer> tree){
        Path minimumPath = null;

        // Base Case - Leaf Node (no child nodes)
        if(tree.getLeftChildNode() == null && tree.getRightChildNode() == null){
            int minPath = tree.getRootNode();
            minimumPath = new Path(minPath + "", minPath);
        } else { // Inductive Case
            // Retrieving minimal path of child nodes, if they're already computed.
            Path leftChildNodeMin = tree.getLeftChildNode().getMinimumPath();
            Path rightChildNodeMin = tree.getRightChildNode().getMinimumPath();


            // Choose minimal path from left (child) path and right (child) path.
            Path mimimumChildPath = min(
                    (leftChildNodeMin != null ? leftChildNodeMin :  minPath(tree.getLeftChildNode())),
                    (rightChildNodeMin != null ? rightChildNodeMin : minPath(tree.getRightChildNode()))
            );

            minimumPath = new Path( tree.getRootNode() + " + " + mimimumChildPath.getPath(),mimimumChildPath.getPathValue() + tree.getRootNode());

        }

        // Store the minimum path obtained from this tree downwards (in the tree itself).
        tree.setMinimumPath(minimumPath);
        return minimumPath;
    }

    /**
     * Compares two Paths and returns the Path with the least path value.
     * A path value is the summation of all nodes in the path.
     *
     * @param p1
     * @param p2
     * @return
     */
    private static Path min(Path p1, Path p2){
        return p1.getPathValue() >= p2.getPathValue() ? p2 : p1;
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
                    Tree<Integer> tree = new Tree<>(Integer.parseInt(nodes[j]));

                    if(j == 0){ // First Tree in this level.
                        // Add tree to the left node of the first tree in the previous level.
                        previousTrees.get(j).setLeftChildNode(tree);
                    } else if(j == nodes.length -1){ // Last Tree in this level.
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
