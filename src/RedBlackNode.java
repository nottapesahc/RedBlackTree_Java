
public class RedBlackNode {

    private Element element;
    private RedBlackNode left;
    private RedBlackNode right;
    private int color;

    public RedBlackNode(Element e, RedBlackNode l, RedBlackNode r) {
        element = e;
        left = l;
        right = r;
    }

    public Element getElement() {
        Element x = this.element;
        return x;
    }

    public int getColor() {
        int x = this.color;
        return x;
    }
    public String getColorString(){
        if(this.color == 0){
            return "BLACK";
        }
        else return "RED";
    }
    public RedBlackNode getLeftChild() {
        RedBlackNode x = this.left;
        return x;
    }

    public RedBlackNode getRightChild() {
        RedBlackNode x = this.right;
        return x;
    }
    
    public void setRight(RedBlackNode n){
        this.right = n;
    }
    
    public void setLeft(RedBlackNode n){
        this.left = n;
    }
    /**
     * Send 1 for red, 0 for black.
     * @parentam c 
     */
    public void setColor(int c){
        this.color = c;
    }
    public boolean hasLeftChild() {
        if (left != null) {
            return true;
        }
        return false;
    }

    public boolean hasRightChild() {
        if (right != null) {
            return true;
        }
        return false;
    }
}
