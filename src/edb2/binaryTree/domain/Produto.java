package edb2.binaryTree.domain;

import edb2.binaryTree.dataStructure.TreeNodeDelegate;

public class Produto implements TreeNodeDelegate<Produto> {
   private int id;
   private String name;
   private int qtd;

   public Produto(int id, String name, int qtd) {
      this.id = id;
      this.name = name;
      this.qtd = qtd;
   }

   public Produto() {
      super();
      qtd = 0;
      name = "";
   }

   public int getQtd() {
      return qtd;
   }

   public void setQtd(int qtd) {
      this.qtd = qtd;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public boolean equals(Object produto) {
      return this.id == ((Produto)produto).getId();
   }

   @Override
   public int getNodeId() {
      return getId();
   }

   @Override
   public void repeat(Produto node) {
      setQtd(getQtd() + node.getQtd());
   }

   @Override
   public String toString() {
      var ret = String.format("ID: %d, Name: %s, Qtd: %d", getId(), getName(), getQtd());
      return ret;
   }
}
