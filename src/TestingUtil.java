import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility class to facilitate testing of the application.
 *
 * @author Mandy Zammit {@literal <zammit.mandy@gmail.com>}
 */
public final class TestingUtil {

    private TestingUtil(){
        /* Private constructor, so as not to allow Util class initialization*/
    }

    /**
     * Generates a large data file with linear data. TODO
     */
    public static void generateDataFileLinear(){
        for(int i = 1; i <= 500; i++){
            for(int j = 1; j<=i; j++){
                if(j==i){
                    System.out.print(j + "\n");
                }else{
                    System.out.print(j + " ");
                }

            }
        }
    }

    /**
     * Generates a large data file with random data.
     */
    public static void generateDataFileRandom(){
        for(int i = 1; i <= 500; i++){
            for(int j = 1; j<=i; j++){
                int random = ThreadLocalRandom.current().nextInt(0, 500);
                if(j==i){
                    System.out.print(random + "\n");
                }else{
                    System.out.print(random + " ");
                }

            }
        }
    }

    /**
     * Generates a test tree.
     * @return
     */
    public static Tree<Integer> generateTestTree(){

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
