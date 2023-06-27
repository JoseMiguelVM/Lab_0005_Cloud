package dev.leonardom.Lab_0005.firebaseLab5.repositories

import com.google.firebase.firestore.CollectionReference
import dev.leonardom.Lab_0005.firebaseLab5.model.Information
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InfoRepository
@Inject
constructor(
    private val infoList: CollectionReference
){
    fun addNewInfo(information: Information){
        try{
            infoList.document(information.id).set(information)
        }catch(e: Exception){
            e.printStackTrace()
        }
    }
}