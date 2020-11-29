object TreeStructureBuilder{

  def buildTreeFromPathList(filePaths: List[List[String]]): Node = {
    val tree =  buildSingleBranchedTree(filePaths.head)
    filePaths.tail.foreach((filePath: List[String])
    => mergePathIntoTree(tree, filePath) )
    tree
  }

  def buildSingleBranchedTree(filePath: List[String]): Node = filePath match {
    case List(elt) => Node.apply(elt, List())
    case head::tail => Node.apply(head, List(buildSingleBranchedTree(tail)))
  }

  def mergePathIntoTree(tree: Node, filePath: List[String]) : Unit = (tree, filePath) match {
    case (Node(value, _), head :: _) if value != head => throw new Exception("Recursive invariant condition not satisfied")
    case (Node(_, _), _ :: Nil) => // tail list is empty there is nothing more to do
    case (node@Node(_ , children), _ :: tail) => { // by loop invariant node.value hand matched list head are equal
      // first, let's see if there is already a children that could be match for our branch next value
      val targetChild = children.find(child => child match {
        case Node(value, _) => value == tail.head //branch next value: tail.value exists because of previous matches
      })
      targetChild match {
        case Some(childValue) => mergePathIntoTree(childValue, tail)
        case None => {
          val newChild = Node(tail.head, List())
          node.addChild(newChild)
          mergePathIntoTree(newChild, tail)
        }
      }
    }
  }
}