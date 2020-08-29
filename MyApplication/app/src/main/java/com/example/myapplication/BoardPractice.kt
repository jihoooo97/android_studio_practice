package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.board_item.*

class BoardPractice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_practice)

        val board = createBoard()
        createBoardList(board)

    }

    fun createBoard(itemIndex: Int = 20, board: Board = Board()): Board {
        for (i in 0 until itemIndex) {
            board.addItem(
                Item(name = "Item"+i, text = "this text is "+i+" text!")
            )
        }
        return board
    }

    fun createBoardList(board: Board) {
        val layoutInflater = LayoutInflater.from(this@BoardPractice)
        val container = findViewById<LinearLayout>(R.id.board_list_container)

        for(i in 0 until board.itemlist.size) {
            val view = layoutInflater.inflate(R.layout.board_item, null)
            val itemNameView = view.findViewById<TextView>(R.id.item_name)

            itemNameView.setText(board.itemlist.get(i).name)

            addSetOnClick(board.itemlist.get(i), view)
            container.addView(view)
        }
    }

    fun addSetOnClick(item: Item, view: View) {
        view.setOnClickListener {
            val intent = Intent(this@BoardPractice, BoardItem_Detail::class.java)

            intent.putExtra("name", item.name)
            intent.putExtra("text", item.text)

            startActivity(intent)
        }
    }
}

class Item(val name: String, val text: String) {

}

class Board() {

    val itemlist = ArrayList<Item>()

    fun addItem(item: Item) {
        itemlist.add(item)
    }
}