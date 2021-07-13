package com.example.covidsee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var covidViewAdapter: CovidViewAdapter
    private lateinit var covidList: MutableList<CovidVO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        this.navigationController()
        this.getCovidApi()
    }

    private fun navigationController() {

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation_view)
        val navController = findNavController(R.id.container_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.allRegionsMenuFragment, R.id.gwangjuRegionMenuFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun getCovidApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl(CovidApi.DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val covidService = retrofit.create(CovidService::class.java)
        covidService
            .getDocument(CovidApi.TOKEN)
            .enqueue(object : Callback<RegionVO> {
                override fun onFailure(call: Call<RegionVO>, t: Throwable) {
                    Log.d("실패실패..", "${t.message.toString()}")
                }

                override fun onResponse(call: Call<RegionVO>, response: Response<RegionVO>) {
                    if (response.isSuccessful) {
                        Log.d("성공성공!", response!!.body().toString())

                        covidList = mutableListOf<CovidVO>(
                            response.body()!!.korea,
                            response.body()!!.seoul,
                            response.body()!!.busan,
                            response.body()!!.incheon,
                            response.body()!!.gwangju,
                            response.body()!!.jeonbuk,
                            response.body()!!.chungbuk,
                            response.body()!!.jeonnam,
                            response.body()!!.gyeongbuk,
                            response.body()!!.daegu,
                            response.body()!!.ulsan,
                            response.body()!!.daejeon,
                            response.body()!!.sejong,
                            response.body()!!.chungnam,
                            response.body()!!.gyeonggi,
                            response.body()!!.gyeongnam,
                            response.body()!!.gangwon,
                            response.body()!!.jeju,
                            response.body()!!.quarantine
                        ) ?: mutableListOf()

                        covidViewAdapter = CovidViewAdapter(covidList)

                        val recyclerView: RecyclerView = findViewById(R.id.recycler_list)
                        recyclerView.adapter = covidViewAdapter

                        val layoutManager = LinearLayoutManager(baseContext)
                        recyclerView.layoutManager = layoutManager
                    }
                }
            })
    }
}
