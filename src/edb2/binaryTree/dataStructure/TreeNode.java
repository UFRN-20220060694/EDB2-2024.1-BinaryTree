package edb2.binaryTree.dataStructure;

public class TreeNode<T extends TreeNodeDelegate<T>> {
   private TreeNode<T> parent;
   private TreeNode<T> rightChild;
   private TreeNode<T> leftChild;
   private T data;

   public TreeNode() {
      super();
   }

   private TreeNode(TreeNode<T> parent, T data) {
      this.data = data;
      this.parent = parent;
   }

   public void add(T value) {
      var newValue = (TreeNodeDelegate<T>) value;

      if (data == null) {
         data = value;
         return;
      } else {
         var currentData = (TreeNodeDelegate<T>) data;

         if (currentData.getNodeId() == newValue.getNodeId()) {
            currentData.repeat(value);
         } else if (currentData.getNodeId() > newValue.getNodeId()) {
            var newNode = new TreeNode<T>(this, value);
            if (leftChild == null) {
               leftChild = newNode;
            } else {
               leftChild.add(value);
            }
         } else {
            var newNode = new TreeNode<T>(this, value);
            if (rightChild == null) {
               rightChild = newNode;
            } else {
               rightChild.add(value);
            }
         }
      }
   }

   public void remove(int id) {
   }

   private void remove(int id, TreeNode<T> node) {
      
   }

   private void list(TreeNode<T> node) {
      if (node.getData() == null) {
         System.out.println("Your tree is empty!");
         return;
      }

      if (node.getLeftChild() != null) {
         list(node.getLeftChild());
      }

      System.out.println(node.getData());

      if (node.getRightChild() != null) {
         list(node.getRightChild());
      }
   }

   public void list() {
      list(this);
   }

   public T min() {
      if (this.getData() == null) {
         return null;
      }

      return min(this);
   }

   private T min(TreeNode<T> node) {
      if (node.getLeftChild() == null) {
         return node.getData();
      } else {
         return min(node.getLeftChild());
      }
   }

   public T max() {
      if (this.getData() == null) {
         return null;
      }

      return max(this);
   }

   private T max(TreeNode<T> node) {
      if (node.getRightChild() == null) {
         return node.getData();
      } else {
         return max(node.getRightChild());
      }
   }

   public T search(int id) {
      return search(id, this);
   }

   public T search(int id, TreeNode<T> node) {
      var data = (TreeNodeDelegate<T>)node.getData();

      if (data.getNodeId() == id) {
         return node.getData();
      } else if (data.getNodeId() > id){
         if (node.getLeftChild() == null) {
            return null;
         }
         return search(id, node.getLeftChild());
      } else {
         if (node.getRightChild() == null) {
            return null;
         }
         return search(id, node.getRightChild());
      }
   }

   public T getData() {
      return data;
   }

   public void setData(T data) {
      this.data = data;
   }

   public TreeNode<T> getParent() {
      return parent;
   }

   public TreeNode<T> getRightChild() {
      return rightChild;
   }

   public TreeNode<T> getLeftChild() {
      return leftChild;
   }
}
