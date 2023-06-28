package dev.leonardom.Lab_0005.firebaseLab5.repositories

import com.google.firebase.firestore.CollectionReference
import dev.leonardom.Lab_0005.firebaseLab5.model.Information
import dev.leonardom.Lab_0005.firebaseLab5.repositories.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
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

    fun getInfoList(): Flow<Result<List<Information>>> = flow{
        try {
            emit(Result.Loading<List<Information>>())

            val infoList = infoList.get().await().map{ documents ->
                documents.toObject(Information::class.java)
            }

            emit(Result.Success<List<Information>>(data = infoList))
        }catch (e: Exception){
            emit(Result.Error<List<Information>>(message = e.localizedMessage ?: "Error Desconocido"))
        }
    }
}