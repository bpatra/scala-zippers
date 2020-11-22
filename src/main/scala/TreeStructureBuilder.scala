object TreeStructureBuilder{
  def buildTreeFromPathList(filePaths: List[List[String]]): Tree = {
    filePaths.foldRight(Empty.apply(): Tree)((filePath: List[String], currentTree: Tree) => mergePathIntoTree(currentTree, filePath) )
  }

  def buildSingleBranchedTree(filePath: List[String]): Tree = filePath match {
    case Nil => Empty.apply()
    case head::tail => Node.apply(head, List(buildSingleBranchedTree(tail)))
  }

  def mergePathIntoTree(tree: Tree, filePath: List[String]) : Tree = (tree, filePath) match {
    case (Node(value, _), head::tail) if value != head => throw new Exception("Recursive invariant condition not satisfied")
    case (Node(value, _), head::Nil) => tree
    case (Node(value, children), head::tail) => {
      val branchNextValue = tail.head;
      val targetChild = children.find(child => child match {
        case Empty() => false
        case Node(value, _) => value == branchNextValue
      })
      targetChild match {
        case Some(tree) => mergePathIntoTree(tree, tail)
        case None => Node(value, Node(branchNextValue, List()):: children)
      }
    }
    case (Empty(), _) => buildSingleBranchedTree(filePath)
  }
}