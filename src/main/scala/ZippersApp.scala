object ZippersApp {
  def main(args: Array[String]): Unit ={
    val branch1 = List("a", "b", "c")
    val branch2 = List("a", "b", "d")
    val branch3 = List("a", "b", "c")
    val branch4 = List("a", "d")
    val branch78 = List("a", "z" , "x")

    val tree = TreeStructureBuilder.buildTreeFromPathList(List(branch4, branch3, branch2, branch1, branch78))

    TreeViewer.printTree(tree)
  }
}
