object Task15 extends App {

 case class Terrain(y: Int, x: Int)
 def fgridinit(grid: Array[Array[Char]], tgrid: Array[Array[(Char,Int)]]): Array[Array[(Char,Int)]] ={
    if (grid.isEmpty) tgrid
    else fgridinit(grid.tail, Array(grid.head.zipWithIndex.filter(_._1 == '1')) ++ tgrid)
  }

  def getneighbours(ter: Terrain) = Vector(Terrain(ter.y-1,ter.x),Terrain(ter.y+1,ter.x),Terrain(ter.y,ter.x-1),Terrain(ter.y,ter.x+1))

  def solution(grid: Array[Array[Char]]) = {
    val tt = fgridinit(grid.reverse,Array[Array[(Char,Int)]]())
    val landlist: IndexedSeq[Terrain] = for ( i <- tt.indices; node <- tt(i)) yield Terrain(i, node._2)
    val landmap = (for (land <- landlist) yield (land,getneighbours(land).filter(landlist.contains))).toMap
    def DFS(start: Terrain): Set[Terrain] = {

      def DFS0(v: Terrain, visited: Set[Terrain]): Set[Terrain] = {
        if (visited.contains(v))
          visited
        else {
          val neighbours: Vector[Terrain] = landmap(v) filterNot visited.contains
          neighbours.foldLeft(visited + v)((b, a) => DFS0(a, b))
        }

      }
      DFS0(start, Set())
    }
    val waylist = landlist.map(DFS)
    waylist.distinct.length



  }
  val grid1 = Array(
    Array('1', '1', '1', '1', '0'),
    Array('1', '1', '0', '1', '0'),
    Array('1', '1', '0', '0', '0'),
    Array('0', '0', '0', '0', '0')
  )

  println(s"Task 15 = ${solution(grid1)}") // 1

  val grid2 = Array(
    Array('1', '1', '0', '0', '0'),
    Array('1', '1', '0', '0', '0'),
    Array('0', '0', '1', '0', '0'),
    Array('0', '0', '0', '1', '1')
  )

  println(s"Task 15 = ${solution(grid2)}") // 3

  val grid3 = Array(
    Array('1', '1', '0', '0', '0'),
    Array('1', '0', '1', '0', '0'),
    Array('0', '0', '1', '0', '0'),
    Array('0', '0', '0', '1', '1')
  )

 println(s"Task 15 = ${solution(grid3)}") // 3

  val grid4 = Array(
    Array('1', '0', '0', '0', '0'),
    Array('0', '1', '0', '1', '0'),
    Array('0', '0', '0', '0', '0'),
    Array('1', '1', '0', '1', '1')
  )

  println(s"Task 15 = ${solution(grid4)}") // 5
}
