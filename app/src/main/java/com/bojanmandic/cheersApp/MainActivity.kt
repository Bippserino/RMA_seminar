package com.bojanmandic.cheersApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bojanmandic.cheersApp.R.id.mainactivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchBtn = findViewById<Button>(R.id.searchButton)
        val randomBtn = findViewById<Button>(R.id.randomButton)
        val searchBar = findViewById<EditText>(R.id.searchBar)

        var searchPerimiters: String = ""
        val request =
            ServiceBuilder.buildService(FakerEndpoints::class.java)
        var call:Call<CocktailList>

        randomBtn.setOnClickListener {
            call = request.getRandom()

            call.enqueue(object : Callback<CocktailList> {
                override fun onResponse(call: Call<CocktailList>, response:
                Response<CocktailList>
                ) {
                    if(response.isSuccessful) {

                        findViewById<RecyclerView>(R.id.cocktailRecycler).apply {
                            layoutManager =
                                LinearLayoutManager(this@MainActivity)
                            adapter =
                                CocktailRecyclerAdapter(response.body()!!)
                        }
                    }
                }
                override fun onFailure(call: Call<CocktailList>, t: Throwable)
                {
                    Log.d("FAIL", t.message.toString())
                }
            })

        }

        searchBtn.setOnClickListener{
            searchPerimiters = searchBar.editableText.toString()

            if (searchPerimiters.isNotEmpty()) {
                call = request.getCocktail(searchPerimiters)

                Log.e("success", call.request().toString())
                call.enqueue(object : Callback<CocktailList> {
                    override fun onResponse(call: Call<CocktailList>, response:
                    Response<CocktailList>
                    ) {
                        if(response.isSuccessful) {

                            findViewById<RecyclerView>(R.id.cocktailRecycler).apply {
                                layoutManager =
                                    LinearLayoutManager(this@MainActivity)
                                adapter =
                                    CocktailRecyclerAdapter(response.body()!!)
                            }
                        }
                    }
                    override fun onFailure(call: Call<CocktailList>, t: Throwable)
                    {
                        Log.d("FAIL", t.message.toString())
                    }
                })
            }

        }
    }}