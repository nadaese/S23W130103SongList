package kr.ac.kumoh.ce.s23w130103songlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SongViewModel : ViewModel() {
    companion object {
        const val SERVER_URL = "https://port-0-s23w10backend-1igmo82clookyw7l.sel5.cloudtype.app/"
    }

    private val _songList = MutableLiveData<List<Song>>()
    val songList: LiveData<List<Song>>
        get() = _songList

    private val songApi: SongApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        songApi = retrofit.create(SongApi::class.java)
    }
}