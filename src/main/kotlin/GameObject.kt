class GameObject(private val location: Point, var objectType: ObjectType)
{

    fun getLocation(): Point
    {
        return location
    }

    fun compareLocation(x: Int, y: Int): Boolean
    {
        return this.location.X == x && this.location.Y == y
    }

    fun move(move: String, correctPoints: MutableList<Point>)
    {
        var delX = 0
        var delY = 0

        when (move)
        {
            "w" -> delY = -1
            "a" -> delX = -1
            "d" -> delX = 1
            "s" -> delY = 1
        }

        if (objectType == ObjectType.Player)
        {
            location.X += delX
            location.Y += delY
        } else if (objectType != ObjectType.Wall)
        {
            location.X += delX
            location.Y += delY

            if ((correctPoints.find { e -> e.compareLocation(this.location.X, this.location.Y) }) != null)
            {
                this.objectType = ObjectType.CorrectBox
            } else
            {
                this.objectType = ObjectType.Box
            }
        }
    }
}