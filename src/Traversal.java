public class Traversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    //System.out.println(root.data);

    root.left = new TreeNode(9);
    root.right = new TreeNode(15);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(2);

    root.right.left = new TreeNode(-3);
    root.right.right = new TreeNode(5);
    root.right.right.right = new TreeNode(22);

    // preOrder(root);
    // System.out.println();
    int result = sumOdd(root);
    System.out.println(result);
  }

  public static void preOrder(TreeNode current){

      if(current == null) return;
      System.out.println(current.data);
      preOrder(current.left);
      preOrder(current.right);

  }
  public static int sumAll(TreeNode node){
    if(node == null) return 0;
    int total = node.data;
    total += sumAll(node.left);
    total += sumAll(node.right);
    return total;
  }

  public static int sumOdd(TreeNode node){
    if(node == null) return 0;
    int total = 0;

    if(node.data %2 != 0){
      total += node.data;
    }

    total += sumOdd(node.left);
    total += sumOdd(node.right);

    return total;
  }
}
