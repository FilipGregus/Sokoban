class GameController(private val correctPoints: MutableList<Point>, private var gameObjects: MutableList<GameObject>)
{
    private var player = gameObjects.find { e -> e.objectType == ObjectType.Player }


    fun makeMove(move: String)
    {
        player = gameObjects.find { e -> e.objectType == ObjectType.Player }
        var delX = 0
        var delY = 0

        when (move)
        {
            "w" ->
            {
                delY = 1
            }

            "a" ->
            {
                delX = 1
            }

            "d" ->
            {
                delX = -1
            }

            "s" ->
            {
                delY = -1
            }

            else -> System.err.println("wrong input")
        }

        val element = gameObjects.find { e ->
            (player?.compareLocation(
                e.getLocation().X + delX, e.getLocation().Y + delY
            )) == true
        }

        if (element != null)
        {
            if (element.objectType != ObjectType.Wall && (gameObjects.find { e ->
                    (player?.compareLocation(
                        e.getLocation().X + delX * 2, e.getLocation().Y + delY * 2
                    )) == true
                }) == null)
            {
                element.move(move, correctPoints)
                player?.move(move, correctPoints)
            }
        } else
        {

            (gameObjects.find { e -> e == player })?.move(move, correctPoints)
        }
    }

    fun drawBoard(width: Int, height: Int)
    {
        println("--------------------\n")

        for (h in 0..<height)
        {
            for (w in 0..<width)
            {
                val gameObject = gameObjects.find { e -> e.compareLocation(w, h) }
                if (gameObject != null)
                {
                    printType(gameObject.objectType)
                } else if ((correctPoints.find { e -> e.compareLocation(w, h) }) != null)
                {
                    print("O")
                } else
                {
                    print(" ")
                }
            }
            println()
        }
    }

    fun checkWin(): Boolean
    {
        return (gameObjects.find { e -> e.objectType == ObjectType.Box }) == null
    }

    private fun printType(objectType: ObjectType)
    {
        when (objectType)
        {
            ObjectType.Player -> print("P")
            ObjectType.Wall -> print("X")
            ObjectType.Box -> print("B")
            ObjectType.CorrectBox -> print("✓")
        }
    }
}