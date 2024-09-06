package com.example.laundryapp.model

class Client {
    var imageUrl:String=""
    var fullNames:String=""
    var YourJob:String=""
    var gender:String=""
    var age:String=""
    var bio:String=""
    var id:String=""

    constructor(imageUrl:String,fullNames: String,YourJob: String,
                gender: String,age: String,bio: String,id: String){
        this.imageUrl= imageUrl
        this.fullNames=fullNames
        this.YourJob=YourJob
        this.gender=gender
        this.age=age
        this.bio=bio
        this.id=id
    }
    constructor()
}