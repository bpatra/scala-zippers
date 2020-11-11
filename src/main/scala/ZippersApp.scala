import scala.Console.print

object ZippersApp {
  def main(args: Array[String]): Unit ={
    val branch1 = List("a","b","c")
    val branch2 = List("a","b","d")
    val branch3 = List("a","f")

    val tree = TreeStructureBuilder.buildTreeFromPathList(List(branch1, branch2, branch3))
    printf("Hello")
  }

}
