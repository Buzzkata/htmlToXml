import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.tree.TreeNode;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import javax.swing.tree.DefaultTreeModel;
import java.awt.Dimension;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

public class generateTree extends JFrame
{
    private JTree tree;
    private String example; 
    
    public void setString(String s)
    {
        example=s;
    }

   

   public void generateT() 
   {
    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Tree generating example");
    this.setMinimumSize(new Dimension(400, 500));
    this.setExtendedState(3);

    this.tree = new JTree();
    final DefaultMutableTreeNode root = new DefaultMutableTreeNode();

    DefaultTreeModel treeM = new DefaultTreeModel(root);
    tree.setModel(treeM);

    this.add(new JScrollPane(tree));

    Document doc = Jsoup.parse(example);
   
    traverseRecursivly(doc.getAllElements().first(), root);

    this.expandAllNodes(tree);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
}

private static void traverseRecursivly(Node node, DefaultMutableTreeNode treeNode) //recursive traversal of tree
{
    
    
    for (Node nextChildNode : node.childNodes()) 
    {
		//create a mutable tree node
        DefaultMutableTreeNode nextChildTreeNode = new DefaultMutableTreeNode(nextChildNode.nodeName());
        // add next tree child node to tree node 
        treeNode.add(nextChildTreeNode);
        traverseRecursivly(nextChildNode, nextChildTreeNode); //traverse using next values as parameters
    }
}


private static void expandAllNodes(JTree tree) 
{
    int j = tree.getRowCount();
    int i = 0;
    while (i < j) {
        tree.expandRow(i);
        i += 1;
        j = tree.getRowCount();
    }
 }

}