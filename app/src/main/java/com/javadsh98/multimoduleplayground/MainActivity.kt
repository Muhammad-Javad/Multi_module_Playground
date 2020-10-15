package com.javadsh98.multimoduleplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.javadsh98.module1.UserDataBase
import com.javadsh98.module1.User
import com.javadsh98.module1.UserDao
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val dao by inject<UserDao>()
    val db by inject<UserDataBase>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..10){
            db.runInTransaction {
                dao.insert(User(10 + i))
            }
        }

        setupObserver()
    }

    private fun setupObserver() {

        dao.getUsers().observe(this, Observer {
            for (e in it){
                textview.append("age : ${e.age}\n")
            }
        })

    }
}