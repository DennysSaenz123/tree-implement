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

    System.out.println(countNodes(root));
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


