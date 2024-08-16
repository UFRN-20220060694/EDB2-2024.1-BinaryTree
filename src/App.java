import edb2.binaryTree.dataStructure.BinaryTree;
import edb2.binaryTree.domain.Produto;

public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree<Produto> tree = new BinaryTree<Produto>();

        // Root
        tree.add(new Produto(25, "Resma", 15));

        tree.add(new Produto(10, "Lapis", 250));
        tree.add(new Produto(20, "Caneta", 250));
        tree.add(new Produto(38, "Lapis", 100));
        tree.add(new Produto(48, "Lapis", 100));
        tree.add(new Produto(22, "Papel", 250));
        tree.add(new Produto(50, "Lapis", 100));
        tree.add(new Produto(40, "Lapis", 100));
        tree.add(new Produto(30, "Lapis", 100));
        tree.add(new Produto(5, "Papel", 250));
        tree.add(new Produto(12, "Bola", 250));
        tree.add(new Produto(45, "Controle", 100));
        tree.add(new Produto(36, "Lapis", 100));
        tree.add(new Produto(1, "Papel", 250));
        tree.add(new Produto(28, "Lapis", 100));
        tree.add(new Produto(8, "Papel", 250));
        tree.add(new Produto(15, "Papel", 250));

        // tree.remove(25);
        // tree.list();
        // System.out.println(tree.min());
        // System.out.println(tree.max());
        // System.out.println(tree.search(45));
    }
}
