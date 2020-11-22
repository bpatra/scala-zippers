import scala.annotation.tailrec

sealed trait Tree
case class Empty() extends Tree
case class Node(value: String, children: List[Tree]) extends Tree