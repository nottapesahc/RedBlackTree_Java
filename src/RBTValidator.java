
import java.util.Scanner;

public class RBTValidator {

    private RedBlackNode root;

    public RBTValidator() {
        root = null;
    }

    public boolean validate(String tree) {
        Scanner treeScan = new Scanner(tree);
        int key = -1;
        String prefix;
        String value = "+";
        int color = -1;
        /**
         *  **
         ** o * * BUILD TREE
         */
        while (treeScan.hasNextLine()) {
            /**
             * **
             * Isolate prefix,value,color,key
             */
            int i = 0;
            int j = 0;
            int k = 0;
            int l = 0;
            String line = treeScan.next();
            //prefix
            for (; line.charAt(i) != ':'; i++);
            prefix = line.substring(4, i);
            j = i;
            //color
            if (line.charAt(i + 1) == 'B') {
                color = 0;
            } else {
                color = 1;
            }
            for (; line.charAt(j) != '('; j++);
            j++;
            k = j;
            for (; line.charAt(k) != ','; k++);
            //key
            key = Integer.parseInt(line.substring(j, k));
            k++;
            l = k;
            for (; line.charAt(l) != ')'; l++);
            //value
            value = line.substring(k, l);

            //progress treeScan
            line = treeScan.nextLine();

            // Build Tree
            Element e = new Element(key, value);
            RedBlackNode RBN = new RedBlackNode(e, null, null);
            if (root == null) {
                root = RBN;
                root.setColor(color);
            } else {
                buildRecur(prefix, root, RBN, color);
            }

        }
        /*
         *** Now that the tree is built I will check RBT Properties
         */
        if (!checkTheProperties(root)) {
            return false;
        }
        if(blackIsBalanced(root)==-1){
            return false;
        }
        return true;
    }

    private boolean checkTheProperties(RedBlackNode current) {
        if (current == null) {
            return false;
        } //red root
        else if (current == root && current.getColor() == 1) {
            return false;
        } //current must be red or black
        else if (current.getColor() != 1 && current.getColor() != 0) {
            return false;
        } //red has red left
        else if (current.getColor() == 1 && current.hasLeftChild()) {
            if (current.getLeftChild().getColor() == 1) {
                return false;
            }
        } //red has red right
        else if (current.getColor() == 1 && current.hasRightChild()) {
            if (current.getRightChild().getColor() == 1) {
                return false;
            }
        } //check binary search order property of left child
        else if (current.hasLeftChild()) {
            if (current.getLeftChild().getElement().Key() >= current.getElement().Key()) {
                return false;
            }
        } //check binary search order property of right child
        else if (current.hasRightChild()) {
            if (current.getRightChild().getElement().Key() <= current.getElement().Key()) {
                return false;
            }
        }
        if (current.hasLeftChild()) {
            if (!checkTheProperties(current.getLeftChild())) {
                return false;
            }
        }
        if (current.hasRightChild()) {
            if (!checkTheProperties(current.getRightChild())) {
                return false;
            }
        }
        return true;
    }

    private void buildRecur(String prefix, RedBlackNode current, RedBlackNode RBN, int color) {
        //look at prefix
        if (prefix.equals("-left")) {
            current.setLeft(RBN);
            current.getLeftChild().setColor(color);
        } else if (prefix.equals("-right")) {
            current.setRight(RBN);
            current.getRightChild().setColor(color);
        } else if (prefix.startsWith("-left")) {
            prefix = prefix.substring(5, prefix.length());
            buildRecur(prefix, current.getLeftChild(), RBN, color);
        } else if (prefix.startsWith("-right")) {
            prefix = prefix.substring(6, prefix.length());
            buildRecur(prefix, current.getRightChild(), RBN, color);
        }
    }
    private int blackIsBalanced(RedBlackNode current){
        if(current == null){
            return 0;
        }
        //goes to null
        int left = blackIsBalanced(current.getLeftChild());
        //goes to null
        int right = blackIsBalanced(current.getRightChild());
        
        //makes tree seem like it is the same on both sides at current
        if(current.getLeftChild() ==null){
            left = right;
        }
        //makes tree seem like it is the same on both sides at current
        else if(current.getRightChild()==null){
            right = left;
        }
        //anytime we have a value of -1 we should immediately return -1 because it is not a valid rbtree
        if(left== -1 || right == -1){
            return -1;
        }
        if(left!=right){
            return -1;
        }
        //can return either left or right, but i have to add one because current is also black.
        if(current.getColor()==0&& left==right){
            return left+1;
        }
        //can return either left or right, but i dont add one because current is not black.
        if(current.getColor()==1 && left == right){
            return right;
        }
        else{
            return -1;
        }
    }

}
