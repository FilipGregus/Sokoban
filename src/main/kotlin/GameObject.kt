class GameObject( val locatin : Point, var objectType: ObjectType) {

    fun getLocation(): Point
    {
        return locatin
    }

    fun CompareLocation(X:Int,Y:Int): Boolean
    {
        return this.locatin.X ==X && this.locatin.Y ==Y
    }

    fun moveUp(correctPoints: MutableList<Point>)
    {
        if(objectType==ObjectType.Player)
        {
            locatin.Y--;
        }
        else if (objectType != ObjectType.Wall)
        {
            locatin.Y--;
            println(correctPoints.find { e->e.CompareLocation(this.locatin.X,this.locatin.Y) })
            if((correctPoints.find { e->e.CompareLocation(this.locatin.X,this.locatin.Y) })!=null)
            {
                this.objectType=ObjectType.CorrectBox
            }
            else
            {
                this.objectType=ObjectType.Box
            }
        }
    }
}