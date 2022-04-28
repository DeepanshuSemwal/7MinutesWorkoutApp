package com.example.a7minworkout



class ExcerciseModel (
    private var id: Int,
    private var name:String,
    private var image:Int,
    private var isCompleted:Boolean,
    private var isSelected:Boolean
    )
{
    fun getId():Int
    {
        return id
    }
    fun setId(id: Int)
    {
        this.id=id;
    }
    fun getName():String
    {
        return name
    }
    fun setName(name:String)
    {
        this.name=name
    }
    fun getImage():Int
    {
        return image
    }
    fun setImage(image: Int)
    {
        this.image=image
    }
    fun getIscompleted():Boolean
    {
        return isCompleted
    }
    fun setIscompleted(isCompleted: Boolean)
    {
        this.isCompleted=isCompleted
    }
    fun getIssletected():Boolean
    {
        return isSelected
    }
    fun setIsselected(isCompleted: Boolean)
    {
        this.isSelected=isSelected
    }
}