object TreeViewer {

  def printNode(tree: Tree, indentSrc: String, last: Boolean): Unit = {
    tree match {
      case Empty() => printf("none")
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
}
