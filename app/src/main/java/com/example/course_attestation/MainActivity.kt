package com.example.course_attestation
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.course_attestation.Constance.Directors
import com.example.course_attestation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bkImage.setBackgroundResource(R.drawable.background_image1)

        binding.btCheck.setOnClickListener {
            val nameUser = binding.edName.text.toString()
            Log.d("MyLog", "Result = $nameUser")

            for (listUser in Directors) {
                if (listUser == nameUser){
                    binding.tvResult.visibility = View.INVISIBLE
                    binding.edName.visibility = View.INVISIBLE
                    binding.edPassword.visibility = View.VISIBLE

                    binding.btCheck.setOnClickListener{
                        binding.tvResult.visibility = View.VISIBLE
                        binding.imView.visibility = View.VISIBLE
                        val passwordUser = binding.edPassword.text.toString()

                        when(passwordUser){
                            Constance.Director_Password ->{
                                val secondActivityIntent = Intent(this, SecondActivity2::class.java)
                                secondActivityIntent.putExtra(HELLO_KEY2, (getString(R.string.hello)+" $nameUser"))
                                startActivity(secondActivityIntent)
                            }
                            Constance.Blogger_Password ->{
                                val secondActivityIntent = Intent(this, SecondActivity1::class.java)
                                secondActivityIntent.putExtra(HELLO_KEY1, (getString(R.string.hello)+" $nameUser"))
                                startActivity(secondActivityIntent)
                            }
                            else -> {
                                binding.tvResult.text = getString(R.string.incorrect_password)
                                binding.tvResult.setBackgroundColor(Color.RED)
                                binding.imView.setImageResource(R.drawable.unsuccess)
                            }
                        }
                    }
                    Log.d("MyLog", "list: $listUser")
                    break
                }
                if (listUser != nameUser)
                binding.tvResult.visibility = View.VISIBLE
                binding.tvResult.setBackgroundColor(Color.RED)
                binding.tvResult.text = getString(R.string.could_not_find_employee)
            }
        }
    }
}