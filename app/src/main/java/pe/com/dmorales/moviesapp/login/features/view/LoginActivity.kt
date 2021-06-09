package pe.com.dmorales.moviesapp.login.features.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import pe.com.dmorales.moviesapp.MainActivity
import pe.com.dmorales.moviesapp.core.utils.toast
import pe.com.dmorales.moviesapp.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityLoginBinding
    private val mViewModel by inject<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        mBinding.viewModel = mViewModel
        mBinding.lifecycleOwner = this
        setContentView(mBinding.root)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        mViewModel.usernameValue.observe(this) {
            mViewModel.validateFields()
        }

        mViewModel.passwordValue.observe(this) {
            mViewModel.validateFields()
        }

        mViewModel.initSessionUser.observe(this){ show ->
            if (show) navigateToMainActivity()
        }

        mViewModel.showErrorCredentials.observe(this){ show ->
            if (show) toast("Error en las credenciales")
        }
    }

    private fun navigateToMainActivity() {
        startActivity(MainActivity.getIntent(this))
        finish()
    }

    companion object{
        fun getIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }
}