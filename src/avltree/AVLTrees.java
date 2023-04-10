/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

/**
 *
 * @author Bernardo
 */
public class AVLTrees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AVLTree tree = new AVLTree();
        tree.insert(13);
        tree.insert(15);
        tree.insert(19);
        tree.insert(8);
        tree.insert(4);
        tree.insert(10);
        tree.insert(17);
        
        tree.list();    
    }
}
