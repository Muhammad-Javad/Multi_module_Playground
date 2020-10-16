package com.javadsh98.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.javadsh98.module1.UserDao
import com.javadsh98.module1.UserDataBase
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject


class LoginFragment : Fragment(R.layout.fragment_login) {

    val db by inject<UserDataBase>()
    val dao by inject<UserDao>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_login.setOnClickListener {
            if (!textinputedittext_username.text.toString().isNullOrEmpty()
                && !textinputedittext_password.text.toString().isNullOrEmpty()){

                dao.hasThisUser(textinputedittext_username.text.toString()
                    , textinputedittext_password.text.toString()).observe(viewLifecycleOwner, Observer {
                    it?.let {
                        val action = "mains://main".toUri()
                        findNavController().navigate(action,
                        NavOptions.Builder()
                            .setPopUpTo(R.id.loginFragment, true)
                            .build())
                    }
                })

            }

        }

        button_register.setOnClickListener {
            val action = "registers://register".toUri()
            findNavController().navigate(action)
        }

    }

}