package dev.bakhita.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.recyclerview.widget.LinearLayoutManager
import dev.bakhita.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()
    }
    fun displayContacts() {
        var contact1 = Contacts("Bakhita", "0700892520", "bakky@gmail.com", "616 Korongo Road", "https://images.pexels.com/photos/1820919/pexels-photo-1820919.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact2 = Contacts("Minaj", "0711476132", "minaj@gmail.com", "212 Pangani Kilifi", "https://images.pexels.com/photos/938013/pexels-photo-938013.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact3 = Contacts("Alinda", "0789243546", "alinda@gmail.com", "523 Kampala Ugunja", "https://images.pexels.com/photos/818819/pexels-photo-818819.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact4 = Contacts("Wanda", "0798365241", "wanda@gmail.com", "789 Kileleshwa South", "https://images.pexels.com/photos/1164674/pexels-photo-1164674.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact5 = Contacts("Wanji", "0786533784", "wanji@gmail.com", "276 Kilimani North", "https://images.pexels.com/photos/718978/pexels-photo-718978.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact6 = Contacts("Misky", "0765432189", "misky@gmail.com", "265 South B", "https://images.pexels.com/photos/871495/pexels-photo-871495.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact7 = Contacts("Sangwa", "0765894321", "sangwa@gmail.com", "567 Central Gwanda", "https://images.pexels.com/photos/935985/pexels-photo-935985.jpeg?auto=compress&cs=tinysrgb&w=400")

        var contactsList = listOf(contact1, contact2, contact3, contact4, contact5, contact6, contact7)
        var contactsAdapter = ContactRecyclerViewAdapter(contactsList)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = contactsAdapter
    }
}