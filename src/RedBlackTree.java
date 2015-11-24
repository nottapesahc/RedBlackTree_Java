
public class RedBlackTree implements TreeInterface {

    private RedBlackNode gggparent, ggparent, gparent, parent, sibling, current, root;
    private RedBlackNode parentOfMin, parentOfMax;

    public RedBlackTree() {
        root = null;
    }

    public RedBlackTree(RedBlackNode N) {
        root = N;
    }

    @Override
    public String find(int key) {
        return strRecur(key, root);
    }

    private String strRecur(int key, RedBlackNode current) {
        if (root == null) {
            return null;
        } else if (current == null) {
            return null;
        } else if (key > current.getElement().Key()) {
            return strRecur(key, current.getRightChild());
        } else if (key < current.getElement().Key()) {
            return strRecur(key, current.getLeftChild());
        } else {
            return current.getElement().Value();
        }
    }

    @Override
    public void insert(int key, String value) {
        current = root;
        gggparent = ggparent = gparent = parent = null;
        Element e = new Element(key, value);
        RedBlackNode n = new RedBlackNode(e, null, null);
        n.setColor(1);
        while (true) {
            //if empty tree add n.
            if (current == null) {
                root = n;
                n.setColor(0);
                break;
            }
            //if key > current.key and current has right
            if (current.hasRightChild() && key > current.getElement().Key()) {
                colorIns(current);
                gggparent = ggparent;
                ggparent = gparent;
                gparent = parent;
                parent = current;
                current = current.getRightChild();
                rotateIns();
                continue;
            }
            //if key < current.key and current has left
            if (current.hasLeftChild() && key < current.getElement().Key()) {
                colorIns(current);
                gggparent = ggparent;
                ggparent = gparent;
                gparent = parent;
                parent = current;
                current = current.getLeftChild();
                rotateIns();
                continue;
            }
            //if key == current.key
            if (key == current.getElement().Key()) {
                current.getElement().value = value;
                break;
            }
            //new node is added to left and current doesnt have left child
            if (key < current.getElement().Key()) {
                gggparent = ggparent;
                ggparent = gparent;
                gparent = parent;
                parent = current;
                current.setLeft(n);
                current = current.getLeftChild();
                //color(parent);
                rotateIns();
                break;
            }
            //new node is added to the right and current doesnt have right child
            if (key > current.getElement().Key()) {
                gggparent = ggparent;
                ggparent = gparent;
                gparent = parent;
                parent = current;
                current.setRight(n);
                current = current.getRightChild();
                rotateIns();
                break;
            }
        }
    }

