import java.io.File

fun main() {

    val correctPoints: MutableList<Point> = mutableListOf()
    val gameObjects: MutableList<GameObject> = mutableListOf()
    val gameController = GameController(correctPoints,gameObjects)

    readInput(correctPoints, gameObjects)

    var input = readln().lowercase()

    while (input.isNotEmpty())
    {
        gameController.makeMove(input)

        input = readln().lowercase()
    }
}

fun readInput(correctPoints: MutableList<Point>, gameObjects: MutableList<GameObject>)
{
    val fileName = "src/main/resources/board.txt"
    val lines: List<String> = File(fileName).readLines()
    var y = 0

    lines.forEach {
        val line = it
        
        for(i in 0 until  line.length )
        {
            when(line[i])
            {
                'P'->gameObjects.add(GameObject(Point(i,y),ObjectType.Player))
                'X'->gameObjects.add(GameObject(Point(i,y),ObjectType.Wall))
                'B'->gameObjects.add(GameObject(Point(i,y),ObjectType.Box))
                '✓'->{
                    gameObjects.add(GameObject(Point(i,y),ObjectType.CorrectBox))
                    correctPoints.add(Point(i,y))
                }
                'O'->correctPoints.add(Point(i,y))

            }
        }

        y++
    }
}

