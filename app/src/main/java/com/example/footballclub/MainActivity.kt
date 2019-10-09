package com.example.footballclub

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    private var list: ArrayList<Club> = arrayListOf()
    private lateinit var recyClub: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title = "Club Eropa"

        recyClub = findViewById(R.id.recy_club)
        recyClub.setHasFixedSize(true)

        list.addAll(ClubData.listData)
        showRecycerList()
    }

    private fun showRecycerList() {
        recyClub.layoutManager  = LinearLayoutManager(this)
        val listClubAdapter     = ListClubAdapter(list)
        recyClub.adapter        = listClubAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?) : Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity, about::class.java)
                startActivity(iAbout)
            }
        }
    }
}