    private void rotateIns() {
        if (parent != null && gparent != null) {
            if (current.getColor() == 1 && parent.getColor() == 1) {

                //if current<parent<gparent
                if (current.getElement().Key() < parent.getElement().Key() && parent.getElement().Key() < gparent.getElement().Key()) {
                    //if ggparent exists, point to parent
                    if (gparent != root) {
                        if (ggparent.getElement().Key() > parent.getElement().Key()) {
                            ggparent.setLeft(parent);
                        } else {
                            ggparent.setRight(parent);
                        }
                    }
                    //gparent.left = parent.right
                    if (parent.hasRightChild()) {
                        gparent.setLeft(parent.getRightChild());
                    } else {
                        gparent.setLeft(null);
                    }
                    parent.setRight(gparent);
                    parent.setColor(0);
                    gparent.setColor(1);
                    if (gparent == root) {
                        root = parent;
                    }
                    gparent = ggparent; // updated

                } //if current>parent>gparent
                else if (current.getElement().Key() > parent.getElement().Key() && parent.getElement().Key() > gparent.getElement().Key()) {
                    //if ggparent exists, point to parent
                    if (gparent != root) {
                        if (ggparent.getElement().Key() > parent.getElement().Key()) {
                            ggparent.setLeft(parent);
                        } else {
                            ggparent.setRight(parent);
                        }
                    }
                    //gparent.right = parent.left
                    if (parent.hasLeftChild()) {
                        gparent.setRight(parent.getLeftChild());
                    } else {
                        gparent.setRight(null);
                    }
                    parent.setLeft(gparent);
                    parent.setColor(0);
                    gparent.setColor(1);
                    if (gparent == root) {
                        root = parent;
                    }
                    gparent = ggparent; //updated
                } //if gparent>current>parent
                else if (gparent.getElement().Key() > current.getElement().Key() && current.getElement().Key() > parent.getElement().Key()) {
                    //if ggparent exists, point to current.
                    if (gparent != root) {
                        if (ggparent.getElement().Key() > current.getElement().Key()) {
                            ggparent.setLeft(current);
                        } else {
                            ggparent.setRight(current);
                        }
                    }
                    //parent.right = current.left
                    if (current.hasLeftChild()) {
                        parent.setRight(current.getLeftChild());
                    } else {
                        parent.setRight(null);
                    }
                    //gparent.left = current.right
                    if (current.hasRightChild()) {
                        gparent.setLeft(current.getRightChild());
                    } else {
                        gparent.setLeft(null);
                    }
                    current.setLeft(parent);
                    current.setRight(gparent);
                    current.setColor(0);
                    gparent.setColor(1);
                    if (gparent == root) {
                        root = current;
                    }
                    parent = ggparent; //updated
                    gparent = gggparent; //new

                } //if gparent<current<parent
                else if (gparent.getElement().Key() < current.getElement().Key() && current.getElement().Key() < parent.getElement().Key()) {
                    //if ggparent exists, point to current.
                    if (gparent != root) {
                        if (ggparent.getElement().Key() > current.getElement().Key()) {
                            ggparent.setLeft(current);
                        } else {
                            ggparent.setRight(current);
                        }
                    }
                    //parent.left = current.right
                    if (current.hasRightChild()) {
                        parent.setLeft(current.getRightChild());
                    } else {
                        parent.setLeft(null);
                    }
                    //gparent.right = current.left
                    if (current.hasLeftChild()) {
                        gparent.setRight(current.getLeftChild());
                    } else {
                        gparent.setRight(null);
                    }
                    current.setLeft(gparent);
                    current.setRight(parent);
                    current.setColor(0);
                    gparent.setColor(1);
                    if (gparent == root) {
                        root = current;
                    }
                    parent = ggparent; //updated
                    gparent = gggparent; //new
                }
            }
        }
    }

    //color method used for Insert
    private void colorIns(RedBlackNode current) {
        //if current has two red kids, it makes current red, and the kids black
        if (current.hasLeftChild() && current.hasRightChild()
                && current.getLeftChild().getColor() == 1
                && current.getRightChild().getColor() == 1) {
            current.setColor(1);
            current.getLeftChild().setColor(0);
            current.getRightChild().setColor(0);
        }
        root.setColor(0);
    }

    @Override
    public void delete(int key) {
        remove(key);
    }

