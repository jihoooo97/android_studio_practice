package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_board_item__detail.*

class BoardItem_Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_item__detail)

        getTextInfo()

        back.setOnClickListener {
            onBackPressed()
        }
    }

    fun getTextInfo() {
        val name = intent.getStringExtra("name")
        val text = intent.getStringExtra("text")

        item_detail_name.setText(name)
        item_detail_text.setText(text)
    }
}