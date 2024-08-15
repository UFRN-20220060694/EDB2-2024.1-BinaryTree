package edb2.binaryTree.dataStructure;

public class BinaryTree<T extends TreeNodeDelegate<T>> {

   private TreeNode<T> root;

   public BinaryTree() {
      this.root = new TreeNode<T>();
   }

   public void add(T value) {
     this.root.add(value);
   }

   public void remove(int id){
      this.root.remove(id);
   }

   public void list(){
      this.root.list();
   }

   public T min(){
      return this.root.min();
   }

   public T max(){
      return this.root.max();
   }

   public T search(int id){
      return this.root.search(id);
   }
}
