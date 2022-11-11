package com.juni.listapeliculas.ui.fragments


import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.juni.listapeliculas.databinding.FragmentLoginBinding
import java.lang.ClassCastException

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    interface ListSelectListener{
        fun showMovieList()
    }


    private lateinit var listSelectListener: ListSelectListener


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listSelectListener=try {
            context as ListSelectListener
        }catch (e: ClassCastException){
            throw ClassCastException("$context debe implementar ListSelectListener")
        }
    }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameEditText = binding.username
        val passwordEditText = binding.password
        val loginButton = binding.login
        val loadingProgressBar = binding.loading


        loginButton.setOnClickListener {
            loadingProgressBar.visibility=View.VISIBLE
            var user:String= usernameEditText.text.trim().toString()
            var pass:String=passwordEditText.text.trim().toString()
            if (user.isNotEmpty() && pass.isNotEmpty()){
               // if (user.equals("Admin") && pass.equals("123")){

                   if (user.equals("Admin") && pass.equals("Password*123")){
                        loadingProgressBar.visibility=View.GONE
                        listSelectListener.showMovieList()
                    }else{
                        loadingProgressBar.visibility=View.GONE
                        Log.d("hola","Datos incorrectos: ${user}/${pass} ")
                        showMsj("Datos incorrectos: ${user}/${pass}")
                    }
            }else{
                    loadingProgressBar.visibility=View.GONE
                    showMsj("Faltan datos")
            }

            }

    }

    private fun showMsj(string: String){
        Toast.makeText(context,string,Toast.LENGTH_SHORT).show()
        hideKeyBoard()

    }

    private fun hideKeyBoard(){
        val inputMethodManager = activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }


}