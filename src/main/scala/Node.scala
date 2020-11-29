case class Node(value: String, var children: List[Node]) {
  def addChild(newChild: Node): Unit ={
    this.children = newChild :: children
  }
}