    @Override
    public String remove(int key) {
        current = root;
        gggparent = ggparent = gparent = parent = sibling = null;
        while (true) {
            if (current == null) {
                return null;
            } else if (current == root && !current.hasLeftChild() && !current.hasRightChild()) {
                root = null;
                return current.getElement().Value();
            } //current needs to be removed
            else if (current.getElement().Key() == key) {
                RedBlackNode A = current;
                //if current has more than just two children.
                if (current.getLeftChild() != null && current.getRightChild() != null
                        && (current.getLeftChild().hasRightChild() || current.getRightChild().hasLeftChild())) {
                    RedBlackNode replacement;
                    //try to get min Replacement 
                    if (current.hasRightChild()) {
                        replacement = findMin(current.getRightChild());
                    } //else get max Replacement
                    else {
                        replacement = findMax(current.getLeftChild());
                    }
                    current = replacement;

                } //if current is the root node
                else if (current == root) {
                    RedBlackNode replacement = null;
                    //try to get min Replacement 
                    if (current.hasLeftChild()) {
                        replacement = findMin(current.getLeftChild());
                        root = replacement;
                        root.setLeft(null);
                        root.setRight(current.getRightChild());
                    } else {
                        if (current.hasRightChild()) {
                            replacement = findMax(current.getRightChild());
                        }
                        root = replacement;
                        root.setLeft(current.getLeftChild());
                        root.setRight(null);
                    }
                } //current has no children. It is just removed.
                else if (!current.hasLeftChild() && !current.hasRightChild()) {
                    if (parent.getElement().Key() > current.getElement().Key()) {
                        parent.setLeft(null);
                    } else {
                        parent.setRight(null);
                    }
                } //if current has a left child then it is replaced with it's max.
                else if (current.hasLeftChild()) {
                    RedBlackNode replacement;
                    replacement = findMax(current.getLeftChild());
                    if (parent.getElement().Key() > replacement.getElement().Key()) {
                        parent.setLeft(replacement);
                        parent.getLeftChild().setColor(0); //just added
                        parent.getLeftChild().setRight(current.getRightChild()); //just added
                    } else {
                        parent.setRight(replacement);
                        parent.getLeftChild().setColor(0); //just added
                        parent.getRightChild().setLeft(current.getLeftChild()); //just added
                    }
                    if (parentOfMax.getLeftChild() == replacement) {
                        parentOfMax.setLeft(null);
                    } else {
                        parentOfMax.setRight(null);
                    }

                } //if current has a right child then it is replaced with it's min.
                else {
                    RedBlackNode replacement;
                    replacement = findMin(current.getRightChild());
                    if (parent.getElement().Key() > replacement.getElement().Key()) {
                        parent.setLeft(replacement);
                        parent.getLeftChild().setRight(current.getRightChild()); //just added
                        parent.getLeftChild().setColor(0); //just added
                    } else {
                        parent.setRight(replacement);
                        parent.getRightChild().setLeft(current.getLeftChild()); //just added
                        parent.getLeftChild().setColor(0); //just added
                    }
                    if (parentOfMin.getLeftChild() == replacement) {
                        parentOfMin.setLeft(null);
                    } else {
                        parentOfMin.setRight(null);
                    }
                }
                rotateDel();
                colorDel();
                root.setColor(0);
                return A.getElement().Value();
            } //if key > current.key and current has right
            else if (current.hasRightChild() && key > current.getElement().Key()) {
                gggparent = ggparent;
                ggparent = gparent;
                gparent = parent;
                parent = current;
                //assign current's new sibling
                if (current.hasLeftChild()) {
                    sibling = current.getLeftChild();
                } else {
                    sibling = null;
                }
                current = current.getRightChild();
                colorDel();
                rotateDel();
                continue;
            } //if key < current.key and current has left
            else if (current.hasLeftChild() && key < current.getElement().Key()) {
                gggparent = ggparent;
                ggparent = gparent;
                gparent = parent;
                parent = current;
                //assign current's new sibling
                if (current.hasRightChild()) {
                    sibling = current.getRightChild();
                } else {
                    sibling = null;
                }
                colorDel();
                current = current.getLeftChild();
                rotateDel();
                continue;
            }
            break;
        }
        return null;
    }

    /**
     * Finds a minimum replacement node for N.
     *
     * @param N
     * @return
     */
    public RedBlackNode findMin(RedBlackNode N) {
        /*if(N.getLeftChild() == null) return N;
         else{
         parentOfMin = current;
         return findMin(N.getLeftChild());
         }*/
        boolean ran = false;
        while (N.hasLeftChild()) {
            ran = true;
            parentOfMin = N;
            N = N.getLeftChild();
        }
        if (!ran) {
            parentOfMin = current;
        }
        return N;
    }

