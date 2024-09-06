package com.example.laundryapp.model

class User {
    var FullNames: String = ""
    var YourJob: String = ""
    var email: String = ""
    var password: String = ""
    var userid: String = ""
    constructor(fullNames: String,YourJob: String,
                email: String,password: String,userid: String){
        this.FullNames=fullNames
        this.YourJob=YourJob
        this.email=email
        this.password=password
        this.userid=userid
    }
    constructor()
}