class GameController (val correctPoints: MutableList<Point>,var gameObjects: MutableList<GameObject>){
    private var player = gameObjects.find { e ->e.objectType ==ObjectType.Player }


    fun makeMove(move :String)
    {
        player = gameObjects.find { e ->e.objectType ==ObjectType.Player }
        when(move)
        {

            "w"->{

                val upElement = gameObjects.find { e-> (player?.CompareLocation(e.locatin.X,e.locatin.Y+1))==true}

                if(upElement!=null)
                {
                    if(upElement.objectType!=ObjectType.Wall && (gameObjects.find { e-> (player?.CompareLocation(e.locatin.X,e.locatin.Y+2))==true})==null)
                    {
                        upElement.moveUp(correctPoints)
                        player?.moveUp(correctPoints)
                    }
                }else {

                    (gameObjects.find { e -> e == player })?.moveUp(correctPoints)
                }
            }
        }
    }

    private fun validateMove(move :String) :Boolean
    {



        when(move)
        {
            "w"->{



            }
        }

        return false
    }
}