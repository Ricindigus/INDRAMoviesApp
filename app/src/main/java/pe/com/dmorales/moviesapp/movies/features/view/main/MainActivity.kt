package pe.com.dmorales.moviesapp.movies.features.view.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.koin.android.ext.android.inject
import pe.com.dmorales.moviesapp.R
import pe.com.dmorales.moviesapp.databinding.ActivityMainBinding
import pe.com.dmorales.moviesapp.login.features.view.LoginActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private val mViewModel by inject<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        mBinding.viewModel = mViewModel
        mBinding.lifecycleOwner = this
        setContentView(mBinding.root)
        NavigationUI.setupActionBarWithNavController(this,
            findNavController(R.id.nav_host_fragment))
        subscribeObservers()
    }

    private fun subscribeObservers() {
        mViewModel.navigateToLogin.observe(this){
            it?.let {
                startActivity(LoginActivity.getIntent(this))
                finish()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout-> mViewModel.onClickItemLogout()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }

    companion object{
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}