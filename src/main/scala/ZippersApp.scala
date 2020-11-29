object ZippersApp {
  def main(args: Array[String]): Unit ={
    val branch1 = List("a","b","c")
    val branch2 = List("a","b","d")
    val branch3 = List("a", "b", "c")
    val branch4 = List("a", "d")

    val tree = TreeStructureBuilder.buildTreeFromPathList(List(branch4, branch3, branch2, branch1))

    println(s"mutable tree: ${tree.value.##}")
    TreeViewer.printTree(tree.value)
  }
}
