package pe.com.dmorales.moviesapp.splash.features.view

import android.content.Intent.getIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import pe.com.dmorales.moviesapp.MainActivity
import pe.com.dmorales.moviesapp.databinding.ActivitySplashBinding

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
                startActivity(MainActivity.getIntent(this))
                mViewModel.doneNavigateToLogin()
                finish()
            }
        }
    }
}