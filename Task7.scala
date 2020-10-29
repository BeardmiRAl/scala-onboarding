import scala.annotation.tailrec
import scala.collection.mutable.RedBlackTree

/*
Дан массив неотрицательных целых чисел, где вы изначально
располагаетесь на начальном индексе массива.
Каждый элемент массива представляет вашу максимальную длину прыжка в этой позиции.
Определите, сможете ли вы достичь последнего индекса.
*/


case class Node(source: Int, dest: Int)

object Task7 extends App {
  def solution(nums: Array[Int]) = {
    val StartNode = 0
    val FinishNode = nums.length - 1
    val n = nums.zipWithIndex
    val graphmap = (for (node <- n if (node._1 != 0 && node._2 != n.length - 1); i <- 1 to node._1) yield Node(node._2, node._2 + i)).toList
    val startNodes = graphmap.filter(_.source == StartNode)
    val finishNodes = graphmap.filter(_.dest == FinishNode)


  def findPaths(allNodes: List[Node], newNode: Node, path: List[Node] = Nil, isVisited: List[Int] = Nil, allPaths: List[List[Node]] = Nil): List[List[Node]] = {
    if (isVisited.contains(newNode.dest)) {
      allPaths ++ List(path)
    } else {
      val nextNodes = allNodes.filter(_.source == newNode.dest)
      if (nextNodes.isEmpty) {
        allPaths ++ List(path :+ newNode)
      } else if (nextNodes.size > 1) {
        nextNodes.flatMap { node =>
          findPaths(allNodes, node, path :+ newNode, isVisited :+ newNode.source)
        }
      } else {
        findPaths(allNodes, nextNodes.head, path :+ newNode, isVisited :+ newNode.source)
      }
    }
  }

  val pathstoend = startNodes.flatMap(node => findPaths(graphmap, node)).flatten.filter(_.dest == FinishNode)
  if (pathstoend.length > 0) true
    else false



}



  println(s"Task 7 = ${solution(Array(2, 3, 1, 1, 4))}")
  // true

  println(s"Task 7 = ${solution(Array(3, 2, 1, 0, 4))}")
  // false

  println(s"Task 7 = ${solution(Array(3, 2, 3, 0, 0, 0))}")
  // true

}