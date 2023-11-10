class GameObject( val locatin : Point, var objectType: ObjectType) {

    fun getLocation(): Point
    {
        return locatin
    }

    fun CompareLocation(X:Int,Y:Int): Boolean
    {
        return this.locatin.X ==X && this.locatin.Y ==Y
    }

    fun move(move: String ,correctPoints: MutableList<Point>)
    {
        var delX = 0
        var delY = 0
        
        
        when(move)
        {
            "w"->delY = -1
            "a"->delX = -1
            "d"->delX = 1
            "s"->delY = 1
        }
        
        if(objectType==ObjectType.Player)
        {
            locatin.X += delX
            locatin.Y += delY
        }
        else if (objectType != ObjectType.Wall)
        {
            locatin.X += delX
            locatin.Y += delY
            
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