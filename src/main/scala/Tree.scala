import scala.annotation.tailrec

sealed trait Tree
case class Empty() extends Tree
case class Node(value: String, var children: List[Tree]) extends Tree{
  def addChild(newChild: Tree): Unit ={
    this.children = newChild :: children
  }
}