Visual representation :
http://www.youtube.com/watch?v=vDHFF4wjWYU

Notes:
1. In the RedBlackNode class I added two new methods to set right and left child. This is used for my insert method.

2. In the RedBlackNode class I added hasRightChild and hasLeftChild methods which are used for insert.

3. In the RedBlackNode class I added one new method to set the color of the node. 1 = red and 0 = black.

4. In the RedBlackTree class I added one new method called rotate which can be utilized in insert, delete and remove.

5. In the RedBlackTree class I added treeString as a field.



Insert:
use while loop to determine which direction to continue the traversal.
	if current.element.key > key{ current.getleftchild;}
then do the rotates mentioned in the book until all paths do not include two consecutive red nodes.