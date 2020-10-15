package com.javadsh98.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import com.javadsh98.module1.User
import com.javadsh98.module1.UserDao
import com.javadsh98.module1.UserDataBase
import kotlinx.android.synthetic.main.fragment_register.*
import org.koin.android.ext.android.inject


class RegisterFragment : Fragment(R.layout.fragment_register) {

    val db by inject<UserDataBase>()
    val dao by inject<UserDao>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_submit.setOnClickListener {
            if(!textinputedittext_username.text.isNullOrEmpty()
                && !textinputedittext_firstname.text.isNullOrEmpty()
                && !textinputedittext_lastname.text.isNullOrEmpty()
                && !textinputedittext_email.text.isNullOrEmpty()
                && !textinputedittext_password.text.isNullOrEmpty()){
                db.runInTransaction {
                    dao.insert(User(0
                        , textinputedittext_username.text.toString()
                        , textinputedittext_firstname.text.toString()
                        , textinputedittext_lastname.text.toString()
                        , textinputedittext_lastname.text.toString()
                        , textinputedittext_email.text.toString()
                        , )
                    )
                }
                val action = "main".toUri()
                findNavController().navigate(action)
            }
        }

        button_login.setOnClickListener {
            val action = "login".toUri()
            findNavController().navigate(action)
        }

    }

}