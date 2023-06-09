package com.sancho.kotlin_rerofit_jsonplaceholder

import android.os.Bundle
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sancho.kotlin_rerofit_jsonplaceholder.model.Post
import com.sancho.kotlin_rerofit_jsonplaceholder.model.PostsPhotoItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var textView: TextView
    lateinit var postAdapter: PostAdapter
    var arraylist=ArrayList<Post>()
    var arraylistphotos=ArrayList<PostsPhotoItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerview)
        //Retrofit Build
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //Retrofit And Api soedinit
        val api: Api=retrofit.create(Api::class.java)
        //Zapros when
        val call: Call<ArrayList<PostsPhotoItem>> = api.getAllPhotos()
        call.enqueue(object :Callback<ArrayList<PostsPhotoItem>>{
            override fun onResponse(
                call: Call<ArrayList<PostsPhotoItem>>,
                response: Response<ArrayList<PostsPhotoItem>>
            ) {
                if (response.code()==200){
                Toast.makeText(this@MainActivity,response.code().toString(),Toast.LENGTH_SHORT).show()
                    arraylistphotos=response.body()!!

                    recyclerView.layoutManager=GridLayoutManager(this@MainActivity,2)
                 postAdapter=PostAdapter(this@MainActivity,arraylistphotos)
                    recyclerView.adapter=postAdapter
                }
            }

            override fun onFailure(call: Call<ArrayList<PostsPhotoItem>>, t: Throwable) {

            }
        })



//        val call:Call<ArrayList<Post>> = api.getAllPosts()
//        //Zapros go
//        call.enqueue(object :Callback<ArrayList<Post>>{
//            override fun onResponse(
//                call: Call<ArrayList<Post>>,
//                response: Response<ArrayList<Post>>
//            ) {
//                //Rezultat
//                if (response.code()==200){
//                    Toast.makeText(this@MainActivity,response.code().toString(),Toast.LENGTH_SHORT).show()
//                    arraylist=response.body()!!
//                    //textView.text=arrayList?.get(0)?.title
    //                    recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
    //                    postAdapter=PostAdapter(this@MainActivity,arraylist)
    //                    recyclerView.adapter=postAdapter
//                }
//            }
//
//            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
//
//            }
//        })
    }
}