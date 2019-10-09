package com.example.footballclub

import com.bumptech.glide.Glide
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions

class about : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionbar = supportActionBar
        actionbar!!.title = "About"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgMe: ImageView    = findViewById(R.id.img_item_photo)
        val tImg                = "https://media.licdn.com/dms/image/C5103AQHwZorxOZGxlQ/profile-displayphoto-shrink_200_200/0?e=1576108800&v=beta&t=0TWMTDpG3pSLVRFDqz_5wc3l1Hm6zknfzP59U1s_9fI"

        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgMe)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}