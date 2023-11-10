class GameController (val correctPoints: MutableList<Point>,var gameObjects: MutableList<GameObject>) {
    private var player = gameObjects.find { e -> e.objectType == ObjectType.Player }


    fun makeMove(move: String) {
        player = gameObjects.find { e -> e.objectType == ObjectType.Player }
        when (move) {
            "w" -> {
                val upElement =
                    gameObjects.find { e -> (player?.CompareLocation(e.locatin.X, e.locatin.Y + 1)) == true }

                if (upElement != null) {
                    if (upElement.objectType != ObjectType.Wall && (gameObjects.find { e ->
                            (player?.CompareLocation(
                                e.locatin.X,
                                e.locatin.Y + 2
                            )) == true
                        }) == null) {
                        upElement.move(move, correctPoints)
                        player?.move(move, correctPoints)
                    }
                } else {

                    (gameObjects.find { e -> e == player })?.move(move, correctPoints)
                }
            }

            "a" -> {
                val leftElement =
                    gameObjects.find { e -> (player?.CompareLocation(e.locatin.X + 1, e.locatin.Y)) == true }

                if (leftElement != null) {
                    if (leftElement.objectType != ObjectType.Wall && (gameObjects.find { e ->
                            (player?.CompareLocation(
                                e.locatin.X + 2,
                                e.locatin.Y
                            )) == true
                        }) == null) {
                        leftElement.move(move, correctPoints)
                        player?.move(move, correctPoints)
                    }
                } else {

                    (gameObjects.find { e -> e == player })?.move(move, correctPoints)
                }
            }

            "d" -> {
                val rightElement =
                    gameObjects.find { e -> (player?.CompareLocation(e.locatin.X - 1, e.locatin.Y)) == true }

                if (rightElement != null) {
                    if (rightElement.objectType != ObjectType.Wall && (gameObjects.find { e ->
                            (player?.CompareLocation(
                                e.locatin.X - 2,
                                e.locatin.Y
                            )) == true
                        }) == null) {
                        rightElement.move(move, correctPoints)
                        player?.move(move, correctPoints)
                    }
                } else {

                    (gameObjects.find { e -> e == player })?.move(move, correctPoints)
                }
            }

            "s" -> {
                val downElement =
                    gameObjects.find { e -> (player?.CompareLocation(e.locatin.X, e.locatin.Y - 1)) == true }

                if (downElement != null) {
                    if (downElement.objectType != ObjectType.Wall && (gameObjects.find { e ->
                            (player?.CompareLocation(
                                e.locatin.X,
                                e.locatin.Y - 2
                            )) == true
                        }) == null)
                        if (downElement.objectType != ObjectType.Wall && (gameObjects.find { e ->
                                (player?.CompareLocation(
                                    e.locatin.X,
                                    e.locatin.Y - 2
                                )) == true
                            }) == null) {
                            downElement.move(move, correctPoints)
                            player?.move(move, correctPoints)
                        }
                } else {

                    (gameObjects.find { e -> e == player })?.move(move, correctPoints)
                }
            }
            else -> System.err.println("wrong input")
        }
    }

    fun drawBoard(width: Int, height: Int)
    {
        println("--------------------\n")

        for (h in 0 until height)
        {
            for (w in 0 until width)
            {
                val gameObject = gameObjects.find { e -> e.CompareLocation(w,h)}
                if(gameObject!=null)
                {
                    printType(gameObject.objectType)
                }
                else if((correctPoints.find { e -> e.CompareLocation(w,h)}) !=null)
                {
                    print("O")
                }
                else
                {
                    print(" ")
                }
            }

            println()
        }
    }

    fun checkWin(): Boolean
    {
        if ((gameObjects.find { e -> e.objectType==ObjectType.Box})==null)
        {
            return true
        }

        return false
    }

    private fun printType(objectType: ObjectType)
    {
        when(objectType)
        {
            ObjectType.Player-> print("P")
            ObjectType.Wall-> print("X")
            ObjectType.Box-> print("B")
            ObjectType.CorrectBox-> print("✓")
        }
    }
}