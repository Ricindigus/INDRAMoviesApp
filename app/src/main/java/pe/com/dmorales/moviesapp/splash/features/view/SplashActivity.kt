package pe.com.dmorales.moviesapp.splash.features.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import pe.com.dmorales.moviesapp.databinding.ActivitySplashBinding
import pe.com.dmorales.moviesapp.login.features.view.LoginActivity
import pe.com.dmorales.moviesapp.movies.features.view.main.MainActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySplashBinding
    private val mViewModel by inject<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySplashBinding.inflate(layoutInflater)
        mBinding.viewModel = mViewModel
        mBinding.lifecycleOwner = this
        setContentView(mBinding.root)
        subscribeObservers()
        mViewModel.checkSessionUser()
    }

    private fun subscribeObservers() {
        mViewModel.navigateToLogin.observe(this){
            it?.let {
                startActivity(LoginActivity.getIntent(this))
                mViewModel.doneNavigateToLogin()
                finish()
            }
        }

        mViewModel.navigateToMain.observe(this){
            it?.let {
                startActivity(MainActivity.getIntent(this))
                mViewModel.doneNavigateToMain()
                finish()
            }
        }
    }
}