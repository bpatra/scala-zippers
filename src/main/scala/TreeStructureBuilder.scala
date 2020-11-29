object TreeStructureBuilder{

  def buildTreeFromPathList(filePaths: List[List[String]]): Mutable[Tree] = {
    val tree = new Mutable[Tree](Empty.apply())
    filePaths.foreach((filePath: List[String])
    => mergePathIntoTree(tree, filePath) )
    tree
  }

  def buildSingleBranchedTree(filePath: List[String]): Tree = filePath match {
    case Nil => Empty.apply()
    case List(elt) => Node.apply(elt, List())
    case head::tail => Node.apply(head, List(buildSingleBranchedTree(tail)))
  }

  def mergePathIntoTree(tree: Mutable[Tree], filePath: List[String]) : Unit = (tree.value, filePath) match {
    case (Empty(), _) => tree.value = buildSingleBranchedTree(filePath)
    case (Node(value, _), head :: _) if value != head => throw new Exception("Recursive invariant condition not satisfied")
    case (Node(_, _), _ :: Nil) =>
    case (node@Node(_ , children), _ :: tail) => {
      val targetChild = children.find(child => child match {
        case Empty() => false
        case Node(value, _) => value == tail.head
      })
      targetChild match {
        case Some(childValue) => mergePathIntoTree(new Mutable[Tree](childValue), tail)
        case None => {
          val newChild = Node(tail.head, List())
          node.addChild(newChild)
          mergePathIntoTree(new Mutable[Tree](newChild), tail)
        }
      }
    }
  }
}