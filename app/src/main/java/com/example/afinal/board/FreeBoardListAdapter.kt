package com.example.afinal.board

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.afinal.R
import com.example.afinal.VO.board

class FreeBoardListAdapter(val boardList:ArrayList<board>
): BaseAdapter(){

    override fun getCount(): Int {
        return boardList.size
    }

    override fun getItem(position: Int): Any {
        return boardList[position]

    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view :View  = LayoutInflater.from(parent?.context).inflate(R.layout.board_list_item, parent, false)


        val title = view.findViewById<TextView>(R.id.titleArea)
        val content = view.findViewById<TextView>(R.id.contentArea)
        val time = view.findViewById<TextView>(R.id.timeArea)
        val name = view.findViewById<TextView>(R.id.nameArea)

        val board = boardList[position]

        title.text=board.title
        content.text=board.contents
        time.text=board.time
        name.text=board.email

        return view


    }


}

