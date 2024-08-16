package edb2.binaryTree.dataStructure;

class TreeNode<T extends TreeNodeDelegate<T>> {
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

   public boolean isLeaf() {
      return getLeftChild() == null && getRightChild() == null;
   }

   public boolean hasSingleSon() {
      return getLeftChild() == null ^ getRightChild() == null;
   }

   public void removeLeftChild() {
      this.leftChild = null;
   }

   public void removeRightChild() {
      this.rightChild = null;
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

   public boolean remove(int id) {
      return remove(id, this) != null;
   }

   private TreeNode<T> remove(int id, TreeNode<T> node) {
      if (node == null) {
         return null;
      }
      var data = (TreeNodeDelegate<T>) node.getData();

      if (data.getNodeId() > id) {
         node.setLeftChild(remove(id, node.getLeftChild()));
      } else if (data.getNodeId() < id) {
         node.setRightChild(remove(id, node.getRightChild()));
      } else {
         if (node.isLeaf()) {
            return null;
         }

         if (node.hasSingleSon()) {
            if (node.getLeftChild() == null) {
               return node.getRightChild();
            } else if (node.getRightChild() == null) {
               return node.getLeftChild();
            }
         }

         var successor = node.getRightChild().min();
         node.setData(successor.getData());
         node.rightChild = remove(((TreeNodeDelegate<T>) successor.getData()).getNodeId(), node.getRightChild());
      }

      return node;
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

   public TreeNode<T> min() {
      if (this.getData() == null) {
         return null;
      }

      return min(this);
   }

   private TreeNode<T> min(TreeNode<T> node) {
      if (node.getLeftChild() == null) {
         return node;
      } else {
         return min(node.getLeftChild());
      }
   }

   public TreeNode<T> max() {
      if (this.getData() == null) {
         return null;
      }

      return max(this);
   }

   private TreeNode<T> max(TreeNode<T> node) {
      if (node.getRightChild() == null) {
         return node;
      } else {
         return max(node.getRightChild());
      }
   }

   public T search(int id) {
      return search(id, this);
   }

   public T search(int id, TreeNode<T> node) {
      var data = (TreeNodeDelegate<T>) node.getData();

      if (data.getNodeId() == id) {
         return node.getData();
      } else if (data.getNodeId() > id) {
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

   public void setRightChild(TreeNode<T> rightChild) {
      this.rightChild = rightChild;
   }

   public TreeNode<T> getLeftChild() {
      return leftChild;
   }

   public void setLeftChild(TreeNode<T> leftChild) {
      this.leftChild = leftChild;
   }
}
