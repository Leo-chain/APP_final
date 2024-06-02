package com.example.kitchenapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class CommentItem(val userName: String, val timestamp: String, val commentText: String)

class CommentAdapter(private val commentList: List<CommentItem>) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.comment_user_name)
        val timestamp: TextView = itemView.findViewById(R.id.comment_timestamp)
        val commentText: TextView = itemView.findViewById(R.id.comment_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = commentList[position]
        holder.userName.text = comment.userName
        holder.timestamp.text = comment.timestamp
        holder.commentText.text = comment.commentText
    }

    override fun getItemCount() = commentList.size
}

class activity_comment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_comment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 初始化 RecyclerView
        val commentList = findViewById<RecyclerView>(R.id.comment_list)
        commentList.layoutManager = LinearLayoutManager(this)

        val comments = listOf(
            CommentItem("huli", "2016-12-22T17:01:53.248Z", "大家好"),
            CommentItem("huli", "1482425574452", "hey~~"),
            CommentItem("pop", "發佈時間", "你好啊"),
            CommentItem("peter", "發佈時間", "啊啊啊啊啊啊啊啊")
        )

        val commentAdapter = CommentAdapter(comments)
        commentList.adapter = commentAdapter
    }
}
