package com.example.smack.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smack.Model.Message
import com.example.smack.R
import com.example.smack.Services.UserDataService

class MessageAdapter(val context: Context, val messages: ArrayList<Message>) :RecyclerView.Adapter<MessageAdapter.MessageHolder>() {

    inner class MessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage = itemView.findViewById<ImageView>(R.id.messageUserImage)
        val timeStamp = itemView.findViewById<TextView>(R.id.timeStampLbl)
        val userName = itemView.findViewById<TextView>(R.id.messageUserNameLbl)
        val messageBody = itemView.findViewById<TextView>(R.id.messageBodyLbl)

        fun bindMessage(context: Context, message: Message) {
            val resourceId = context.resources.getIdentifier(message.userAvatar, "drawable", context.packageName)
            userImage.setImageResource(resourceId)
            userImage.setBackgroundColor(UserDataService.returnAvatarColor(message.userAvatarColor))
            userName.text = message.userName
            timeStamp.text = message.timeStamp
            messageBody.text = message.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.message_list_view, parent, false)
        return MessageHolder(view)
    }

    override fun getItemCount(): Int {
        return messages.count()
    }

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        holder.bindMessage(context, messages[position])
    }
}