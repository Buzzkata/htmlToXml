import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

public class prime extends JFrame
{
    private JTree tree;
    private String example; 
    int num;
    
    public void setNum(int n)  //mutators (setters)
    {
        num=n;
    }
    
    public void setString(String s) 
    {
        example=s;
    }

   

   public void generatePrime() 
   {
   
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Prime Example");
    this.setMinimumSize(new Dimension(400, 500));
    this.setExtendedState(3);

  
    this.tree = new JTree();
    final DefaultMutableTreeNode root = new DefaultMutableTreeNode();

    DefaultTreeModel treeModel = new DefaultTreeModel(root);
    tree.setModel(treeModel);

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
    
    
    for (Node nextChildNode : node.childNodes()) //the iteration process is different than the method in head, generateTree, but I ended up having bugs so used this one instead.
    {
        DefaultMutableTreeNode nextChildTreeNode = new DefaultMutableTreeNode(nextChildNode.nodeName());
        treeNode.add(nextChildTreeNode);
        traverseRecursivly(nextChildNode, nextChildTreeNode); 
		//if(nextChildDocNode.nodeName()=="body")
		//break;        
		//if(nextChildDocNode.nodeName()=="head");
		//else treeNode.add(nextChildTreeNode);
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