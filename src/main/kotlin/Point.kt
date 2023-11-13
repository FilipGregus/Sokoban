class Point(var X: Int, var Y: Int)
{
    fun compareLocation(x: Int, y: Int): Boolean
    {
        return this.X == x && this.Y == y
    }
}