    /**
     * Finds a maximum replacement node for N.
     *
     * @param N
     * @return
     */
    public RedBlackNode findMax(RedBlackNode N) {
        /*if(N.getRightChild() == null) return null;
         else{
         parentOfMax = current;
         return findMax(N.getRightChild());
         }*/
        boolean ran = false;
        while (N.hasRightChild()) {
            ran = true;
            parentOfMax = N;
            N = N.getRightChild();

        }
        if (!ran) {
            parentOfMax = current;
        }
        return N;
    }

    private void rotateDel() {
        //current has two black children, or no children
        if (current != null && (current.hasLeftChild() && current.hasRightChild() && (current.getLeftChild().getColor() == 0 && current.getRightChild().getColor() == 0))
                || (current != null && !current.hasLeftChild() && !current.hasRightChild())) {
            //sibling exists and parent is red
            if (sibling != null && parent.getColor() == 1) {
                //current<parent<sibling<sibling.right
                if (sibling.hasRightChild() && sibling.getRightChild().getColor() == 1) {
                    if (current.getElement().Key() < parent.getElement().Key()
                            && parent.getElement().Key() < sibling.getElement().Key()) {
                        if (parent != root) {
                            //assign grandparent
                            if (gparent.getElement().Key() > sibling.getElement().Key()) {
                                gparent.setLeft(sibling);
                            } else {
                                gparent.setRight(sibling);
                            }
                        } else {
                            root = sibling;
                        }
                        if (sibling.hasLeftChild()) {
                            parent.setRight(sibling.getLeftChild());
                        } else {
                            parent.setRight(null);
                        }
                        sibling.setLeft(parent);
                        gparent = sibling;
                        current.setColor(1);
                        parent.setColor(0);
                        gparent.setColor(1);
                        gparent.getRightChild().setColor(0);
                    }
                } //sibling.left<sibling<parent<current
                else if (sibling.hasLeftChild() && sibling.getLeftChild().getColor() == 1) {
                    if (sibling.getElement().Key() < parent.getElement().Key()
                            && parent.getElement().Key() < current.getElement().Key()) {
                        if (parent != root) {
                            //assign grandparent
                            if (gparent.getElement().Key() > sibling.getElement().Key()) {
                                gparent.setLeft(sibling);
                            } else {
                                gparent.setRight(sibling);
                            }
                        } else {
                            root = sibling;
                        }
                        if (sibling.hasRightChild()) {
                            parent.setLeft(sibling.getRightChild());
                        } else {
                            parent.setLeft(null);
                        }
                        sibling.setRight(parent);
                        gparent = sibling;
                        current.setColor(1);
                        parent.setColor(0);
                        gparent.setColor(1);
                        gparent.getLeftChild().setColor(0);

                    }
                } //sibling>sibling.left>parent>current
                else if (sibling.hasLeftChild() && sibling.getLeftChild().getColor() == 1) {
                    if (sibling.getElement().Key() > parent.getElement().Key()
                            && parent.getElement().Key() > current.getElement().Key()) {
                        if (parent != root) {
                            //assign grandparent
                            if (gparent.getElement().Key() > sibling.getLeftChild().getElement().Key()) {
                                gparent.setLeft(sibling.getLeftChild());
                            } else {
                                gparent.setRight(sibling.getLeftChild());
                            }
                        }
                        current.setColor(1);
                        parent.setColor(0);
                        sibling.getLeftChild().setColor(1);
                        if (sibling.getLeftChild().hasLeftChild()) {
                            parent.setRight(sibling.getLeftChild().getRightChild());
                        } else {
                            parent.setRight(null);
                        }
                        gparent = sibling.getLeftChild();
                        if (sibling.getLeftChild().hasRightChild()) {
                            sibling.setLeft(sibling.getLeftChild().getRightChild());
                        } else {
                            sibling.setLeft(null);
                        }

                    }
                } //sibling<sibling.right<parent<current
                else if (sibling.hasRightChild() && sibling.getRightChild().getColor() == 1) {
                    if (sibling.getElement().Key() < parent.getElement().Key()
                            && parent.getElement().Key() < current.getElement().Key()) {
                        if (parent != root) {
                            //assign grandparent
                            if (gparent.getElement().Key() > sibling.getRightChild().getElement().Key()) {
                                gparent.setLeft(sibling.getRightChild());
                            } else {
                                gparent.setRight(sibling.getRightChild());
                            }
                        }
                        current.setColor(1);
                        parent.setColor(0);
                        sibling.getRightChild().setColor(1);
                        if (sibling.getRightChild().hasLeftChild()) {
                            sibling.setRight(sibling.getRightChild().getLeftChild());
                        } else {
                            sibling.setRight(null);
                        }
                        gparent = sibling.getLeftChild();
                        if (sibling.getLeftChild().hasRightChild()) {
                            parent.setLeft(sibling.getLeftChild().getRightChild());
                        } else {
                            parent.setLeft(null);
                        }

                    }
                }
            }
        } //if parent.left = current and sibling is red and parent is black
        else if (current != null && parent != null && sibling != null && parent.getLeftChild() == current && sibling.getColor() == 1 && parent.getColor() == 0) {
            //rotate left
            gparent = sibling;
            gparent.setColor(0);
            if (sibling.hasLeftChild()) {
                parent.setRight(sibling.getLeftChild());
                sibling = sibling.getLeftChild();
            } else {
                parent.setRight(null);
                sibling = null;
            }
            parent.setColor(1);
        } //if parent.right = current and sibling is red and parent is black
        else if (current != null && parent != null && sibling != null && parent.getRightChild() == current && sibling.getColor() == 1 && parent.getColor() == 0) {
            //rotate right
            gparent = sibling;
            gparent.setColor(0);
            if (sibling.hasRightChild()) {
                parent.setLeft(sibling.getRightChild());
                sibling = sibling.getRightChild();
            }
            parent.setColor(1);
        }
    }

