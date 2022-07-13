package dev.bakhita.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import dev.bakhita.mycontacts.databinding.ActivityViewContactBinding

class viewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtra()
    }
    fun getExtra(){
        val extras = intent.extras
        var name=extras?.getString("NAME", "name")
        var number=extras?.getString("PHONE_NUMBER", "number")
        var email=extras?.getString("EMAIL", "email")
        var address=extras?.getString("ADDRESS", "address")
        var image=binding.imgPerson

        Toast.makeText(this, name, Toast.LENGTH_LONG).show()

        binding.tvNames.text=name
        binding.tvAddresses.text=address
        binding.tvEmails.text=email
        binding.tvNumbers.text=number
        Picasso.get().load(intent.getStringExtra("IMAGE")).into(image)

    }
}