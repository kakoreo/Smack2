package com.example.smack.Controller

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.smack.R
import kotlinx.android.synthetic.main.activity_create_user.*

class CreateUserActivity : AppCompatActivity() {

    var userAvatar = "profileDefault"  //アバターを選ばなかったときのデフォルトアイコン
    var avatarColor = "[0.5, 0.5, 0.5, 1]"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun createAvatarImageViewClicked(view: View) {
        val random = java.util.Random()
        val color = random.nextInt(2) //黒か白か
        val avatar = random.nextInt(28) //アバターの数28種類

        //ifを使って、アバターの色、種類を分ける
        if (color == 0) {
            userAvatar = "light$avatar"
        } else {
            userAvatar = "dark$avatar"
        }

        val resourceId = resources.getIdentifier(userAvatar, "drawable", packageName)
        createAvatarImageView.setImageResource(resourceId)


    }
//  RGB colorもRGBごとにランダムな数字を与える
    fun createBackgroundColorBtnClicked(view: View) {
        val random = java.util.Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        createAvatarImageView.setBackgroundColor(Color.rgb(r, g, b))

//    ios用に3桁の数字を0-1までの数字に変換する
        val savedR = r.toDouble() /255
        val savedG = g.toDouble() /255
        val savedB = b.toDouble() /255

        avatarColor = "[$savedR, $savedG, $savedB, 1]"

    }

    fun createUserBtnClucked(view: View) {

    }
}