    //color method used for Delete and Remove.
    private void colorDel() {
        //if root has two children
        if (root.hasLeftChild() && root.hasRightChild()) {
            if (root.getLeftChild().getColor() == 0 && root.getRightChild().getColor() == 0) {
                root.setColor(1);
            }
        }
        //current has two children
        if (current != null && current.hasLeftChild() && current.hasRightChild()) {
            //current has two black children
            if (current.getLeftChild().getColor() == 0 && current.getRightChild().getColor() == 0) {
                //sibling exists and has two kids
                if (sibling != null && sibling.hasLeftChild() && sibling.hasRightChild()) {
                    //sibling has two black kids
                    if (sibling.getLeftChild().getColor() == 0 && sibling.getRightChild().getColor() == 0) {
                        //flip parent color
                        if (parent.getColor() == 1) {
                            parent.setColor(0);
                        } else {
                            parent.setColor(1);
                        }
                        //flip current color
                        if (current.getColor() == 1) {
                            current.setColor(0);
                        } else {
                            current.setColor(1);
                        }
                        //flip sibling color
                        if (sibling.getColor() == 1) {
                            sibling.setColor(0);
                        } else {
                            sibling.setColor(1);
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder treeString = new StringBuilder();

        if (root == null) {
            return "This tree is empty";
        }
        return preorderPrint(root, "root", treeString);
    }

    private String preorderPrint(RedBlackNode current, String prefix, StringBuilder treeString) {
        String line = prefix + ":" + current.getColorString() + "("
                + current.getElement().Key() + "," + current.getElement().Value() + ")\n";
        treeString.append(line);
        if (current.hasLeftChild()) {
            preorderPrint(current.getLeftChild(), prefix + "-left", treeString);
        }
        if (current.hasRightChild()) {
            preorderPrint(current.getRightChild(), prefix + "-right", treeString);
        }

        return treeString.toString();
    }
}
