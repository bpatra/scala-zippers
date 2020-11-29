object TreeViewer {

  def printNode(tree: Node, indentSrc: String, last: Boolean): Unit = {
    tree match {
      case Node(value, children) =>{
        var indent = indentSrc;
        printf(indentSrc)

        if (last) {
          printf("└╴")
          indent += "  "
        }
        else {
          printf("├╴")
          indent += "│ "
        }
        println(value);

        var i = -1
        children.foreach(child => {
          i += 1;
          TreeViewer.printNode(child, indent, i == children.length - 1)
        })
      }
    }
  }


  def printTree(tree: Node): Unit ={
    printNode(tree, indentSrc = "", last = true)
  }
}
