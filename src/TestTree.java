
public class TestTree {

    public static void main(String[] args) {

        RedBlackTree tree = new RedBlackTree();
        /*
         test1(tree);
         tree = new RedBlackTree();

         test2(tree);
         tree = new RedBlackTree();

         test3(tree);
         tree = new RedBlackTree();

         test4(tree);
         tree = new RedBlackTree();

         test5(tree);
         tree = new RedBlackTree();
         
         test6(tree);
         tree = new RedBlackTree();
         
        test7(tree);
                */
        test8(tree);
    }

    public static void test1(RedBlackTree tree) {
        System.out.println("test1");
        System.out.println(tree.toString());
        tree.insert(1, "C");
        tree.insert(14, "H");
        tree.insert(4, "A");
        tree.insert(18, "S");
        tree.insert(5, "E");
        System.out.println(tree);
    }

    public static void test2(RedBlackTree tree) {
        System.out.println("test2");
        tree.insert(1, "a");
        tree.insert(2, "b");
        tree.insert(3, "c");
        System.out.println(tree);
    }

    public static void test3(RedBlackTree tree) {
        System.out.println("test3");
        tree.insert(5, "5");
        tree.insert(10, "10");
        tree.insert(12, "12");
        System.out.println(tree);
    }

    public static void test4(RedBlackTree tree) {
        System.out.println("test4");
        tree.insert(1, "a");
        tree.insert(14, "n");
        tree.insert(4, "d");
        tree.insert(18, "r");
        tree.insert(5, "e");
        tree.insert(23, "w");
        tree.insert(19, "s");
        tree.insert(3, "c");
        tree.insert(8, "h");
        tree.insert(6, "f");
        System.out.println(tree);
        System.out.println("find a "+tree.find(1));
        System.out.println("find n "+tree.find(14));
        System.out.println("find d "+tree.find(4));
        System.out.println("find r "+tree.find(18));
        System.out.println("find e "+tree.find(5));
        System.out.println("find w "+tree.find(23));
        System.out.println("find somethig else: "+tree.find(99));
    }

    public static void test5(RedBlackTree tree) {
        tree.insert(29, "TwentyNine");
        //tree.insert(28, "Twenty Eight");
        tree.insert(14, "Fourteen");
        tree.insert(40, "Fourty");
        System.out.println(tree.toString());
        System.out.println("");
    }

    public static void test6(RedBlackTree tree) {
        System.out.println("test6");
        tree.insert(19, "s");
        System.out.println(tree);
        tree.insert(20, "t");
        System.out.println(tree);
        tree.insert(5,"e");
        System.out.println(tree);
        tree.insert(22,"v");
        System.out.println(tree);
        tree.remove(5);
        tree.insert(14,"n");
        System.out.println(tree);
        tree.insert(3,"c");
        System.out.println(tree);
        tree.insert(8,"h");
        System.out.println(tree);
        tree.insert(1,"a");
        System.out.println(tree);
        tree.insert(19, "s");
        tree.remove(19);
                System.out.println(tree);
        
    }

    public static void test7(RedBlackTree tree) {
        tree.insert(1, "a");
        tree.insert(14, "n");
        tree.insert(4, "d");
        tree.insert(18, "r");
        tree.insert(5, "e");
        tree.insert(23, "w");
        tree.insert(19, "s");
        tree.insert(3, "c");
        tree.insert(8, "h");
        tree.insert(6, "f");
        tree.delete(6);
        System.out.println(tree);
        System.out.println("");
        RBTValidator valid = new RBTValidator();
        //System.out.println(valid.validate(tree.toString()));
        System.out.println(valid.validate(
                "root:BLACK(15,d)\n"
                + "root-left:BLACK(7,a)\n"
                + "root-left-left:RED(1,c)\n"
                + "root-left-left-right:BLACK(4,x)\n"
                + "root-left-right:BLACK(11,a)\n"
                + "root-right:BLACK(24,y)\n"
                + "root-right-left:BLACK(20,z)\n"
                + "root-right-right:RED(30,n)\n"
                + "root-right-right-left:BLACK(27,h)\n"));
    }
    public static void test8(RedBlackTree tree){
        tree.insert(5,"5");
        System.out.println(tree);
        tree= new RedBlackTree();
        tree.insert(5,"five");
        System.out.println(tree.find(10));
        tree.delete(5);
        System.out.println(tree);
        tree = new RedBlackTree();
        tree.insert(5,"5");
        tree.insert(10,"10");
        tree.insert(12,"12");
        tree.delete(10);
        System.out.println(tree);
        
        
    }

}
