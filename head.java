import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

public class head extends JFrame
{
    private JTree tree;
    private String example; 
    int num;
    
    public void setNum(int n)
    {
        num=n;
    }
    
    public void setString(String s)
    {
        example=s;
    }

   

   public void generateHead() 
   {
   
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Head Example");
    this.setMinimumSize(new Dimension(400, 500));
    this.setExtendedState(3);

    
    this.tree = new JTree();
    DefaultMutableTreeNode root = new DefaultMutableTreeNode();

   
    DefaultTreeModel treeM = new DefaultTreeModel(root);
    tree.setModel(treeM);


    this.add(new JScrollPane(tree));

    Document doc = Jsoup.parse(test);
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
        DefaultMutableTreeNode nextChildTreeNode = new DefaultMutableTreeNode(nextChildNode.nodeName());
        treeNode.add(nextChildTreeNode);
        traverseRecursivly(nextChildNode, nextChildTreeNode);
    }
}

private static void expandAllNodes(JTree tree) 
{
    int row = tree.getRowCount();
    int i = 0;
    while (i < row) {
        tree.expandRow(i);
        i += 1;
        row = tree.getRowCount();
    }
 }

}