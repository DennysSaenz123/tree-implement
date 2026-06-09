import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(10);
    //System.out.println(root.value);

    root.left = new TreeNode<>(9);
    root.right = new TreeNode<>(15);

    root.left.left = new TreeNode<>(5);
    root.left.right = new TreeNode<>(2);

    root.right.left = new TreeNode<>(-3);
    root.right.right = new TreeNode<>(5);
    root.right.right.right = new TreeNode<>(22);


    TreeNode<String> stringRoot = new TreeNode<>("Hello");
    //System.out.println(root.value);

    stringRoot.left = new TreeNode<>("hi");
    stringRoot.right = new TreeNode<>("dkdwede");

    stringRoot.left.left = new TreeNode<>("deioeo");
    stringRoot.left.right = new TreeNode<>("wirld");

    stringRoot.right.left = new TreeNode<>("dleioeo");
    stringRoot.right.right = new TreeNode<>("wirld");
    stringRoot.right.right.right = new TreeNode<>("pops");

    preOrder(stringRoot);
    //inOrder(stringRoot);
    //postOrder(stringRoot);

    // System.out.println(countNodes(root));

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1);

    TreeNode<Integer> current = megaRoot;

    for(int i =2; i < 100_001; i++){
      current.right = new TreeNode<>(i);
      current = current.right;
    }

    // preOrder(megaRoot);

    // preOrderIterative(megaRoot);

    levelOrder(root);
  }

  public static void preOrderIterative(TreeNode<?> root){
    Stack<TreeNode<?>> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()){
      TreeNode<?> current = stack.pop();
      if(current == null) continue;
      System.out.println(current.value);
      stack.push(current.right);
      stack.push(current.left);
    }

  }

  public static void levelOrder(TreeNode<?> root){
    Queue<TreeNode<?>> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      TreeNode<?> current = queue.remove();
      if(current == null) continue;
      System.out.println(current.value);
      queue.offer(current.left);
      queue.offer(current.right);
    }
  }

  

  //Pre-order traversal that are only greater than a certain value

  public static void printGraterThan(TreeNode<Integer> current, int value){
    if(current == null) return;
    if(current.value > value){
      System.out.println(current.value);
    }
    printGraterThan(current.left, value);
    printGraterThan(current.right, value);
  }

  public static int countNodes(TreeNode<?> current){
    if(current == null) return 0;
    int total = 1;
    total += countNodes(current.left);
    total += countNodes(current.right);
    return total;
  }

  public static void preOrder(TreeNode<?> current){

      if(current == null) return;
      System.out.println(current.value);
      preOrder(current.left);
      preOrder(current.right);

  }

  public static void inOrder(TreeNode<?> current){
    if(current == null) return;
    inOrder(current.left);
    System.out.println(current.value);
    inOrder(current.right);
  }

  public static <E> void postOrder(TreeNode<E> current){
    if(current == null) return;
    postOrder(current.left);
    postOrder(current.right);

    E myValue = current.value;

    System.out.println(myValue);
  }   
}

