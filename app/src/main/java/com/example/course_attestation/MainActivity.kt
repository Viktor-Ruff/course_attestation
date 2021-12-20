package com.example.course_attestation
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.course_attestation.Constance.Blogger
import com.example.course_attestation.Constance.Director
import com.example.course_attestation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bkImage.setBackgroundResource(R.drawable.background_image)

        binding.btCheck.setOnClickListener {

            val nameUser = binding.edName.text.toString()
            Log.d("MyLog", "Result = $nameUser")

            when(nameUser){
                Director -> {
                    binding.tvResult.visibility = View.INVISIBLE
                    binding.edName.visibility = View.INVISIBLE
                    binding.edPassword.visibility = View.VISIBLE

                    binding.btCheck.setOnClickListener{
                        binding.tvResult.visibility = View.VISIBLE
                        binding.imView.visibility = View.VISIBLE
                        val PasswordUser = binding.edPassword.text.toString().toInt()

                        when(PasswordUser){
                            Constance.Director_Password ->{
                                val secondActivityIntent = Intent(this, SecondActivity2::class.java)
                                secondActivityIntent.putExtra(HELLO_KEY2, (getString(R.string.hello)+" $Director"))
                                startActivity(secondActivityIntent)
                            }

                            else -> {
                                binding.tvResult.text = getString(R.string.incorrect_password)
                                binding.tvResult.setBackgroundColor(Color.RED)
                                binding.imView.setImageResource(R.drawable.unsuccess)
                                Log.d("MyLog", "Success = ${R.drawable.unsuccess}")
                            }

                        }

                    }

                }

                Blogger -> {

                    binding.tvResult.visibility = View.INVISIBLE
                    binding.edName.visibility = View.INVISIBLE
                    binding.edPassword.visibility = View.VISIBLE

                    binding.btCheck.setOnClickListener{
                        binding.tvResult.visibility = View.VISIBLE
                        binding.imView.visibility = View.VISIBLE
                        val PasswordUser = binding.edPassword.text.toString().toInt()

                        when(PasswordUser){
                            Constance.Blogger_Password ->{
                                val secondActivityIntent = Intent(this, SecondActivity1::class.java)
                                secondActivityIntent.putExtra(HELLO_KEY1, (getString(R.string.hello)+" $Blogger"))
                                startActivity(secondActivityIntent)
                            }

                            else -> {
                                binding.tvResult.text = getString(R.string.incorrect_password)
                                binding.tvResult.setBackgroundColor(Color.RED)
                                binding.imView.setImageResource(R.drawable.unsuccess)
                                Log.d("MyLog", "Success = ${R.drawable.unsuccess}")
                            }

                        }

                    }

                }

                else -> {
                    binding.tvResult.visibility = View.VISIBLE
                    binding.tvResult.text = getString(R.string.could_not_find_employee)
                }

            }

        }

    }

}