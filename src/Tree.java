
import java.util.LinkedList;
import java.util.Queue;
/*
Tree introduction :
**********************
    Tree is a non linear data structure with hierarchial relationships between
its elements without having any cycle

properties :
* represent heirarchial data
* Each node has two components :
            * data
            * link
* Base category and sub categories under it

Why tree :
**********
 * quicker and easier access to the data
 * store hierarhial data , like folder structure ,organization data .
 eg :
    Binary search tree
    AVL
    red black tree

TREE TERMINOLOGY :
******************
 Root           : top node without parent
 Edge           : link between parent and child
 Leaf           : a node which does not have children
 sibling        : children of same parent
 Amcestor       : parent , grandparent of a node
 depth of a node: a length of the path from root to node
 height of node : a length of the path from node to deepest node
 depth of tree  : depth of root node (root = 0)
 height of tree : height of root node
*/




/*
* BINARY TREE
* ***********
*   - Binary tree are the data structures in which each node has at most two children often referred to as left and right children .
*   - Family of data structure (BST, AVL , red black trees)
*   - prerequiste for mode advanced trees mentioned above .
*
* TYPES :
* ********
*   FULL BINARY TREE :
* **********************
*   each node has 0 or 2 children
*   PERFECT BINARY TREE :
* **************************
*   all non leaf nodes has two children at same level .
*   COMPLETE BINARY TREE
* ***********************
*   all nodes at leaf level is as left as possibile .
*
* */

/*
* implementation using Linked list and array
* ******************************************
* */
class TreeNode
{
    TreeNode left ;
    String data ;
    TreeNode right ;
    public int height;
}

class BinaryTree
{
    TreeNode root ;
    public BinaryTree()
    {
        root = null;
    }
/*
* A root node is null .
* The tree exists and we have to look for a first vacant place .
* Insertion :
**************
*   - we prefer level order traversal
*
*
*/
    public void insertion(String element)
    {
        TreeNode node = new TreeNode();node.data=element;
        if(root == null)
        {
            root = node;
            System.out.println("element inserted succesfully");
        }
        else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty())
            {
                TreeNode present = queue.remove();
                if(present.left == null)
                {
                    present.left = node;
                    System.out.println("element inserted succesfully");
                    break;
                }
                else if(present.right==null)
                {
                    present.left = node;
                    System.out.println("element inserted succesfully");
                    break;
                }
                else {
                        queue.add(present.left);
                        queue.add(present.right);
                }
            }
        }
    }
    /*
    *DELETION IN BINARY SEARCH
    **************************
    * case 1 :
    *   delete middle node
    *   steps:
    *       step 1 : Find the node
    *       step 2 : Find the deepest node
    *       step 3 : set deepest node's value to current node
    *       step 4 : delete deepest node
    */

    // Method for deepest node
    public TreeNode deepestnode()
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode present =null;
        while(!queue.isEmpty())
        {
            present = queue.remove();
            if(present.left!=null)
            {
                queue.add(present.left);
            }
            if(present.right!=null)
            {
                queue.add(present.right);
            }
        }
        return present;
    }
    public void deleteDeepestNodeMethod()
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode previous , present =null;
        while(!queue.isEmpty())
        {
            previous = present;
            present = queue.remove();
                if(present.left == null)
                {
                    previous.right = null;
                    return;
                }else if(present.right == null)
                {
                    present.left = null;
                }
                queue.add(present.left);
                queue.add(present.right);
            }

    }

    public  void deleteNode(String value)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.remove();
            if(node.data.equals(value))
            {
                node.data = deepestnode().data;
                deleteDeepestNodeMethod();
                System.out.println("element is deleted");
                return;
            }
            if(node.left!=null)
            {
                queue.add(node.left);
            }
            if(node.right!=null)
            {
                queue.add(node.right);
            }
        }
        System.out.println("The node doesnt exist in binary tree");
    }
    public void preorder(TreeNode node)
    {
        if(node == null) {
            //System.out.println("sorry!!! tree is empty");
            return;
        }
        else {
            System.out.print(node.data+" ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void inorder(TreeNode node)
    {
        if(node == null)
        {
            return;
        }
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    public void postorder(TreeNode node)
    {
        if(node == null)
        {
            return ;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
    }

    public void levelOrderTraversal()
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode present = queue.remove();
            System.out.print(present.data+" ");
            if(present.left!=null)
            {
                queue.add(present.left);
            }
            if(present.right!=null)
            {
                queue.add(present.right);
            }
        }
    }
    /*
    *for searching we prefer LEVEL ORDER TRAVERSAL
    * reason :
    *   - in depth first search we use queue it performs better than stack .
    */

    public boolean search(String element)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode current = queue.remove();
            if(current.data.equals(element))
            {
                return true;
            }
            else {
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return false;
    }

}
/*
*BREADTH FIRST SEARCH
*   - Level order traversal
* DEPTH FIRST SEARCH
*   - Preorder traversal
*   - Inorder traversal
*   - Post order traversal
*/
public class Tree
{
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode t1  = new TreeNode();
        t1.data = "hello" ;
        bt.root = t1;
        TreeNode t2 = new TreeNode();
        t2.data = "my" ;
        bt.root.left = t2;
        TreeNode t3  = new TreeNode();
        t3.data = "name" ;
        bt.root.right = t3;
        TreeNode t4  = new TreeNode();
        t4.data = "is" ;
        bt.root.left.left = t4;
        TreeNode t5  = new TreeNode();
        t5.data = "murthy" ;
        bt.root.left.right = t5;
//        bt.levelOrderTraversal();
//        if(bt.search("name"))
//        {
//            System.out.println("found");
//        }
//        else {
//            System.out.println("not found");
//        }
       bt.insertion("family");
       bt.levelOrderTraversal();
       bt.deleteNode("name");
       bt.levelOrderTraversal();

    }
}