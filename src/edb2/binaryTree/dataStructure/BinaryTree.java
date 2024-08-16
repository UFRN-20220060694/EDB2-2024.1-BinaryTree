package edb2.binaryTree.dataStructure;

public class BinaryTree<T extends TreeNodeDelegate<T>> {

   private TreeNode<T> root;

   public BinaryTree() {
      this.root = new TreeNode<T>();
   }

   public void add(T value) {
      this.root.add(value);
   }

   public boolean remove(int id) {
      // Garante que se o nó for folha ele sempre terá um pai
      if (root.isLeaf()) {
         root = null;
         return true;
      }

      return this.root.remove(id);
   }

   public void list() {
      if (root != null) {
         this.root.list();
      }
   }

   public T min() {
      var min = this.root.min();
      if (min == null) {
         return null;
      }

      return min.getData();
   }

   public T max() {
      var max = this.root.max();
      if (max == null) {
         return null;
      }

      return max.getData();
   }

   public T search(int id) {
      return this.root.search(id);
   }
}
