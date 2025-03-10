package com.hostelworld.qacodechallenge

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import com.hostelworld.qacodechallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var userLogin: ActivityResultLauncher<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI(binding)

        // Initialize the activity result launcher properly
        userLogin = registerForActivityResult(UserLoginContract()) { user: User? ->
            user?.let {
                val userDetailsIntent = UserDetailsActivity.intent(this, it)
                startActivity(userDetailsIntent)
            }
        }
    }

    private fun setupUI(binding: ActivityMainBinding) = with(binding) {
        btnCreateAccount.setOnClickListener {
            startActivity(Intent(this@MainActivity, CreateAccountActivity::class.java))
        }

        btnLogin.setOnClickListener {
            userLogin.launch(Unit) // Pass a valid input (Unit is often used when no input is needed)
        }
    }
}

// Move the ActivityResultContract to its own class
class UserLoginContract : ActivityResultContract<Any, User?>() {
    override fun createIntent(context: Context, input: Any): Intent {
        return LoginActivity.intent(context)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): User? {
        return intent?.takeIf { resultCode == Activity.RESULT_OK }
            ?.getSerializableExtra(LoginActivity.RESULT_USER) as? User
    }
}