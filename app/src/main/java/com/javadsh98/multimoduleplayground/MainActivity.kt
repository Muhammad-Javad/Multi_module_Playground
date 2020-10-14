package com.javadsh98.multimoduleplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.javadsh98.module1.JDataBase
import com.javadsh98.module1.Javad
import com.javadsh98.module1.JavadDao
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val dao by inject<JavadDao>()
    val db by inject<JDataBase>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..10){
            db.runInTransaction {
                dao.insert(Javad(10 + i))
            }
        }

        setupObserver()
    }

    private fun setupObserver() {

        dao.getjavad().observe(this, Observer {
            for (e in it){
                textview.append("age : ${e.age}\n")
            }
        })

    }
}